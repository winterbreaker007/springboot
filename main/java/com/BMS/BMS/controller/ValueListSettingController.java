package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.*;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.AdjusterRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.CompanyRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.TaskJobClientProjection;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.UserRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.ValueListSettingRepository;
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
@RequestMapping(value = "/values")
public class ValueListSettingController {
	private static final Logger logger = LoggerFactory.getLogger(AdjusterController.class);
    private AuthenticationService authenticationService;
    private LogService logService;
    private ValueListSettingRepository valueRepository;

    public ValueListSettingController(AuthenticationService authenticationService, LogService logService, ValueListSettingRepository valueRepository) {

        this.authenticationService = authenticationService;
        this.logService = logService;
        this.valueRepository = valueRepository;
    }
    

  @GetMapping(value = "/getAllByListName")
  public ResponseEntity<List<ValueListSetting>> getAllByListName(@RequestParam String listName) {

      try{
      	logger.debug("Request received for value list settings with listName: " + listName);

     List<ValueListSetting> values= valueRepository.findAllByListName(listName);
     
//   List<Task> tasks= taskRepository.findByUser(userId);
        logger.debug("Sending value lists with size: " + values.size());
        return ResponseEntity.ok(values);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }
  
  
  @PostMapping(value = "/setValueListSetting")
  public ResponseEntity<ValueListSetting> setValueListSetting(@RequestBody ValueListSetting val) {

      try{
      	logger.debug("Request received for value list settings with listName: " + val.toString());
     
      	if (val.getId()==null)	val.setId(Utils.generateID());
      	ValueListSetting res= valueRepository.save(val);
     
        return ResponseEntity.ok(res);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }
  
  @PostMapping(value = "/removeValueListSetting")
  public ResponseEntity<ValueListSetting> removeValueListSetting(@RequestBody ValueListSetting val) {

      try{
      	logger.debug("Request received for value list settings with listName: " + val.toString());
          
      	ValueListSetting res= valueRepository.findById(val.getId());      	
      	valueRepository.delete(res);
        return ResponseEntity.ok(res);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }
  
  @PostMapping(value = "/addValueListSetting")
  public ResponseEntity<ValueListSetting> addValueListSetting(@RequestBody ValueListSetting val) {

      try{
      	logger.debug("Request received for value list settings with listName: " + val.toString());
     
      	if (val.getId()==null)	val.setId(Utils.generateID());
      	ValueListSetting res= valueRepository.save(val);
     
        return ResponseEntity.ok(res);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }

}
