package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.*;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.CompanyRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import com.blackwater.blackwaterbillingmanagementsystem.model.RequestParamIDs;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.service.UserService;
import com.blackwater.blackwaterbillingmanagementsystem.utils.EncryptionUtil;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.blackwater.blackwaterbillingmanagementsystem.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by samgi on 12/14/2020.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private UserRepository userRepository;
  private UserService userService;
  private AuthenticationService authenticationService;
  private LogService logService;
  private EncryptionUtil encryptionUtil;
  private CompanyRepository companyRepository;
  private MembershipRepository membershipRepository;
  private DocumentService service;

  public UserController(
      UserRepository userRepository,
      UserService userService,
      AuthenticationService authenticationService,
      LogService logService,
      EncryptionUtil encryptionUtil,
      CompanyRepository companyRepository,
      MembershipRepository membershipRepository,
      DocumentService service) {
    this.userRepository = userRepository;
    this.userService = userService;
    this.authenticationService = authenticationService;
    this.logService = logService;
    this.encryptionUtil = encryptionUtil;
    this.companyRepository = companyRepository;
    this.membershipRepository = membershipRepository;
    this.service = service;
  }

  @GetMapping(value = "/getAllUsers")
  public ResponseEntity<List<User>> getAllUsers(@RequestHeader("Authorization") String jwt) {
    try {
      logger.debug("Request received for all users");
      User userFromHeaderToken = authenticationService.getUserFromHeaderToken(jwt);
      logService.infoLog(userFromHeaderToken.getId(), "Request for all users");
      List<User> allUsers = userRepository.findAll();
      logger.debug("Sending all users with size: " + allUsers.size());
      logService.infoLog(userFromHeaderToken.getId(), "Sending all users with size: " + allUsers.size());
      return ResponseEntity.ok(allUsers);
    } catch (Exception e) {
      e.printStackTrace();
      logService.errorLog("UserController.java", "Exception thrown. getAllUsers() ::: " + e.getMessage());
      throw e;
    }
  }

  @GetMapping(value = "/getCompanyUsers")
  public ResponseEntity<List<User>> getCompanyUsers(@RequestParam String companyId) {
    logger.debug("Request received for user with company id: " + companyId);
    List<User> users = userRepository.findUsersByCompanyId(companyId);
    logger.debug("Sending company users with size: " + users.size());
    return ResponseEntity.ok(users);
  }

  @GetMapping(value = "/getCompanyIsContactUsers")
  public ResponseEntity<List<User>> getCompanyIsContactUsers(@RequestParam String companyId,
      @RequestParam Boolean isContact) {
    logger.debug("Request received for user with company id : " + companyId + " and is contact: " + isContact);
    List<User> users = userRepository.findIsContactUsersByCompanyIdAnsIsContact(companyId, isContact);
    logger.debug("Sending company users with size: " + users.size());
    return ResponseEntity.ok(users);
  }

  @PostMapping(value = "/updateUserInformation")
  public ResponseEntity<User> updateUserInformation(@RequestBody UserUpdate updatedUser)
      throws NoSuchAlgorithmException {
    logger.debug("Request received to update user: " + updatedUser.getUser().getId());
    if (Objects.isNull(updatedUser.getUpdatedPassword())) {
      User userById = userRepository.findUserById(updatedUser.getUser().getId());
      updatedUser.getUser().setPassword(userById.getPassword());
    } else {
      updatedUser.getUser().setPassword(encryptionUtil.hash256(updatedUser.getUpdatedPassword()));
    }

    User user = userRepository.save(updatedUser.getUser());
    logger.debug("Successfully updated user: " + user.toString());
    return ResponseEntity.ok(user);
  }
  
  @PostMapping(value = "/updateUser")
  public ResponseEntity<User> updateUser(@RequestBody User updatedUser)
      throws NoSuchAlgorithmException {
	 String emailAddress=updatedUser.getSystemEmailAddress();
	 if (emailAddress==null) {
		 logger.debug("Err empty email address");
		 return ResponseEntity.ok(null);
	 }else {
		 User res=userRepository.findUserBySystemEmailAddress(emailAddress);
		 if ((res!=null)&&(updatedUser.getId()==null)) {
			 logger.debug("Err duplicated email address");
			 return ResponseEntity.ok(null); 
		 }
	 }
	 
    logger.debug("Request received to update user: " + updatedUser.getPassword()+" active:"+updatedUser.getActive());
     if (updatedUser.getId()==null) updatedUser.setId(Utils.generateID());
     if (updatedUser.getContact()==null) updatedUser.setContact(true);
     if (updatedUser.getPassword()!=null) updatedUser.setPassword(encryptionUtil.hash256(updatedUser.getPassword()));
    User user = userRepository.save(updatedUser);
    logger.debug("Successfully updated user: " + user.toString());
    return ResponseEntity.ok(user);
  }

  @PostMapping(value = "/saveContact")
  public ResponseEntity<User> saveContact(@RequestBody ContactModel contact)
      throws NoSuchAlgorithmException {
    logger.debug("Request received to save contact: " + contact.getUser().getDisplayName());
    User user = contact.getUser();
    if (user.getDisplayName() == null) {
      user.setDisplayName(user.getFirstName() + " " + user.getLastName());
    }
    String oldUserId = user.getId();
    String newUserId = oldUserId == null ? Utils.generateID() : oldUserId;
    String companyId = contact.getCompanyId();
    user.setId(newUserId);
    user.setContact(true);
    TblAccounts tblAccounts = new TblAccounts(contact.getLoggedInUser());
    logger.debug("Successfully createdTblAccount: " + user.toString());
    
    user.setUserParentAccountId(tblAccounts);
    user = userRepository.save(user);
    if (oldUserId == null) {
      Company company = companyRepository.findById(companyId).get();
      Membership membership = new Membership();
      String membershipId = Utils.generateID();
      membership.setId(membershipId);
      membership.setCompany(company);
      membership.setUser(user);
      membershipRepository.save(membership);
      logger.debug("Successfully updated user: " + user.toString());
    }
    return ResponseEntity.ok(user);
  }

  @PostMapping(value = "/delete")
  public ResponseEntity<String> deleteContact(@RequestBody String contactId) {
    if (!contactId.isEmpty()) {
      contactId = contactId.substring(0, contactId.length() - 1);
    }
    Optional<User> optionalUser = userRepository.findById(contactId);
    if (optionalUser.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    try {
      List<Membership> memberships = membershipRepository.findByUser(optionalUser.get());
      memberships.forEach(membership -> membershipRepository.delete(membership));
      userRepository.delete(optionalUser.get());
      return ResponseEntity.ok(contactId);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Faild to delete contact with id: " + contactId);
    }
  }

  @GetMapping(value = "/getUser")
  public ResponseEntity<User> getUser(@RequestParam String userId) {
    logger.debug("Request received for user with user id: " + userId);
    User user = userRepository.findById(userId).get();
    logger.debug("Successfully get user: " + user.toString());
    return ResponseEntity.ok(user);
  }

  @PostMapping(value = "/addSignatureUser")
  public ResponseEntity<String> addSignatureUser(
      @RequestPart String userId,
      @RequestPart(value = "file") final MultipartFile multipartFile) {
    logger.debug("Request received for adding job sketch");
    User user = userRepository.findById(userId).get();
    String fileUrl = service.uploadFile(multipartFile);
    user.setSignature(fileUrl);
    logger.debug("Signature user added" + user.toString());
    try {
      userRepository.save(user);
      return ResponseEntity.ok("Signature user added");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(null);
    }
  }
}
