package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Invoice;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.UserUpdate;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.InvoiceService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Created by samgi on 12/17/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/invoices")
public class InvoiceController {
  private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

  private InvoiceService invoiceService;
  private AuthenticationService authenticationService;
  private LogService logService;

  @PostMapping(value = "/test")
  public ResponseEntity<Invoice> updateUserInformation(@RequestParam String serviceID)
          throws NoSuchAlgorithmException {
    logger.debug("Test Request Received: " + serviceID);
    Invoice invoice = invoiceService.test();
    return ResponseEntity.ok(invoice);
  }
}
