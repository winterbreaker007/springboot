package com.blackwater.blackwaterbillingmanagementsystem.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Account;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Contact;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Task;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Account;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;

import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;

import com.blackwater.blackwaterbillingmanagementsystem.utils.EncryptionUtil;
import com.blackwater.blackwaterbillingmanagementsystem.utils.Utils;

@RestController
@CrossOrigin
@RequestMapping(value = "/account")

public class AccountController {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private AuthenticationService authenticationService;
    private LogService logService;
    private AccountRepository accountRepository;

    public AccountController(AuthenticationService authenticationService, LogService logService, AccountRepository accountRepository) {

        this.authenticationService = authenticationService;
        this.logService = logService;
        this.accountRepository = accountRepository;
    }    
  @GetMapping(value = "/getAccountById")
  public ResponseEntity<Account> getAccountById(@RequestParam String Id) {
	  Account res=accountRepository.findById(Id);
	    
	  return ResponseEntity.ok(res);
  }
  @PostMapping(value = "/saveAccount")
  public ResponseEntity<Account> saveAccount(@RequestBody Account account){
	  	
    	Account accountSave = accountRepository.save(account);		    
	    logger.debug("Successfully saved account: " + account.toString());
	    return ResponseEntity.ok(account);
	    
  }  
    
}
