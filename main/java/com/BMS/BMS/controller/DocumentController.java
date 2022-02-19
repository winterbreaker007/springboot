package com.blackwater.blackwaterbillingmanagementsystem.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Document;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.DocumentRepository;
import com.blackwater.blackwaterbillingmanagementsystem.model.MergeRequestParam;
import com.blackwater.blackwaterbillingmanagementsystem.model.RequestParamIDs;
import com.blackwater.blackwaterbillingmanagementsystem.model.SendDocumentsAsEmailRequestParam;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.utils.Utils;

@RestController
@CrossOrigin
@RequestMapping(value = "/documents")
public class DocumentController {

	DocumentRepository repository;
	DocumentService service;
	
	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

	public DocumentController(DocumentRepository repository, DocumentService service) {
		this.repository = repository;
		this.service = service;
	}

	@GetMapping(value = "/getJobDocuments")
	public ResponseEntity<List<Document>> getJobDocuments(@RequestParam String jobId) {
		logger.debug("Request received for job documents");
		List<Document> jobDocuments = repository.findDocumentsByJobId(jobId);
		logger.debug("Sending job documents");
		return ResponseEntity.ok(jobDocuments);
	}

	@GetMapping(value = "/getJobImages")
	public ResponseEntity<List<Document>> getJobImages(@RequestParam String jobId) {
		logger.debug("Request received for job images");
		List<Document> jobImages = repository.findImagesByJobId(jobId);
		logger.debug("Sending job images");
		return ResponseEntity.ok(jobImages);
	}

	@GetMapping(value = "/getJobSketches")
	public ResponseEntity<List<Document>> getJobSketches(@RequestParam String jobId) {
		logger.debug("Request received for job images");
		List<Document> jobImages = repository.findSketchesByJobId(jobId);
		logger.debug("Sending job images");
		return ResponseEntity.ok(jobImages);
	}

	@GetMapping(value = "/getCompanyForms")
	public ResponseEntity<List<Document>> getCompanyForms(@RequestParam String companyId) {
		logger.debug("Request received for company forms");
		List<Document> companyForms = repository.findFormsByCompanyId(companyId);
		logger.debug("Sending company forms");
		return ResponseEntity.ok(companyForms);
	}

	@GetMapping(value = "/getClientReports")
	public ResponseEntity<List<Document>> getClientReports(@RequestParam String clientId) {
		logger.debug("Request received for client reports");
		List<Document> clientReports = repository.findReportsByClientId(clientId);
		logger.debug("Sending client reports");
		return ResponseEntity.ok(clientReports);
	}

