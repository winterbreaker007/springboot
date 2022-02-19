package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.*;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.CompanyRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.MembershipRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.NoteRepository;
import com.blackwater.blackwaterbillingmanagementsystem.model.NoteRequest;
import com.blackwater.blackwaterbillingmanagementsystem.model.RequestParamIDs;
import com.blackwater.blackwaterbillingmanagementsystem.service.AuthenticationService;
import com.blackwater.blackwaterbillingmanagementsystem.service.DocumentService;
import com.blackwater.blackwaterbillingmanagementsystem.service.LogService;
import com.blackwater.blackwaterbillingmanagementsystem.service.NoteService;
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
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

@RestController
@CrossOrigin
@RequestMapping(value = "/notes")
public class NoteController {
  private static final Logger logger = LoggerFactory.getLogger(NoteController.class);

  private NoteRepository noteRepository;
  private NoteService noteService;
  private AuthenticationService authenticationService;
  private LogService logService;
  


  public NoteController(
      NoteRepository noteRepository,
      NoteService noteService,
      AuthenticationService authenticationService,
      LogService logService) {
    this.noteRepository = noteRepository;
    this.noteService = noteService;
    this.authenticationService = authenticationService;
    this.logService = logService;
  }


  @PostMapping(value = "/saveGeneralNoteWithBilling")
  public ResponseEntity<Note> saveGeneralNoteWithBilling(@RequestBody NoteRequest param){
	  
	  Job job=param.getJob();
	  String changedNote=param.getUpdatednote();
	  User user=param.getUser();	  
	  Note note=new Note();		
	  
			  
	  	note.setId(Utils.generateID());	
		note.setNotes(changedNote);
		note.setJobId(job.getId());
		note.setClientId(job.getClientId());	    	
		note.setContactWhoisit("Role");
		note.setContactType("General Note");
		note.setContactValue("Billing");
		note.setNoteGroup(2);
//		String userId=user.getId();
//		note.setEnteredId(userId);
		note.setUser(user);
		
    	int userLevel=user.getAccessLevel();	    	
    	if (userLevel==4)	note.setContactName("Technician");
    	if (userLevel==3)	note.setContactName("Manager");
    	if (userLevel==2)	note.setContactName("Finance");
    	if (userLevel==1)	note.setContactName("Admin");	    	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		note.setDateEntered(dtf.format(now));	    	
    	Note noteSave = noteRepository.save(note);		    
	    logger.debug("Successfully saved general note billing: " + note.toString());
	    return ResponseEntity.ok(note);
	    
  }  
  @PostMapping(value = "/saveGeneralNoteWithOperation")
  public ResponseEntity<Note> saveGeneralNoteWithOperation(@RequestBody NoteRequest param){
	  
	  Job job=param.getJob();
	  String changedNote=param.getUpdatednote();
	  User user=param.getUser();	  
	  Note note=new Note();	    
	  		  
    	note.setId(Utils.generateID());
    	note.setNotes(changedNote);    	
    	note.setJobId(job.getId());
    	note.setClientId(job.getClientId());    	
    	note.setContactWhoisit("Role");
    	note.setContactType("General Note");
    	note.setContactValue("Operations");
    	note.setNoteGroup(4);    	
    	int userLevel=user.getAccessLevel();
    	//String userId=user.getId();
    	//note.setEnteredId(userId);
    	note.setUser(user);
    	
    	if (userLevel==4)	note.setContactName("Technician");
    	if (userLevel==3)	note.setContactName("Manager");
    	if (userLevel==2)	note.setContactName("Finance");
    	if (userLevel==1)	note.setContactName("Admin");
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();
	   note.setDateEntered(dtf.format(now));
    	
    	Note noteSave = noteRepository.save(note);	    	
	    	    
	    logger.debug("Successfully saved general note operation: " + note.toString());
	    return ResponseEntity.ok(note);	    
  }
  
