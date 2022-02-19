package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Log;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import com.blackwater.blackwaterbillingmanagementsystem.model.AuthenticationRequest;
import com.blackwater.blackwaterbillingmanagementsystem.model.AuthenticationResponse;
import com.blackwater.blackwaterbillingmanagementsystem.model.ErrorResponse;
import com.blackwater.blackwaterbillingmanagementsystem.model.LoginResponse;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.service.MyUserDetailsService;
import com.blackwater.blackwaterbillingmanagementsystem.utils.EncryptionUtil;
import com.blackwater.blackwaterbillingmanagementsystem.utils.JwtUtil;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by samgi on 4/8/2021.
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/auth")
public class AuthenticationController {
  private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

  private AuthenticationManager authenticationManager;
  private MyUserDetailsService myUserDetailsService;
  private JwtUtil jwtUtil;
  private EncryptionUtil encryptionUtil;
  private UserRepository userRepository;
  private LogService logService;
  private AuthenticationService authenticationService;

  public AuthenticationController(
      AuthenticationManager authenticationManager,
      MyUserDetailsService myUserDetailsService,
      JwtUtil jwtUtil,
      EncryptionUtil encryptionUtil,
      UserRepository userRepository,
      LogService logService,
      AuthenticationService authenticationService) {
    this.authenticationManager = authenticationManager;
    this.myUserDetailsService = myUserDetailsService;
    this.jwtUtil = jwtUtil;
    this.encryptionUtil = encryptionUtil;
    this.userRepository = userRepository;
    this.logService = logService;
    this.authenticationService = authenticationService;
  }

  @PostMapping(value = "/authenticate")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
    try {
      authenticationRequest.setPassword(encryptionUtil.hash256(authenticationRequest.getPassword()));
      logger.info("Request to authenticate was received:" + authenticationRequest);
      logService.infoLog("Request to authenticate was received: " + authenticationRequest);
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
      UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
      String jwt = jwtUtil.generateToken(userDetails);
      logger.info("User successfully authenticated: " + userDetails.getUsername());
      AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt);
      logger.info("Returning JWT: " + authenticationResponse.toString());
      return ResponseEntity.ok(authenticationResponse);
    } catch (BadCredentialsException e){
      logger.info("User could not be authenticated: " + authenticationRequest.getUsername() + " :: " + authenticationRequest.getPassword());
      logService.infoLog("User could not be authenticated: " + authenticationRequest.getUsername() + " :: " + authenticationRequest.getPassword());
      return new ResponseEntity<>(new ErrorResponse("Bad Credentials"), HttpStatus.UNAUTHORIZED);
    } catch (Exception e){
      e.printStackTrace();
      logService.errorLog("Exception thrown. createAuthenticationToken() ::: " + e.getMessage());
      return new ResponseEntity<>(new ErrorResponse("Unknown Error:" + e.getMessage()), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(value = "/getMe")
  public ResponseEntity<LoginResponse> getMe(@RequestHeader("Authorization") String jwt) {
    try{
      logger.debug("Received request to log user in with auth token: " + jwt);
      User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
      logService.infoLog(userFromHeaderToken.getId(), "Request to log in or remain logged in.");
      LoginResponse loginResponse = new LoginResponse(userFromHeaderToken);
      logger.debug("Successful login.");
      return ResponseEntity.ok(loginResponse);
    } catch (Exception e){
      logger.error(Arrays.toString(e.getStackTrace()));
      logService.errorLog("AuthenticationController.java", "Exception thrown. getMe() ::: " + e.getMessage());
      throw e;
    }
  }
}
