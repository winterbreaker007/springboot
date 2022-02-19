package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Client;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.ClientService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.service.WebsocketService;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by samgi on 12/14/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/clients")
public class ClientController {
  private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

  private WebsocketService websocketService;
  private ClientService clientService;
  private AuthenticationService authenticationService;
  private LogService logService;

  public ClientController(
      WebsocketService websocketService,
      ClientService clientService,
      AuthenticationService authenticationService,
      LogService logService) {
    this.websocketService = websocketService;
    this.clientService = clientService;
    this.authenticationService = authenticationService;
    this.logService = logService;
  }

  @PostMapping(value = "/addNewClient")
  public ResponseEntity<?> addNewClient(@RequestBody Client client, @RequestHeader("Authorization") String jwt){
    logger.debug("Request received to add new Client: " + client.toString());
    User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
    logService.infoLog(userFromHeaderToken.getId(), "Request to add new client: " + client.toString());
    Client savedClient = clientService.addNewClient(client, userFromHeaderToken);
    logger.debug("Client " + savedClient.getId() + " saved successfully");
    return ResponseEntity.ok("Client " + savedClient.getId() + " saved successfully");
  }

  @PostMapping(value = "/updateClient")
  public ResponseEntity<?> updateClient(@RequestBody Client client, @RequestHeader("Authorization") String jwt){
    logger.debug("Request received to update Client: " + client.toStringWithoutContactLogAndNotes());
    User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
    logService.infoLog(userFromHeaderToken.getId(), "Request to update client: " + client.toStringWithoutContactLogAndNotes());
    Client savedClient = clientService.updateClient(client, userFromHeaderToken);
    if(Objects.nonNull(savedClient)){
      logger.debug("Client " + savedClient.getId() + " saved successfully");
      websocketService.send(savedClient);
      return ResponseEntity.ok("Client " + savedClient.getId() + " saved successfully");
    }
    return ResponseEntity.ok("Error! Unable to update client: " + client.getId());
  }
}
