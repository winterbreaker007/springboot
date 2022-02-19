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

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Account;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.AccountPlans;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AccountPlansRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;

@RestController
@CrossOrigin
@RequestMapping(value = "/accountplans")

public class AccountPlansController {
	 private static final Logger logger = LoggerFactory.getLogger(AccountPlansController.class);
	    private AuthenticationService authenticationService;
	    private LogService logService;
	    private AccountPlansRepository accountPlansRepository;

	    public AccountPlansController(AuthenticationService authenticationService, LogService logService, AccountPlansRepository accountPlansRepository) {

	        this.authenticationService = authenticationService;
	        this.logService = logService;
	        this.accountPlansRepository = accountPlansRepository;
	    }
	    
	    @GetMapping(value = "/getAccountPlans")
	    public ResponseEntity<List<AccountPlans>> getAccountPlans() {	    	
	    	List<AccountPlans> res=accountPlansRepository.findAll();
	  	  return ResponseEntity.ok(res);
	    }
}
