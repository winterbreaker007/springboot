package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Company;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Document;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.model.InitialAccountResponse;
import com.blackwater.blackwaterbillingmanagementsystem.model.InitialDataResponse;
import com.blackwater.blackwaterbillingmanagementsystem.service.AppService;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.utils.Utils;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by samgi on 12/17/2020.
 */
@RestController
@CrossOrigin
public class AppController {
  private static final Logger logger = LoggerFactory.getLogger(AppController.class);

  private AppService appService;
  private LogService logService;
  private AuthenticationService authenticationService;

  public AppController(AppService appService,
      LogService logService,
      AuthenticationService authenticationService) {
    this.appService = appService;
    this.logService = logService;
    this.authenticationService = authenticationService;
  }

  @GetMapping(value = "/getInitialDataResponse")
  public ResponseEntity<InitialDataResponse> getInitialDataResponse(@RequestParam List<String> companyIds, @RequestHeader("Authorization") String jwt){
    try{
      logger.debug("Request received for Initial Data Response");
      User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
      logService.infoLog(userFromHeaderToken.getId(), "Requesting Initial Data Response.");
      InitialDataResponse response = appService.getInitialDataResponse(companyIds);
      String responseLog = "Sending Initial Data Response with " + response.getJobList().size() + " jobs, "
          + response.getValueListSettings().size() + " valueListSettings, and "
          + response.getInsuranceCarriers().size() + " Insurance Carriers, and "
          + response.getInsuranceAdjusters().size() + " Insurance Adjusters.";
      logger.debug(responseLog);
      logService.infoLog(userFromHeaderToken.getId(), responseLog);
      return ResponseEntity.ok(response);
    } catch (Exception e){
      logger.debug(e.toString());
      logService.errorLog("AppController.java", "Exception thrown. getInitialDataResponse() ::: " + e.getMessage());
      throw e;
    }
  }
  
  @GetMapping(value = "/getAccountInitial")
  public ResponseEntity<InitialAccountResponse > getAccountInitial(@RequestParam String accountId, @RequestHeader("Authorization") String jwt){
    try{
      logger.debug("Request received for Initial Data Response");
      User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
      logService.infoLog(userFromHeaderToken.getId(), "Requesting Initial Data Response.");

      InitialAccountResponse response = appService.getInitialAccount(accountId);
      
//      logService.infoLog(userFromHeaderToken.getId(), responseLog);
      return ResponseEntity.ok(response);
    } catch (Exception e){
      logger.debug(e.toString());
      logService.errorLog("AppController.java", "Exception thrown. getInitialDataResponse() ::: " + e.getMessage());
      throw e;
    }
  }
  
}
