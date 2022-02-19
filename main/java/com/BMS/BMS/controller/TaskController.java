package com.blackwater.blackwaterbillingmanagementsystem.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Note;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Task;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.TaskJobClientProjection;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.TaskRepository;
import com.blackwater.blackwaterbillingmanagementsystem.model.NoteRequest;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.TaskRepository;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.utils.Utils;


@RestController
@CrossOrigin
@RequestMapping(value = "/tasks")
public class TaskController {
	private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private AuthenticationService authenticationService;
    private LogService logService;
    private TaskRepository taskRepository;

    public TaskController(AuthenticationService authenticationService, LogService logService, TaskRepository taskRepository) {

        this.authenticationService = authenticationService;
        this.logService = logService;
        this.taskRepository = taskRepository;
    }
    @PostMapping(value = "/saveTask")
    public ResponseEntity<List<TaskJobClientProjection>> saveTask(@RequestBody Task task){
    	List<TaskJobClientProjection> res=null;
    	try {    	
    	logger.debug("=Request received to update task====: " + task);
    	if (task.getId()=="") {
    		task.setId(Utils.generateID());
    	}
    	Task taskSaved = taskRepository.save(task);
    	
	    
	    logger.debug("Successfully updated noteID: " + taskSaved.getId());	    
	    res=taskRepository.findProjectionByTask(taskSaved.getId());
	    
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	    return ResponseEntity.ok(res);
    }
    @GetMapping(value = "/getAllTasksByUserId")
    public ResponseEntity<List<TaskJobClientProjection>> getAllTasks(@RequestParam String userId) {

      try{
      	logger.debug("Request received for tasks with assigned id: " + userId);

     List<TaskJobClientProjection> tasks= taskRepository.findProjectionByUser(userId);
//   List<Task> tasks= taskRepository.findByUser(userId);
        logger.debug("Sending tasks with size: " + tasks.size());
        return ResponseEntity.ok(tasks);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }
    @GetMapping(value = "/getAllTasksByCompanyId")
    public ResponseEntity<List<TaskJobClientProjection>> getAllTasksByCompanyId(@RequestParam String companyId) {

      try{
      	logger.debug("Request received for tasks with assigned id: " + companyId);

     List<TaskJobClientProjection> tasks= taskRepository.findProjectionByCompany(companyId);
//   List<Task> tasks= taskRepository.findByUser(userId);
        logger.debug("Sending tasks with size: " + tasks.size());
        return ResponseEntity.ok(tasks);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }

    @GetMapping(value = "/getAllTasksByCompanyIds")
    public ResponseEntity<List<List<TaskJobClientProjection>>> getAllTasksByCompanyIds(@RequestParam List<String> companyIds) {
    // public ResponseEntity<List<TaskJobClientProjection>> getAllTasksByCompanyIds(@RequestParam List<String> companyIds) {

      try{
        logger.debug("Request received for all tasks with company.length = " + companyIds.size());

        // List<TaskJobClientProjection> tasks= taskRepository.findProjectionByCompanyIn(companyIds);
        List<List<TaskJobClientProjection>> tasks = new ArrayList<>();
        for ( int i = 0; i < companyIds.size(); i ++ ) {
          List<TaskJobClientProjection> task = taskRepository.findProjectionByCompany(companyIds.get(i));
          tasks.add(task);
        }
     
//   List<Task> tasks= taskRepository.findByUser(userId);
        logger.debug("Sending tasks with size: " + tasks.size());
        return ResponseEntity.ok(tasks);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }

    @GetMapping(value = "/getTaskById")
    public ResponseEntity<List<TaskJobClientProjection>> getTaskById(@RequestParam String taskId) {

      try{
      	logger.debug("Request received for tasks with assigned id: " + taskId);

     List<TaskJobClientProjection> tasks= taskRepository.findProjectionByTask(taskId);
//   List<Task> tasks= taskRepository.findByUser(userId);
        logger.debug("Sending tasks with size: " + tasks.size());
        return ResponseEntity.ok(tasks);
      } catch (Exception e){
        e.printStackTrace();
//        logService.errorLog("taskController.java", "Exception thrown. getAlltasks() ::: " + e.getMessage());
        throw e;
      }
    }

    @PostMapping(value = "/deleteTasksByIds")
    public ResponseEntity<String> deleteTasksByIds(@RequestBody String[] Ids) {

      try{
      	logger.debug("Request received for delete tasks of all: " + Ids.length);

      	for (int i=0;i<Ids.length;i++)
      	{
      		Task task=taskRepository.findById(Ids[i]);
      		
      		taskRepository.delete(task);
      		
      	}
        return ResponseEntity.ok("deleted successfully");
      } catch (Exception e){
        e.printStackTrace();
//        
        throw e;
      }
    }
}
