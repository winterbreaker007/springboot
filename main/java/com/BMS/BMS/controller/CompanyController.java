package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Company;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Document;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Membership;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.CompanyRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.DocumentRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.NotificationRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * Created by samgi on 12/14/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/companies")
public class CompanyController {




	public CompanyController(AuthenticationService authenticationService, LogService logService,
			DocumentService documentService, CompanyRepository companyRepository,
			MembershipRepository membershipRepository, DocumentRepository documentRepository,
			NotificationRepository notificationRepository) {
		super();
		this.authenticationService = authenticationService;
		this.logService = logService;
		this.documentService = documentService;
		this.companyRepository = companyRepository;
		this.membershipRepository = membershipRepository;
		this.documentRepository = documentRepository;
		this.notificationRepository = notificationRepository;
	}

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    private AuthenticationService authenticationService;
    private LogService logService;
    private DocumentService documentService;    
    private CompanyRepository companyRepository;
    private MembershipRepository membershipRepository;
    private DocumentRepository documentRepository;
    private NotificationRepository notificationRepository;


    
    @GetMapping(value = "/getAllCompanies")
    public ResponseEntity<List<Company>> getAllCompanies(@RequestHeader("Authorization") String jwt) {
        try {
            logger.debug("Request received for all companies");
            User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
            logService.infoLog(userFromHeaderToken.getId(), "Request for all users");
            List<Company> allCompanies = companyRepository.findAll();
            
            for (int i=0;i<allCompanies.size();i++) {
            	String compId=allCompanies.get(i).getId();
            	allCompanies.get(i).setForms(this.documentService.getForms(compId));
            	allCompanies.get(i).setNotifications(this.notificationRepository.findByCompanyId(compId));
            	
            }
            
            
            logger.debug("Sending all companies with size: " + allCompanies.size());
            logService.infoLog(userFromHeaderToken.getId(), "Sending all users with size: " + allCompanies.size());
            return ResponseEntity.ok(allCompanies);
        } catch (Exception e) {
            e.printStackTrace();
            logService.errorLog("UserController.java", "Exception thrown. getAllUsers() ::: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping(value = "/getCompanyById")
    public ResponseEntity<Optional<Company>> getCompanyById(@RequestParam String companyId) {
        try {
            logger.debug("Request received for company id: " + companyId);
            
            Optional<Company> company = companyRepository.findById(companyId);
//            logger.debug("Sending all companies with size: " + allCompanies.size());
            
            return ResponseEntity.ok(company);
        } catch (Exception e) {
            e.printStackTrace();
            logService.errorLog("CompanyController.java", "Exception thrown. getAllUsers() ::: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping(value = "/getCompaniesByIds")
    public ResponseEntity<List<Company>> getCompanyByIds(@RequestParam List<String> companyIds) {
        try {
            logger.debug("Request received for companies: " + companyIds);
            
            List<Company> companies = companyRepository.findAllByIdIn(companyIds);
//            logger.debug("Sending all companies with size: " + allCompanies.size());
            
            return ResponseEntity.ok(companies);
        } catch (Exception e) {
            e.printStackTrace();
            logService.errorLog("CompanyController.java", "Exception thrown. getAllUsers() ::: " + e.getMessage());
            throw e;
        }
    }
    

    @PostMapping(value= "/updateCompany")
    @Transactional
  	public ResponseEntity<Company> updateCompany(
  			@RequestPart String company,
  			@RequestPart(value= "logo",required = false) final MultipartFile logoFile,
  			@RequestPart(value= "w9",required = false) final MultipartFile w9File
  	) {
    	Company comp = null,res=null;
    	try {
    		ObjectMapper mapper = new ObjectMapper();
        	comp = mapper.readValue(company, Company.class);
        	
        	String logoUrl,w9Url;
      		if(logoFile!=null) {
      			logoUrl = this.documentService.uploadImage(logoFile);
      			logger.debug(logoUrl);
      			comp.setLogo(logoUrl);
      		}
      		if(w9File!=null) {
      			w9Url = this.documentService.uploadFile(logoFile);
     		
      			String filename=w9Url.split("/")[w9Url.split("/").length-1];
      			
      			Document w9document=new Document();
      			w9document.setType(1);
      			w9document.setUrl(w9Url);
      			w9document.setName(filename);
      			w9document.setParentId(comp.getId());
      			w9document.setPermission(4);
      			try {
    				this.documentService.updateDocument(w9document);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
      			
      		}
      		
      		logger.debug("--Request received for company update--");
      		if (comp.getId()!=null)
      		{	
      			if (comp.getMemberships()!=null) {
//      				List<Membership> old=this.membershipRepository.findByCompany(comp);
      				this.membershipRepository.deleteAllByCompany(comp);
      				
	          		for (int i=0;i<comp.getMemberships().size();i++) {
	          			comp.getMemberships().get(i).setCompany(comp);
	          			if (comp.getMemberships().get(i).getId()==null)
	          				comp.getMemberships().get(i).setId(Utils.generateID());
	          			
//	          			this.membershipRepository.save(comp.getMemberships().get(i));
	          		}
	          		
      			}

//          		List<Document> formsOld=this.documentService.getForms(comp.getId());
//          				
//          		for (int i=0;i<formsOld.size();i++) {
////          			this.membershipRepository.delete(membershipsOld.get(i));
//          			this.documentRepository.delete(formsOld.get(i));
//          		}
          		
	  			if (comp.getForms()!=null) {
//	          		List<Document> formsOld=this.documentService.getForms(comp.getId());
	          		this.documentRepository.deleteAllByParentId(comp.getId());
		  				
	  				
	          		for (int i=0;i<comp.getForms().size();i++) {
	          			if (comp.getForms().get(i).getId()==null)
	          				comp.getForms().get(i).setId(Utils.generateID());
	          			//this.documentRepository.save(comp.getForms().get(i));
	          			
	          		}
	          		this.documentRepository.saveAll(comp.getForms());
	  			}
	  			if (comp.getNotifications()!=null) {
	  				this.notificationRepository.deleteAllByCompanyId(comp.getId());
	  				for (int i=0;i<comp.getNotifications().size();i++) {
	          			if (comp.getNotifications().get(i).getId()==null)
	          				comp.getNotifications().get(i).setId(Utils.generateID());	          			
	          		}
	          		this.notificationRepository.saveAll(comp.getNotifications());	
	  			}
          		
      		}else {
      			comp.setId(Utils.generateID());
      			
      		}
      		
      		Company compToSave=comp;
//      		compToSave.setForms(null);
//      		compToSave.setMemberships(null);
      		res=this.companyRepository.save(compToSave);
//      		res.setForms(comp.getForms() );
//      		res.setMemberships(comp.getMemberships());	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
 		return ResponseEntity.ok(res);
  	}

    @PostMapping(value= "/updateCompanyForms")
  	public ResponseEntity<Company> updateCompanyForms(
  			@RequestPart String company,
  			@RequestPart(value= "logo",required = false) final MultipartFile logoFile,
  			@RequestPart(value= "w9",required = false) final MultipartFile w9File
  	) {
    	Company comp = null;
    		
 		return ResponseEntity.ok(comp);
  	}
}
