package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Job;
import com.blackwater.blackwaterbillingmanagementsystem.exceptions.SaveToDBException;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 5/7/2021.
 */
@Service
public class WebsocketService {
  private static final Logger logger = LoggerFactory.getLogger(WebsocketService.class);

  private SimpMessagingTemplate simpMessagingTemplate;
  private LogService logService;

  @Value("${websocket.topic.update.destination}")
  private String websocketUpdateDestination;
  @Value("${websocket.client.destination}")
  private String clientDestination;
  @Value("${websocket.job.destination}")
  private String jobDestination;

  public WebsocketService(
      SimpMessagingTemplate simpMessagingTemplate,
      LogService logService) {
    this.simpMessagingTemplate = simpMessagingTemplate;
    this.logService = logService;
  }

  public void send(Client payload) {
    try{
      simpMessagingTemplate.convertAndSend(websocketUpdateDestination + clientDestination, payload);
    } catch (Exception e){
      logger.error(Arrays.toString(e.getStackTrace()));
      logService.errorLog("Exception thrown. send(Client payload) ::: " + e.getMessage());
    }
  }

  public void send(Job payload) {
    try{
      simpMessagingTemplate.convertAndSend(websocketUpdateDestination + jobDestination, payload);
    } catch (Exception e){
      logger.error(Arrays.toString(e.getStackTrace()));
      logService.errorLog("Exception thrown. send(Job payload) ::: " + e.getMessage());
    }
  }
//  public void send(SaveToDBException payload) {
//    try{
//      simpMessagingTemplate.convertAndSend(websocketUpdateDestination, payload);
//    } catch (Exception e){
//      logService.errorLog("Exception thrown. send(SaveToDBException payload) ::: " + e.getMessage());
//    }
//  }
}
