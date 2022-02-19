package com.blackwater.blackwaterbillingmanagementsystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.Visit;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.VisitRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/visits")
public class VisitController {

	VisitRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(VisitController.class);

	public VisitController(VisitRepository repository) {
		this.repository = repository;
	}

	@GetMapping(value = "/getJobVisits")
	public ResponseEntity<List<Visit>> getJobVisits(@RequestParam String jobId) {
		logger.debug("Request received for job visits");
		List<Visit> jobVisits = repository.findVisitsByJobId(jobId);
		logger.debug("Sending job visits");
		return ResponseEntity.ok(jobVisits);
	}

}