	@PostMapping(value= "/addJobDocument")
	public ResponseEntity<Document> addJobDocument(
			@RequestPart String jobId,
			@RequestPart(value= "file") final MultipartFile multipartFile
	) {
		logger.debug("Request received for adding job document");
		String id = Utils.generateID();
		String fileUrl = service.uploadFile(multipartFile);
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		document.setUrl(fileUrl);
		document.setType(1);
		document.setParentId(jobId);
		document.setPermission(1);
		document.setCreatedDate(LocalDateTime.now().toString());
		document.setUpdatedDate(LocalDateTime.now().toString());
		logger.debug("Job document added" + document.toString());
		try {
			repository.save(document);
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value= "/addVisiteImage")
	public ResponseEntity<Document> addVisiteImage(
			@RequestPart String visiteId,
			@RequestPart(value= "file") final MultipartFile multipartFile
	) {
		logger.debug("Request received for visite image");
		String id = Utils.generateID();
		String fileUrl = service.uploadFile(multipartFile);
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		document.setUrl(fileUrl);
		document.setType(2);
		document.setParentId(visiteId);
		document.setPermission(1);
		document.setCreatedDate(LocalDateTime.now().toString());
		document.setUpdatedDate(LocalDateTime.now().toString());
		logger.debug("Visite image added" + document.toString());
		try {
			repository.save(document);
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value= "/addJobSketch")
	public ResponseEntity<Document> addJobSketch(
			@RequestPart String jobId,
			@RequestPart(value= "file") final MultipartFile multipartFile
	) {
		logger.debug("Request received for adding job sketch");
		String id = Utils.generateID();
		String fileUrl = service.uploadFile(multipartFile);
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		document.setUrl(fileUrl);
		document.setType(3);
		document.setParentId(jobId);
		document.setPermission(1);
		document.setCreatedDate(LocalDateTime.now().toString());
		document.setUpdatedDate(LocalDateTime.now().toString());
		logger.debug("Job sketch added" + document.toString());
		try {
			repository.save(document);
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value= "/addCompanyForm")
	public ResponseEntity<Document> addCompanyForm(
			@RequestPart String companyId,
			@RequestPart(value= "file") final MultipartFile multipartFile
	) {
		logger.debug("Request received for adding company form");
		String id = Utils.generateID();
		String fileUrl = service.uploadFile(multipartFile);
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		document.setUrl(fileUrl);
		document.setType(4);
		document.setParentId(companyId);
		document.setPermission(1);
		document.setCreatedDate(LocalDateTime.now().toString());
		document.setUpdatedDate(LocalDateTime.now().toString());
		logger.debug("Company form added" + document.toString());
		try {
			repository.save(document);
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value= "/addClientReport")
	public ResponseEntity<Document> addClientReport(
			@RequestPart String clientId,
			@RequestPart(value= "file") final MultipartFile multipartFile
	) {
		logger.debug("Request received for adding company form");
		String id = Utils.generateID();
		String fileUrl = service.uploadFile(multipartFile);
		Document document = new Document();
		document.setId(id);
		document.setName(multipartFile.getOriginalFilename());
		document.setUrl(fileUrl);
		document.setType(5);
		document.setParentId(clientId);
		document.setPermission(1);
		document.setCreatedDate(LocalDateTime.now().toString());
		document.setUpdatedDate(LocalDateTime.now().toString());
		logger.debug("Client report added" + document.toString());
		try {
			repository.save(document);
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Document> getDocument(@PathVariable("id") String id) {
		Document document = repository.findById(id);
		if (document == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(document);
	}

	@PostMapping(value= "/{id}/editName")
	public ResponseEntity<Document> editDocumentName(
			@PathVariable("id") String id,
			@RequestParam String name
	) {
		if (name == null || name == "") {
			return ResponseEntity.badRequest().body(null);
		}
		Document document = repository.findById(id);
		if (document == null) {
			return ResponseEntity.notFound().build();
		}
		document.setName(name);
		try {
			repository.save(document);
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value= "/{id}/edit")
	public ResponseEntity<Document> editDocument(
			@PathVariable("id") String id,
			@RequestPart(value= "file") final MultipartFile multipartFile
	) {
		if (multipartFile == null) {
			return ResponseEntity.badRequest().body(null);
		}
		Document document = repository.findById(id);
		if (document == null) {
			return ResponseEntity.notFound().build();
		}
		String fileUrl = service.uploadFile(multipartFile);
		document.setUrl(fileUrl);
		try {
			repository.save(document);
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@PostMapping(value= "/{id}/duplicate")
	public ResponseEntity<Document> duplicateDocument(
			@PathVariable("id") String id
	) {
		Document document = repository.findById(id);
		if (document == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			String fileUrl = service.duplicateFile(document);
			
			Document newDocument = new Document();
			newDocument.setId(Utils.generateID());
			newDocument.setName("Copy of " + document.getName());
			newDocument.setUrl(fileUrl);
			newDocument.setType(document.getType());
			newDocument.setParentId(document.getParentId());
			newDocument.setPermission(document.getPermission());
			newDocument.setCreatedDate(LocalDateTime.now().toString());
			newDocument.setUpdatedDate(LocalDateTime.now().toString());
			
			repository.save(newDocument);
			return ResponseEntity.ok(newDocument);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	

	@PostMapping(value= "/{id}/convert")
	public ResponseEntity<Document> convertDocument(@PathVariable("id") String id) {
		Document document = repository.findById(id);
		if (document == null) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			String fileURL = document.getUrl();
			String fileName = document.getName().split("\\.")[0] + ".pdf";
			String fileExtension = fileURL.substring(fileURL.lastIndexOf("."));
			
			String convertedFileURL = "";
			switch(fileExtension) {
			case ".txt":
				convertedFileURL = service.convertTextToPDF(document, fileName);
				break;
			case ".jpg":
			case ".jpeg":
			case ".png":
			case ".gif":
			case ".bmp":
				convertedFileURL = service.convertImageToPDF(document, fileName);
				break;
			default:
				logger.debug("Unsupported file extension: ", fileExtension);
				return ResponseEntity.badRequest().body(null);
			}
			document.setName(fileName);
			document.setUrl(convertedFileURL);
			document.setType(1);
			repository.save(document);
			
			return ResponseEntity.ok(document);
		} catch (IOException e) {
			logger.debug("Failed to convert document: ", e);
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PostMapping(value = "/merge")
	public ResponseEntity<Document> mergeDocuments(@RequestBody MergeRequestParam param) {
		String[] ids = param.getIDs();
		String fileName = param.getFileName();
		if (ids.length == 0) {
			logger.debug("Cannot merge empty documents");
			return ResponseEntity.badRequest().body(null);
		}
		
		ArrayList<Document> documents = new ArrayList<Document>();
		try {
			for (int i=0; i<ids.length; i++) {
				Document document = repository.findById(ids[i]);
				if (document == null) {
					logger.debug("Not found document with id: " + ids[i]);
					return ResponseEntity.badRequest().body(null);
				}
				documents.add(document);
			}

			if (fileName == null || fileName.isEmpty()) {
				fileName = "merged.pdf";
			}
			String mergedURL = service.mergePDFs(documents, fileName);
			
			Document firstDoc = documents.remove(0);

			// create merged document
			Document document = new Document();
			document.setId(Utils.generateID());
			document.setName(fileName);
			document.setUrl(mergedURL);
			document.setType(firstDoc.getType());
			document.setParentId(firstDoc.getParentId());
			document.setPermission(1);
			document.setCreatedDate(LocalDateTime.now().toString());
			document.setUpdatedDate(LocalDateTime.now().toString());
			repository.save(document);
			
			return ResponseEntity.ok(document);
		} catch (Exception e) {
			logger.debug("Failed to merge documents: ", e);
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteDocument(@PathVariable("id") String id) {
		Document document = repository.findById(id);
		if (document == null) {
			return ResponseEntity.notFound().build();
		}
		try {
			repository.delete(document);
			return ResponseEntity.ok(id);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Faild to delete document with id: " + id);
		}
	}
	
	@PostMapping(value = "/delete")
	public ResponseEntity<String> deleteDocuments(@RequestBody RequestParamIDs param) {
		String[] ids = param.getIDs();
		ArrayList<Document> documents = new ArrayList<Document>();
		for (int i=0; i<ids.length; i++) {
			Document document = repository.findById(ids[i]);
			if (document == null) {
				return ResponseEntity.badRequest().body("Not found document with id: " + ids[i]);
			}
			documents.add(document);
		}
		try {
			repository.deleteAll(documents);
			return ResponseEntity.ok(String.join(", ", ids));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Faild to delete documents with ids: " + String.join(", ", ids));
		}
	}
	
	@GetMapping(value= "/file/{fileName}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable("fileName") String fileName) {
		try {
	        final byte[] data = service.downloadFile(fileName);
	        final String contentTye = service.getContentType(fileName);
	        final ByteArrayResource resource = new ByteArrayResource(data);
	        return ResponseEntity
	                .ok()
	                .contentLength(data.length)
	                .header("Content-type", contentTye)
	                .body(resource);
		} catch(final Exception ex) {
			logger.info("IO Error Message= " + ex.getMessage());
	        return ResponseEntity.notFound().build();
		}
    }

	@PostMapping(value= "/upload")
	public ResponseEntity<String> uploadFile(@RequestPart(value= "file") final MultipartFile multipartFile) {
		
		String fileUrl = service.uploadFile(multipartFile);
		final String response = "[" + fileUrl + "] uploaded successfully.";
		return new ResponseEntity<>(fileUrl, HttpStatus.OK);
	}
	
	@PostMapping(value= "/uploadImage")
	public ResponseEntity<String> uploadImage(@RequestPart(value= "file") final MultipartFile multipartFile) {
		
		String fileUrl = service.uploadImage(multipartFile);
		final String response = "[" + fileUrl + "] uploaded successfully.";
		return new ResponseEntity<>(fileUrl, HttpStatus.OK);
	}
	@GetMapping(value= "/deleteImage")
	public ResponseEntity<String> deleteImage(@RequestParam String file) {
		
		service.deleteFile(file);
		return new ResponseEntity<>(file, HttpStatus.OK);
	}

	@PostMapping(value= "/sendEmail")
	public ResponseEntity<String> sendEmail(@RequestBody SendDocumentsAsEmailRequestParam param) {
		String[] documentIDs = param.getDocumentIDs();
		ArrayList<Document> documents = new ArrayList<Document>();
		for (int i=0; i<documentIDs.length; i++) {
			Document document = repository.findById(documentIDs[i]);
			if (document == null) {
				return ResponseEntity.badRequest().body("Not found document with id: " + documentIDs[i]);
			}
			documents.add(document);
		}
		
		if (service.sendEmail(documents, param.getFrom(), param.getTo(), param.getCc(), param.getBcc(), param.getSubject(), param.getMessage())) {
			return ResponseEntity.ok("Email is sent successfully");
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PostMapping(value= "/sendNewUserEmail")
	public ResponseEntity<String> sendNewUserEmail(@RequestBody SendDocumentsAsEmailRequestParam param) {
		String content;
		content="<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"Content-Language\" content=\"en-us\">\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;1,300;1,400;1,500;1,600&family=Satisfy&display=swap\" rel=\"stylesheet\">\r\n"
				+ "<title>Hello</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<p style=\"font-family:'Open Sans', sans-serif; font-size:14px; color: black;\">\r\n"
				+ "	Hello [Display Name] ,<br><br>\r\n"
				+ "\r\n"
				+ "	You have been added as a New User to Dry Works, a restoration management \r\n"
				+ "	website. Your login credentials are:<br><br>\r\n"
				+ "\r\n"
				+ "	Username: [username]<br>\r\n"
				+ "	Password: [password]<br><br>\r\n"
				+ "\r\n"
				+ "	To change this password, log in to Dry Works using the credentials above and then click on your name in the upper right menu to edit your Dry Works account information. <br><br>\r\n"
				+ "\r\n"
				+ "	Please contact your company's Dry Works Admin if you have any questions.\r\n"
				+ "</p>\r\n"
				+ "<p style=\"font-family:'Open Sans', sans-serif; font-size:12px; color: #7A7E83;\">This message (including any \r\n"
				+ "attachments) may contain confidential, proprietary, privileged and/or private \r\n"
				+ "information. The information is intended to be for the use of the individual or \r\n"
				+ "entity designated above. If you are not the intended recipient of this message, please notify the \r\n"
				+ "sender immediately, and delete the message and any attachments. Any disclosure, \r\n"
				+ "reproduction, distribution or other use of this message or any attachments by an individual or entity other than the \r\n"
				+ "intended recipient is prohibited.\r\n"
				+ "</p>\r\n"
				+ "\r\n"
				+ "<p align=\"right\" style=\"font-family:'Open Sans', sans-serif; font-weight:bold; font-size:14px; color: #7A7E83; margin-right: 20px;\">Powered By <span style=\"font-size: 20px; font-family: 'Satisfy', cursive;\">Dry Works</span></p>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "";
		content=content.replace("[Display Name]", param.getDisplayName());
		
		content=content.replace("[username]", param.getUser());
		content=content.replace("[password]", param.getPassword());
		logger.debug(content);
		
		
		if (service.sendEmail( param.getFrom(), param.getTo(), param.getCc(), param.getBcc(), param.getSubject(), content)) {
			return ResponseEntity.ok("Email is sent successfully");
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PostMapping(value= "/sendNewUserEmailEx")
	public ResponseEntity<String> sendNewUserEmailEx(@RequestBody SendDocumentsAsEmailRequestParam param) {
		String content;
		content="<html>\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"Content-Language\" content=\"en-us\">\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\">\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;1,300;1,400;1,500;1,600&family=Satisfy&display=swap\" rel=\"stylesheet\">\r\n"
				+ "<title>Hello</title>\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<p style=\"font-family:'Open Sans', sans-serif; font-size:14px; color: black;\">\r\n"
				+ "	Hello,<br><br>\r\n"
				+ "\r\n"
				+ "	[Display name] has been added as a New User to Dry Works with the following \r\n"
				+ "	log in credentials:<br><br>\r\n"
				+ "\r\n"
				+ "	Username: [username]<br>\r\n"
				+ "	Password: [password]</p>\r\n"
				+ "<p style=\"font-family:'Open Sans', sans-serif; font-size:12px; color: #7A7E83;\">\r\n"
				+ "This message (including any attachments) may contain confidential, proprietary, \r\n"
				+ "privileged and/or private information. The information is intended to be for the \r\n"
				+ "use of the individual or entity designated above. If you are not the intended \r\n"
				+ "recipient of this message, please notify the sender immediately, and delete the \r\n"
				+ "message and any attachments. Any disclosure, reproduction, distribution or other \r\n"
				+ "use of this message or any attachments by an individual or entity other than the \r\n"
				+ "intended recipient is prohibited.\r\n"
				+ "</p>\r\n"
				+ "\r\n"
				+ "<p align=\"right\" style=\"font-family:'Open Sans', sans-serif; font-weight:bold; font-size:14px; color: #7A7E83; margin-right: 20px;\">Powered By <span style=\"font-size: 20px; font-family: 'Satisfy', cursive;\">Dry Works</span></p>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "";
		content=content.replace("[Display Name]", param.getDisplayName());
		
		content=content.replace("[username]", param.getUser());
		content=content.replace("[password]", param.getPassword());
		logger.debug(content);
		
		
		if (service.sendEmail( param.getFrom(), param.getTo(), param.getCc(), param.getBcc(), param.getSubject(), content)) {
			return ResponseEntity.ok("Email is sent successfully");
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
}
