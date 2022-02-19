package com.blackwater.blackwaterbillingmanagementsystem.controller;

import com.blackwater.blackwaterbillingmanagementsystem.db.model.PriceListRegion;
import com.blackwater.blackwaterbillingmanagementsystem.db.model.Visit;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.PriceListRegionRepository;
import com.blackwater.blackwaterbillingmanagementsystem.db.repository.VisitRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/priceListRegion")
public class PriceListRegionController {

	PriceListRegionRepository priceListRegionRepository;

	private static final Logger logger = LoggerFactory.getLogger(PriceListRegionController.class);

	public PriceListRegionController(PriceListRegionRepository priceListRegionRepository) {
		this.priceListRegionRepository = priceListRegionRepository;
	}

	@GetMapping(value = "/priceListRegion")
	public ResponseEntity<PriceListRegion> getJobVisits(@RequestParam String regionId) {
		logger.debug("Request received for price list region");
		PriceListRegion priceListRegion = priceListRegionRepository.findByRegionId(regionId);
		logger.debug("Sending price list region: {}", priceListRegion.getRegionName());
		return ResponseEntity.ok(priceListRegion);
	}

}