  @PostMapping(value = "/saveLogNoteWithOperation")
  public ResponseEntity<Note> saveContactLogNoteWithOperation(@RequestBody NoteRequest param){
	  
	  
	  Contact contact=param.getContact();
	  Job job=param.getJob();
	  String changedNote=param.getUpdatednote();
	  User user=param.getUser();	  
	  Note note=new Note();
	  
	  
	  note.setId(Utils.generateID());
	  note.setContactName(contact.getName());
	  note.setContactType(contact.getType());
	  note.setContactWhoisit(contact.getRole());
	  note.setContactValue(contact.contact);
	  note.setClientId(job.getClientId());
	  
	  
	  note.setJobId(job.getId());
	  note.setNotes(changedNote);
	  note.setUser(user);
	  
	  logger.debug("Request received to save contact log note with operation====: " + note.getId());
	    if(Objects.isNull(note.getNotes())){
	    	logger.debug("empty note to update");
	    } else {
	    	note.setNoteGroup(4);	    	
//	    	String userId=user.getId();
//	    	note.setEnteredId(userId);
//	    	note.setUser(user);
	    	
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();
    	   note.setDateEntered(dtf.format(now));	    	
	    	Note noteSave = noteRepository.save(note);	    	
	    }	    
	    logger.debug("Successfully saved log note with op: " + note.toString());
	    return ResponseEntity.ok(note);	    
  }
  
  @PostMapping(value = "/saveLogNoteWithBilling")
  public ResponseEntity<Note> saveLogNoteWithBilling(@RequestBody NoteRequest param){
	  Contact contact=param.getContact();
	  Job job=param.getJob();
	  String changedNote=param.getUpdatednote();
	  User user=param.getUser();
	  
	  Note note=new Note();
	  note.setId(Utils.generateID());
	  note.setContactName(contact.getName());
	  note.setContactType(contact.getType());
	  note.setContactWhoisit(contact.getRole());
	  note.setContactValue(contact.contact);
	  note.setClientId(job.getClientId());
	  
	  note.setNoteGroup(user.getAccessLevel());
	  note.setJobId(job.getId());
	  note.setNotes(changedNote);
	  note.setUser(user);
//	  note.setEnteredId(user.getId());
	  
	  
	  logger.debug("Request received to save note with billing====: " + note.getId());
	    if(Objects.isNull(note.getNotes())){
	    	logger.debug("empty note to update");
	    } else {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    	   LocalDateTime now = LocalDateTime.now();
    	   note.setDateEntered(dtf.format(now));
    	   logger.debug("saved note with time: " + dtf.format(now));	    	
	    	
		    Note noteSave = noteRepository.save(note);
	    }
	    logger.debug("Successfully saved note: " + note.toString());
	    return ResponseEntity.ok(note);
	    
  }
  
  @PostMapping(value = "/updateNote")
  public ResponseEntity<Note> updateNote(@RequestBody Note note){
	  logger.debug("===Request received to update note====: " + note);
//	    if(Objects.isNull(updatednote)){
//	    	logger.debug("empty note to update");
//	    } else {
//	    	note.setNotes(updatednote);
//	    }
//	    
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();
	   note.setDateEntered(dtf.format(now));
	    Note noteSaved = noteRepository.save(note);
	    logger.debug("Successfully updated note: " + noteSaved.toString());
	    return ResponseEntity.ok(noteSaved);
//	    
//	  return null;
  }
  
  @PostMapping(value = "/deleteByClientId")
  public ResponseEntity<String> deleteByClientId(@RequestBody String clientId) {
	  if (!clientId.isEmpty()) {
		  clientId = clientId.substring(0, clientId.length() - 1);
	    }
	  
	  try {
		  Optional<Note> note=noteRepository.findById(clientId);
		  noteRepository.delete(note.get());		
		  return ResponseEntity.ok(clientId);
	  }catch(Exception e) {
		  e.printStackTrace();
		  return ResponseEntity.badRequest().body("Faild to delete note with id: " + clientId);
	  }
	  
  }
  
  
  @GetMapping(value = "/getAllNotesByClientId")
  public ResponseEntity<List<Note>> getAllNotes(@RequestParam String clientId) {

    try{
    	logger.debug("Request received for user with client id: " + clientId);
        List<Note> notes= noteRepository.findByClientIdOrderByDateEnteredDesc (clientId);
        
        logger.debug("Sending notes with size: " + notes.size());
        

      return ResponseEntity.ok(notes);
    } catch (Exception e){
      e.printStackTrace();
//      logService.errorLog("NoteController.java", "Exception thrown. getAllNotes() ::: " + e.getMessage());
      throw e;
    }
  }

}
