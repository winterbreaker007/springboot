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

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Carrier;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Contact;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Carrier;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.CarrierRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.CarrierRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;

import com.blackwater.blackwaterbillingmanagementsystem.utils.EncryptionUtil;

@RestController
@CrossOrigin
@RequestMapping(value = "/carriers")

public class CarrierController {
    private static final Logger logger = LoggerFactory.getLogger(CarrierController.class);
    private AuthenticationService authenticationService;
    private LogService logService;
    private CarrierRepository carrierRepository;

    public CarrierController(AuthenticationService authenticationService, LogService logService, CarrierRepository carrierRepository) {

        this.authenticationService = authenticationService;
        this.logService = logService;
        this.carrierRepository = carrierRepository;
    }
    
    
    
    
    @GetMapping(value = "/getContactsById")
    public ResponseEntity<List<Contact>> getContactsById(@RequestParam String Id) {
      logger.debug("Request received for Carrier id: " + Id);
      List<Carrier> carriers = carrierRepository.findById(Id);
      logger.debug("Sending carriers with size: " + carriers.size());
      
      try {
	      Carrier carrier=carriers.get(0);
	      
	      List<Contact> contacts=new ArrayList<Contact>();
	      
	      Contact contact;
	      
			if (carrier.getPhone1()!=null)
			{
				contact =new Contact(carrier.getCarrierName(),"Carrier","Phone",carrier.getPhone1());
				contacts.add(contact);
			}	
			if (carrier.getPhone2()!=null) {
				contact =new Contact(carrier.getCarrierName(),"Carrier","Phone",carrier.getPhone2());
				contacts.add(contact);
			}
			if (carrier.getFax1()!=null) {
				contact =new Contact(carrier.getCarrierName(),"Carrier","Fax",carrier.getFax1());
				contacts.add(contact);
			}
			if (carrier.getFax2()!=null) {
				contact =new Contact(carrier.getCarrierName(),"Carrier","Fax",carrier.getFax2());
				contacts.add(contact);
			}
			if (carrier.getEmail1()!=null) {
				contact =new Contact(carrier.getCarrierName(),"Carrier","Email",carrier.getEmail1());
				contacts.add(contact);
			}
			if (carrier.getEmail2()!=null) {
				contact =new Contact(carrier.getCarrierName(),"Carrier","Email",carrier.getEmail2());
				contacts.add(contact);
			}	
	      return ResponseEntity.ok(contacts);
      }catch(Exception e) {
    	  logger.debug("Search Carrier internal exception ");
    	  return ResponseEntity.ok(null);
      }
    }
    
}
