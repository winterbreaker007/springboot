package com.blackwater.blackwaterbillingmanagementsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountPlans;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountSubs;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountPlansRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountSubsRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;

@RestController
@CrossOrigin
@RequestMapping(value = "/subscriptions")

public class AccountSubsController {
	 private static final Logger logger = LoggerFactory.getLogger(AccountSubsController.class);
	    private AuthenticationService authenticationService;
	    private LogService logService;
	    private AccountSubsRepository accountSubsRepository;

	    public AccountSubsController(AuthenticationService authenticationService, LogService logService, AccountSubsRepository accountSubsRepository) {

	        this.authenticationService = authenticationService;
	        this.logService = logService;
	        this.accountSubsRepository = accountSubsRepository;
	    }
	    
	    @GetMapping(value = "/getAccountSubs")
	    public ResponseEntity<List<AccountSubs>> getAccountSubs(@RequestParam String accountId) {	    	
	    	List<AccountSubs> res=accountSubsRepository.findByAccountId(accountId);
	    	
	  	  return ResponseEntity.ok(res);
	    }
}

