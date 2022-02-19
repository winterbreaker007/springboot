package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Company;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.JobActivity;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.CompanyRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.JobActivityService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
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

/**
 * Created by samgi on 12/14/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/jobActivity")
public class JobActivityController {

  private static final Logger logger = LoggerFactory.getLogger(JobActivityController.class);
  private JobActivityService jobActivityService;
  private AuthenticationService authenticationService;
  private LogService logService;

  public JobActivityController(
      JobActivityService jobActivityService,
      AuthenticationService authenticationService,
      LogService logService) {
    this.jobActivityService = jobActivityService;
    this.authenticationService = authenticationService;
    this.logService = logService;
  }

  @GetMapping(value = "/getJobActivityByInvoiceId")
  public ResponseEntity<List<JobActivity>> getJobActivityByInvoiceId(@RequestParam String invoiceId, @RequestHeader("Authorization") String jwt) {
    try{
      User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
      logger.debug("Request received for job activities for invoice id:" + invoiceId);
      logService.infoLog(userFromHeaderToken.getId(), "Requested job activity info from invoice with id: "+ invoiceId);
      List<JobActivity> jobActivities = jobActivityService
          .getJobActivityByInvoiceId(invoiceId, userFromHeaderToken.getId());
      logger.debug("Sending all job activities:" + jobActivities);
      logService.infoLog(userFromHeaderToken.getId(), "Sending " + jobActivities.size() + " job activities");
      return ResponseEntity.ok(jobActivities);
    } catch (Exception e){
      logService.errorLog("JobActivityController.java", "Exception thrown. getJobActivityByInvoiceId() ::: " + e.getMessage());
      throw e;
    }
  }
}
