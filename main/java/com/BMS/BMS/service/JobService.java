package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Invoice;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.JobRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 12/14/2020.
 */
@Service
public class JobService {
  private static final Logger logger = LoggerFactory.getLogger(JobService.class);
  private JobRepository jobRepository;
  private LogService logService;

  @Value("${db.retry.max.retries}")
  private long maxRetries;

  @Value("${db.retry.wait.time.in.seconds}")
  private long waitTimeInSeconds;

  public JobService(
      JobRepository jobRepository,
      LogService logService) {
    this.jobRepository = jobRepository;
    this.logService = logService;
  }

  public Job updateJob(Job updatedJob, User user){
    int retryCount = 0;
    Job savedJob = null;
    Client client = updatedJob.getClient();
    List<Invoice> invoices = updatedJob.getInvoices();
    updatedJob.setSavedBy(user.getDisplayName());
    updatedJob.setDateLastSaved(LocalDateTime.now());
    while(Objects.isNull(savedJob) && retryCount < maxRetries){
      try{
        savedJob = jobRepository.save(updatedJob);
        if(savedJob.isJobDeleted()){
          logService.dbLog(user.getId(), "Deleted job: " + savedJob.getId());
        } else {
          logService.dbLog(user.getId(), "Successfully saved job: " + savedJob.getId());
        }
        savedJob.setClient(client);
        savedJob.setInvoices(invoices);
      } catch (Exception e){
        retryCount++;
        logger.error("Saving job " + updatedJob.getId() + " failed! Waiting "+ waitTimeInSeconds + " second(s) before retry attempt " + retryCount);
        e.printStackTrace();
        logService.errorLog(user.getId(), "Error saving client:" + updatedJob.getId() + ". Waiting before retry attempt: " + retryCount);
        try{
          TimeUnit.SECONDS.sleep(waitTimeInSeconds);
        } catch (InterruptedException ie){
          logger.debug("unable to sleep: " + ie);
        }
      }
    }
    return savedJob;
  }

  public void softDeleteClientJobs(String clientId, User user){
    List<Job> allJobsByClient = jobRepository.findAllByClientId(clientId);
    allJobsByClient.forEach(job -> job.setJobDeleted(true));
    List<Job> savedJobs = jobRepository.saveAll(allJobsByClient);
    logger.debug("Successfully deleted " + savedJobs.size() + " jobs from client: " + clientId);
    logService.dbLog(user.getId(), "Successfully deleted " + savedJobs.size() + " jobs from client: " + clientId);
  }
}
