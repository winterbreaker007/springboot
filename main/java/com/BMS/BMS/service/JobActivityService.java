package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.JobActivity;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Log;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.JobActivityRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 12/14/2020.
 */
@Service
public class JobActivityService {
  private static final Logger logger = LoggerFactory.getLogger(JobActivityService.class);
  private JobActivityRepository jobActivityRepository;
  private LogService logService;

  public JobActivityService(
      JobActivityRepository jobActivityRepository,
      LogService logService) {
    this.jobActivityRepository = jobActivityRepository;
    this.logService = logService;
  }

  public List<JobActivity> getJobActivityByInvoiceId(String invoiceId, String userId){
    try{
      List<JobActivity> allByParentInvoiceId = jobActivityRepository
          .findAllByParentInvoiceId(invoiceId);
      logService.infoLog(userId, "Retrieved job activity for invoice id: " + invoiceId);
      return allByParentInvoiceId;
    } catch (Exception e){
      logService.errorLog(userId,"Unable to retrieve job activity for invoice id: " + invoiceId + " ::EXCEPTION:" + e);
      return null;
    }
  }
}
