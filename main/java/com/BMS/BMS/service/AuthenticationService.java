package com.blackwater.blackwaterbillingmanagementsystem.service;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.User;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import com.blackwater.blackwaterbillingmanagementsystem.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by samgi on 12/17/2020.
 */
@Service
public class AuthenticationService {
  private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
  private final UserRepository userRepository;
  private final JwtUtil jwtUtil;
  private LogService logService;

  public AuthenticationService(
      UserRepository userRepository,
      JwtUtil jwtUtil, LogService logService) {
    this.userRepository = userRepository;
    this.jwtUtil = jwtUtil;
    this.logService = logService;
  }

  public User getUserFromHeaderToken(String token){
    try{
      String username = jwtUtil.extractUsername(jwtUtil.getJwtFromHeader(token));
      logger.debug("Username found: "+ username);
      User userBySystemEmailAddress = userRepository.findUserBySystemEmailAddress(username);
      return userBySystemEmailAddress;
    } catch (Exception e){
      logService.errorLog("AuthenticationService.java", "Exception thrown. getUserFromHeaderToken() ::: " + e.getMessage());
    }
    return null;
  }
}
