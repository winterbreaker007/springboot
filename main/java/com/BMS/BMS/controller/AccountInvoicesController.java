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

import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountInvoices;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountSubs;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Contact;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountInvoices;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountInvoicesRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountInvoicesRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;

import com.blackwater.blackwaterbillingmanagementsystem.utils.EncryptionUtil;

@RestController
@CrossOrigin
@RequestMapping(value = "/accountInvoices")

public class AccountInvoicesController {
    private static final Logger logger = LoggerFactory.getLogger(AccountInvoicesController.class);
    private AuthenticationService authenticationService;
    private LogService logService;
    private AccountInvoicesRepository accountInvoicesRepository;

    public AccountInvoicesController(AuthenticationService authenticationService, LogService logService, AccountInvoicesRepository accountInvoicesRepository) {

        this.authenticationService = authenticationService;
        this.logService = logService;
        this.accountInvoicesRepository = accountInvoicesRepository;
    }    
    @GetMapping(value = "/getAccountInvoices")
    public ResponseEntity<List<AccountInvoices>> getAccountInvoices() {	    	
    	List<AccountInvoices> res=accountInvoicesRepository.findAll();
    	
  	  return ResponseEntity.ok(res);
    }
    
    
//    @GetMapping(value = "/getAccountInvoicessById")
//    public ResponseEntity<List<Contact>> getContactsById(@RequestParam String Id) {
//     return 1;
//    }
    
}
