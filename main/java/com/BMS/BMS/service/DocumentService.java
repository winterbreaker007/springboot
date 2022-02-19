package com.blackwater.blackwaterbillingmanagementsystem.service;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Document;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.DocumentRepository;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class DocumentService {
  private static final Logger logger = LoggerFactory.getLogger(DocumentService.class);

  DocumentRepository documentRepository;
  private static final int maxRetries = 3;
  private static final long waitTimeInSeconds = (long) 0.5;

  private static final String IMAGE_DIRECTORY = "uploads/";
  private static final String DOCUMENT_DIRECTORY = "documents/";
  private static final String DOCUMENT_ENDPOINT = "/documents/file/";

  @Autowired
  private AmazonS3 amazonS3;

  @Value("${aws.s3.bucket}")
  private String bucketName;

  @Value("${aws.endpoint}")
  private String awsEndPoint;

  // Email
  private SendGrid sendGrid;
  @Value("${sendgrid.api_key}")
  private String SendGridAPIKey;

  private SimpleDateFormat dateFormater = new SimpleDateFormat("yyMMddhhmmssMs");

  // for PDF convert
  private static final float PageMargin = 42;
  private static final float PageMarginTop = 56;
  private static final float FontSize = 14;
  private static final float LineHightMultiple = 1.5f;
  private static final PDFont Font = PDType1Font.TIMES_ROMAN;

  private double currentHeight = 0;
  private PDPageContentStream cs = null;

  public DocumentService(DocumentRepository documentRepository) {
    this.documentRepository = documentRepository;
  }

  public Document updateDocument(Document updatedDocument) throws Exception {
    int retryCount = 0;
    Document savedDocument = null;
    while (Objects.isNull(savedDocument) && retryCount < maxRetries) {
      try {
        savedDocument = documentRepository.save(updatedDocument);
      } catch (Exception e) {
        retryCount++;
        logger.debug("Saving document " + updatedDocument.getId() + " failed! Waiting " + waitTimeInSeconds
            + " second(s) before retry attempt " + retryCount);
        logger.error(e.getMessage());
        TimeUnit.SECONDS.sleep(waitTimeInSeconds);
      }
    }
    return savedDocument;
  }

  private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
    final File file = new File(multipartFile.getOriginalFilename());
    try (final FileOutputStream outputStream = new FileOutputStream(file)) {
      outputStream.write(multipartFile.getBytes());
    } catch (final IOException ex) {
      logger.error("Error converting the multi-part file to file= ", ex.getMessage());
    }
    return file;
  }

  private String uploadFileToS3Bucket(final String bucketName, final File file) {
    return uploadFileToS3Bucket(bucketName, file, file.getName());
  }

  
  private String deleteFileToS3Bucket(final String bucketName, final String fileName) {
    try {
      logger.info("Uploading file with name= " + DOCUMENT_DIRECTORY + fileName);
      final DeleteObjectRequest putObjectRequest = new DeleteObjectRequest(bucketName, DOCUMENT_DIRECTORY + fileName);
      amazonS3.deleteObject(putObjectRequest);
      logger.debug("deleted result");
    } catch (Exception e) {
      logger.info("File error, cannot find the file");
    }

    return "ok";
  }

  
  private String uploadImageToS3Bucket(final String bucketName, final File file) {
	    // final String uniqueFileName = dateFormater.format(new Date()) + "_" +
	    // file.getName().replace(" ", "_");
	    final String uniqueFileName = file.getName().replace(" ", "_");
	    logger.info("Uploading file with name= " + uniqueFileName);

	    final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, IMAGE_DIRECTORY + uniqueFileName, file);
	    PutObjectResult res = amazonS3.putObject(putObjectRequest);

	    logger.debug("Uploaded result" + res.toString());

	    return IMAGE_DIRECTORY + uniqueFileName;
	  }

  private String uploadFileToS3Bucket(final String bucketName, final File file, final String fileName) {

    final String uniqueFileName =  fileName.replace(" ", "_");
    logger.info("Uploading file with name= " + uniqueFileName);

    final PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, DOCUMENT_DIRECTORY + uniqueFileName,
        file);
    PutObjectResult res = amazonS3.putObject(putObjectRequest);

    logger.debug("Uploaded result" + res.toString());

    return DOCUMENT_ENDPOINT + uniqueFileName;
  }

  // @Async annotation ensures that the method is executed in a different
  // background thread
  // but not consume the main thread.
  @Async
  public String uploadFile(final MultipartFile multipartFile) {
    logger.info("File upload in progress.");
    String fileUrl = "";
    try {
      final File file = convertMultiPartFileToFile(multipartFile);      
      fileUrl = uploadFileToS3Bucket(bucketName, file);
//      fileUrl = awsEndPoint +  fileUrl;
      logger.info("File upload is completed.");
      file.delete(); // To remove the file locally created in the project folder.
    } catch (final AmazonServiceException ex) {
      logger.info("File upload is failed.");
      logger.error("Error= {} while uploading file.", ex.getMessage());
    }
    return fileUrl;
  }
  @Async
  public String uploadImage(final MultipartFile multipartFile) {
    logger.info("Image upload in progress.");
    String fileUrl = "";
    try {
      final File file = convertMultiPartFileToFile(multipartFile);      
      fileUrl = uploadImageToS3Bucket(bucketName, file);
      fileUrl = awsEndPoint  + "/"+fileUrl;
      logger.info("File upload is completed.");
      file.delete(); // To remove the file locally created in the project folder.
    } catch (final AmazonServiceException ex) {
      logger.info("File upload is failed.");
      logger.error("Error= {} while uploading file.", ex.getMessage());
    }
    return fileUrl;
  }
  @Async
  public String deleteFile(final String file) {
    logger.info("File delete in progress.");
    String res = "";
    try {

      res = deleteFileToS3Bucket(bucketName, file);
      logger.info("File remove is completed.");
    } catch (final AmazonServiceException ex) {
      logger.info("File upload is failed.");
      logger.error("Error= {} while uploading file.", ex.getMessage());
      res = "Failed to delete: " + file;
    }

    return res;
  }

  // @Async annotation ensures that the method is executed in a different
  // background thread
  // but not consume the main thread.

  @Async
  public byte[] downloadFile(final String fileName) {
    byte[] content = null;
    logger.info("Downloading an object with key= " + fileName);
    final S3Object s3Object = amazonS3.getObject(bucketName, DOCUMENT_DIRECTORY + fileName);
    final S3ObjectInputStream stream = s3Object.getObjectContent();
    try {
      content = IOUtils.toByteArray(stream);
      logger.info("File downloaded successfully.");
      s3Object.close();
    } catch (final IOException ex) {
      logger.info("IO Error Message= " + ex.getMessage());
    }
    return content;
  }

  // @Async annotation ensures that the method is executed in a different
  // background thread
  // but not consume the main thread.
  @Async
  public String duplicateFile(final Document document) throws Exception {
    try {
      String orgFileName = document.getUrl().replace(DOCUMENT_ENDPOINT, "");
      String newFileName = "copy_of_" + orgFileName;
      amazonS3.copyObject(bucketName, DOCUMENT_DIRECTORY + orgFileName, bucketName, DOCUMENT_DIRECTORY + newFileName);

      return DOCUMENT_ENDPOINT + newFileName;
    } catch (Exception ex) {
      logger.info("Error on duplicating document file:" + ex.getMessage());
      throw ex;
    }
  }

  public String getContentType(String fileName) {
    final S3Object s3Object = amazonS3.getObject(bucketName, DOCUMENT_DIRECTORY + fileName);
    String contentType = s3Object.getObjectMetadata().getContentType();
    try {
      s3Object.close();
    } catch (IOException ex) {
      logger.debug("Getting content type error: ", ex.getMessage());
      ex.printStackTrace();
    }

    return contentType;
  }

  // Email operations
  @Async
  public boolean sendEmail(List<Document> documents, String from, String to, String cc, String bcc, String subject,
      String message) {
    if (this.sendGrid == null) {
      this.sendGrid = new SendGrid(SendGridAPIKey);
    }

    Email fromEmail = new Email(from);
    Email toEmail = new Email(to);
    Content content = new Content("text/html", message);

    Mail mail = new Mail(fromEmail, subject, toEmail, content);

    if (cc != null && !cc.isBlank()) {
      mail.personalization.get(0).addCc(new Email(cc));
    }
    if (bcc != null && !bcc.isBlank()) {
      mail.personalization.get(0).addBcc(new Email(bcc));
    }

    try {
      for (int i = 0; i < documents.size(); i++) {
        addAttachment(mail, documents.get(i));
      }

      Request request = new Request();
      Response response = null;

      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());

      response = sendGrid.api(request);

      logger.debug("Send email status code: " + response.getStatusCode());
      logger.debug("Send email body: " + response.getBody());
      logger.debug("Send email headers: " + response.getHeaders());

      return HttpStatus.valueOf(response.getStatusCode()).is2xxSuccessful();
    } catch (IOException ex) {
      logger.debug("Send email error: ", ex.getMessage());
      return false;
    }
  }

  @Async
  public boolean sendEmail(String from, String to, String cc, String bcc, String subject,
      String message) {
    if (this.sendGrid == null) {
      this.sendGrid = new SendGrid(SendGridAPIKey);
    }

    Email fromEmail = new Email(from);
    Email toEmail = new Email(to);
    Content content = new Content("text/html", message);

    Mail mail = new Mail(fromEmail, subject, toEmail, content);

    if (cc != null && !cc.isBlank()) {
      mail.personalization.get(0).addCc(new Email(cc));
    }
    if (bcc != null && !bcc.isBlank()) {
      mail.personalization.get(0).addBcc(new Email(bcc));
    }

    try {

      Request request = new Request();
      Response response = null;

      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());

      response = sendGrid.api(request);

      logger.debug("Send email status code: " + response.getStatusCode());
      logger.debug("Send email body: " + response.getBody());
      logger.debug("Send email headers: " + response.getHeaders());

      return HttpStatus.valueOf(response.getStatusCode()).is2xxSuccessful();
    } catch (IOException ex) {
      logger.debug("Send email error: ", ex.getMessage());
      return false;
    }
  }
  
  private void addAttachment(Mail mail, Document document) throws IOException {
    String docFileName = document.getUrl().replace(DOCUMENT_ENDPOINT, "");
    final S3Object s3Object = amazonS3.getObject(bucketName, DOCUMENT_DIRECTORY + docFileName);

    try (final InputStream inputStream = s3Object.getObjectContent()) {
      final Attachments attachments = new Attachments.Builder(docFileName, inputStream)
          .build();
      mail.addAttachments(attachments);
    }

    try {
      s3Object.close();
    } catch (IOException ex) {
      logger.debug("Error on adding attachment: ", ex.getMessage());
      ex.printStackTrace();
    }
  }

  // PDF operations
  @Async
  public String mergePDFs(final List<Document> documents, final String fileName) throws Exception {
    logger.info("Merging documents in progress.");
    PDFMergerUtility ut = new PDFMergerUtility();

    try {
      for (int i = 0; i < documents.size(); i++) {
        String docFileName = documents.get(i).getUrl().replace(DOCUMENT_ENDPOINT, "");
        final S3Object s3Object = amazonS3.getObject(bucketName, DOCUMENT_DIRECTORY + docFileName);
        final S3ObjectInputStream stream = s3Object.getObjectContent();
        final byte[] content = IOUtils.toByteArray(stream);
        ut.addSource(new ByteArrayInputStream(content));
        s3Object.close();
      }

      Path temp = Files.createTempFile("", ".tmp");

      String absolutePath = temp.toString();

      ut.setDestinationFileName(absolutePath);
      ut.mergeDocuments(null);

      String fileUrl = uploadFileToS3Bucket(bucketName, temp.toFile(), fileName);
      temp.toFile().delete();

      logger.info("Merging documents is completed.");

      return fileUrl;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw ex;
    }
  }

  @Async
  public String convertTextToPDF(final Document document, final String fileName) throws IOException {
    logger.info("Converting document in progress.");

    try {
      PDDocument pdfDoc = new PDDocument();
      // create buffered reader for text file
      String docFileName = document.getUrl().replace(DOCUMENT_ENDPOINT, "");
      final S3Object s3Object = amazonS3.getObject(bucketName, DOCUMENT_DIRECTORY + docFileName);
      final S3ObjectInputStream stream = s3Object.getObjectContent();
      byte[] content = IOUtils.toByteArray(stream);
      BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content)));
      s3Object.close();

      PDPage page = new PDPage(PDRectangle.A4);
      // add page to the PDF document
      pdfDoc.addPage(page);
      PDRectangle mediabox = page.getMediaBox();
      float width = mediabox.getWidth() - 2 * PageMargin;
      float height = mediabox.getHeight() - PageMarginTop - PageMargin;
      float startX = mediabox.getLowerLeftX() + PageMargin;
      float startY = mediabox.getUpperRightY() - PageMarginTop;

      String line;
      cs = new PDPageContentStream(pdfDoc, page);
      cs.beginText();
      currentHeight = LineHightMultiple * FontSize;
      cs.setFont(PDType1Font.TIMES_ROMAN, FontSize);
      cs.newLineAtOffset(startX, startY - LineHightMultiple * FontSize);
      cs.setLeading(LineHightMultiple * FontSize);

      // Read text file line by line
      while ((line = br.readLine()) != null) {
        System.out.println("Line-- " + line);
        showMultiLineText(pdfDoc, line, (int) startX, (int) startY, (int) width, (int) height, page);
      }
      if (cs != null) {
        cs.endText();
        cs.close();
      }

      Path temp = Files.createTempFile("", ".tmp");

      String absolutePath = temp.toString();

      pdfDoc.save(absolutePath);
      br.close();
      pdfDoc.close();

      String fileUrl = uploadFileToS3Bucket(bucketName, temp.toFile(), fileName);
      temp.toFile().delete();

      logger.info("Converting document is completed.");

      return fileUrl;
    } catch (final IOException ex) {
      ex.printStackTrace();
      throw ex;
    }
  }

  private void showMultiLineText(PDDocument pdfDoc, String text, int startX, int startY, int allowedWidth,
      double allowedHeight, PDPage page) throws IOException {
    List<String> lines = new ArrayList<String>();
    String line = "";
    // split the text on spaces
    String[] words = text.split(" ");
    for (String word : words) {
      if (!line.isEmpty()) {
        line += " ";
      }
      // check if adding the word to the line surpasses the width of the page
      int size = (int) (FontSize * Font.getStringWidth(line + word) / 1000);
      if (size > allowedWidth) {
        // if line + word surpasses the width of the page, add the line without the
        // current word
        lines.add(line);
        // start new line with the current word
        line = word;
      } else {
        // if line + word fits the page width, add the current word to the line
        line += word;
      }
    }
    lines.add(line);

    for (String ln : lines) {
      System.out.println("Line- " + ln);
      // for each line add line height to current height
      currentHeight = currentHeight + LineHightMultiple * FontSize;

      if (currentHeight >= allowedHeight) {
        System.out.println("adding new page " + currentHeight);
        // When current height is more than allowed height for the page
        // create a new page
        page = new PDPage(PDRectangle.A4);
        // add page to the PDF document
        pdfDoc.addPage(page);
        // reset currentHeight
        cs.endText();
        cs.close();
        cs = new PDPageContentStream(pdfDoc, page);
        cs.beginText();
        currentHeight = LineHightMultiple * FontSize;
        cs.setFont(Font, FontSize);
        cs.newLineAtOffset(startX, startY - LineHightMultiple * FontSize);
        cs.setLeading(LineHightMultiple * FontSize);
      }
      cs.showText(ln);
      cs.newLine();
    }
  }

  @Async
  public String convertImageToPDF(final Document document, final String fileName) throws IOException {
    logger.info("Converting document in progress.");

    try {
      PDDocument pdfDoc = new PDDocument();
      // create byte array from image url
      logger.info("Downloading an object with key= " + fileName);
      String docFileName = document.getUrl().replace(DOCUMENT_ENDPOINT, "");
      final S3Object s3Object = amazonS3.getObject(bucketName, DOCUMENT_DIRECTORY + docFileName);
      final S3ObjectInputStream stream = s3Object.getObjectContent();
      byte[] content = IOUtils.toByteArray(stream);
      s3Object.close();
      PDImageXObject image = PDImageXObject.createFromByteArray(pdfDoc, content, docFileName);

      PDPage page = new PDPage(PDRectangle.A4);
      // add page to the PDF document
      pdfDoc.addPage(page);
      PDRectangle mediabox = page.getMediaBox();
      float width = mediabox.getWidth() - 2 * PageMargin;
      float height = mediabox.getHeight() - PageMarginTop - PageMargin;
      float startX = mediabox.getLowerLeftX() + PageMargin;
      float startY = mediabox.getUpperRightY() - PageMarginTop;

      Dimension pdfPageDim = new Dimension((int) width, (int) height);
      Dimension imageDim = new Dimension(image.getWidth(), image.getHeight());
      // Keep in mind the aspect ratio while scalling
      Dimension newDim = getScaledDimension(imageDim, pdfPageDim);

      int yOffset = (int) (startY - newDim.getHeight());

      cs = new PDPageContentStream(pdfDoc, page);
      cs.drawImage(image, (int) startX, yOffset, (int) newDim.getWidth(), (int) newDim.getHeight());
      cs.close();

      Path temp = Files.createTempFile("", ".tmp");

      String absolutePath = temp.toString();

      pdfDoc.save(absolutePath);
      pdfDoc.close();

      String fileUrl = uploadFileToS3Bucket(bucketName, temp.toFile(), fileName);
      temp.toFile().delete();

      logger.info("Converting document is completed.");

      return fileUrl;
    } catch (final IOException ex) {
      ex.printStackTrace();
      throw ex;
    }
  }

  private Dimension getScaledDimension(Dimension imgSize, Dimension boundary) {
    int original_width = imgSize.width;
    int original_height = imgSize.height;
    int bound_width = boundary.width;
    int bound_height = boundary.height;
    int new_width = original_width;
    int new_height = original_height;

    // first check if we need to scale width
    if (original_width > bound_width) {
      // scale width to fit
      new_width = bound_width;
      // scale height to maintain aspect ratio
      new_height = (new_width * original_height) / original_width;
    }

    // then check if we need to scale even with the new height
    if (new_height > bound_height) {
      // scale height to fit instead
      new_height = bound_height;
      // scale width to maintain aspect ratio
      new_width = (new_height * original_width) / original_height;
    }

    return new Dimension(new_width, new_height);
  }
  @Async
  public List<Document> getForms(final String companyId) {
    
    List<Document> forms=null;
    try {
    	forms=this.documentRepository.findFormsByCompanyId(companyId);
    } catch (final AmazonServiceException ex) {
      logger.info("Forms load err.");
    }
    return forms;

  }
}
