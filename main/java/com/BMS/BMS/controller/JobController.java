package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.service.AppService;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.JobService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.service.WebsocketService;
import java.util.List;
import java.util.Objects;
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

/**
 * Created by samgi on 12/14/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/jobs")
public class JobController {
  private static final Logger logger = LoggerFactory.getLogger(JobController.class);

  private JobService jobService;
  private AppService appService;
  private WebsocketService websocketService;
  private AuthenticationService authenticationService;
  private LogService logService;

  public JobController(JobService jobService,
      AppService appService,
      WebsocketService websocketService,
      AuthenticationService authenticationService,
      LogService logService) {
    this.jobService = jobService;
    this.appService = appService;
    this.websocketService = websocketService;
    this.authenticationService = authenticationService;
    this.logService = logService;
  }

  @GetMapping(value = "/getInactiveJobsWithClients")
  public ResponseEntity<List<Job>> getInactiveJobsWithClients(@RequestParam List<String> companyIds, @RequestHeader("Authorization") String jwt) {
    try{
      logger.debug("Request received for all inactive jobs with company ids: " + companyIds);
      User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
      logService.infoLog(userFromHeaderToken.getId(),"Requesting all inactive jobs");
      List<Job> allInactiveJobsWithClients = appService.getInactiveJobsWithClients(companyIds);
      logger.debug("Sending " + allInactiveJobsWithClients.size() + " inactive jobs with clients and invoices");
      logService.infoLog(userFromHeaderToken.getId(),"Sending all inactive jobs with size: "+ allInactiveJobsWithClients.size());
      return ResponseEntity.ok(allInactiveJobsWithClients);
    } catch (Exception e) {
      e.printStackTrace();
      logService.errorLog("Exception thrown. getInactiveJobsWithClients() ::: " + e.getMessage());
      throw e;
    }
  }

  @PostMapping(value = "/updateJob")
  public ResponseEntity<?> updateJob(@RequestBody Job job, @RequestHeader("Authorization") String jwt){
    logger.debug("Request received to update Job: " + job.toStringNoClientNoInvoices());
    User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
    logService.infoLog(userFromHeaderToken.getId(),"Request to update job: " + job.toStringNoClientNoInvoices());
    Job savedJob = jobService.updateJob(job, userFromHeaderToken);
    if(Objects.nonNull(savedJob)){
      logger.debug("Job " + savedJob.getId() + " saved successfully");
      websocketService.send(savedJob);
      return ResponseEntity.ok("Job " + savedJob.getId() + " saved successfully");
    }
    return ResponseEntity.ok("Error! Unable to update job: " + job.getId());
  }
}
