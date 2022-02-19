package com.blackwater.blackwaterbillingmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Adjuster;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Contact;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Adjuster;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AdjusterRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AdjusterRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;

import com.blackwater.blackwaterbillingmanagementsystem.utils.EncryptionUtil;

@RestController
@CrossOrigin
@RequestMapping(value = "/adjusters")

public class AdjusterController {
    private static final Logger logger = LoggerFactory.getLogger(AdjusterController.class);
    private AuthenticationService authenticationService;
    private LogService logService;
    private AdjusterRepository AdjusterRepository;

    public AdjusterController(AuthenticationService authenticationService, LogService logService, AdjusterRepository AdjusterRepository) {

        this.authenticationService = authenticationService;
        this.logService = logService;
        this.AdjusterRepository = AdjusterRepository;
    }
    
    
    
    
    @GetMapping(value = "/getAdjustersById")
    public ResponseEntity<List<Contact>> getContactsById(@RequestParam String Id) {
      logger.debug("Request received for Adjuster id: " + Id);
      List<Adjuster> adjusters = AdjusterRepository.findById(Id);
      logger.debug("Sending Adjusters with size: " + adjusters.size());
      try {
	      Adjuster adjuster=adjusters.get(0);
	      
	      List<Contact> contacts=new ArrayList<Contact>();
	      
	      Contact contact;
	      
			if (adjuster.getEmail1()!=null)
			{
				contact =new Contact(adjuster.getAdjusterName(),"Adjuster","Email",adjuster.getEmail1());
				contacts.add(contact);
			}	
			if (adjuster.getEmail2()!=null)
			{
				contact =new Contact(adjuster.getAdjusterName(),"Adjuster","Email",adjuster.getEmail2());
				contacts.add(contact);
			}
			if (adjuster.getPhone1()!=null)
			{
				contact =new Contact(adjuster.getAdjusterName(),"Adjuster","Phone",adjuster.getPhone1());
				contacts.add(contact);
			}
			if (adjuster.getPhone2()!=null)
			{
				contact =new Contact(adjuster.getAdjusterName(),"Adjuster","Phone",adjuster.getPhone2());
				contacts.add(contact);
			}
			if (adjuster.getPhone3()!=null)
			{
				contact =new Contact(adjuster.getAdjusterName(),"Adjuster","Phone",adjuster.getPhone3());
				contacts.add(contact);
			}
			if (adjuster.getFax()!=null)
			{
				contact =new Contact(adjuster.getAdjusterName(),"Adjuster","Fax",adjuster.getFax());
				contacts.add(contact);
			}
		   return ResponseEntity.ok(contacts);
      }catch(Exception e) {
    	  logger.debug("Search Adjuster internal exception");
    	  return ResponseEntity.ok(null);
      }
    }
    
}
