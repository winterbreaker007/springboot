package com.blackwater.blackwaterbillingmanagementsystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by samgi on 12/14/2020.
 */
@Controller
public class StatusController {
  private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

  @GetMapping(value = "/ping")
  public ResponseEntity<String> ping() {
    return new ResponseEntity<String>("Blackwater Billing Management System", HttpStatus.OK);
  }
}
