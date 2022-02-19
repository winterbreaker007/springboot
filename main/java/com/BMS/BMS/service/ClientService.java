package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.ClientRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 12/14/2020.
 */
@Service
public class ClientService {
  private static final Logger logger = LoggerFactory.getLogger(ClientService.class);
  private ClientRepository clientRepository;
  private LogService logService;
  private JobService jobService;

  @Value("${db.retry.max.retries}")
  private long maxRetries;
  @Value("${db.retry.wait.time.in.seconds}")
  private long waitTimeInSeconds;

  public ClientService(
      ClientRepository clientRepository,
      LogService logService,
      JobService jobService) {
    this.clientRepository = clientRepository;
    this.logService = logService;
    this.jobService = jobService;
  }

  public Client updateClient(Client updatedClient, User user) {
    int retryCount = 0;
    Client savedClient = null;
    updatedClient.setSavedBy(user.getDisplayName());
    updatedClient.setDateLastSaved(LocalDateTime.now());
    boolean gettingDeleted = clientIsGettingDeleted(updatedClient);
    while(Objects.isNull(savedClient) && retryCount < maxRetries){
      try{
        savedClient = clientRepository.save(updatedClient);
        if(gettingDeleted){
          logService.dbLog(user.getId(), "Deleted client: " + savedClient.getId());
          jobService.softDeleteClientJobs(savedClient.getId(), user);
        } else {
          logService.dbLog(user.getId(), "Successfully saved client: " + savedClient.getId());
        }
      } catch (Exception e){
        retryCount++;
        logger.error("Saving client " + updatedClient.getId() + " failed! Waiting "+ waitTimeInSeconds + " second(s) before retry attempt " + retryCount);
        logService.errorLog(user.getId(), "Error saving client:" + updatedClient.getId() + ". Waiting before retry attempt: " + retryCount);
        try{
          TimeUnit.SECONDS.sleep(waitTimeInSeconds);
        } catch (InterruptedException ie){
          logger.debug("unable to sleep: " + ie);
        }
      }
    }
    return savedClient;
  }

  public Client addNewClient(Client client, User user){
    try{
      Client savedClient = clientRepository.save(client);
      logger.info("Successfully saved new client: " + client.getId());
      logService.dbLog(user.getId(),"Successfully saved new client: " + client.getId());
      return savedClient;
    } catch (Exception e){
      e.printStackTrace();
      logService.errorLog(user.getId(),"Unable to save new client: " + client);
      throw e;
    }
  }

  private boolean clientIsGettingDeleted(Client client){
    if(client.isClientDeleted()){
      Client existingClient = clientRepository.findById(client.getId());
      boolean gettingDeleted = !existingClient.isClientDeleted() && client.isClientDeleted();
      logger.debug("Getting deleted: was {} - set to {}", existingClient.isClientDeleted(), client.isClientDeleted());
      return gettingDeleted;
    }
    return false;
  }
}
