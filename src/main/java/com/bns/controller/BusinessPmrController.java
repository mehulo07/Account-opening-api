package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessPmr;
import com.bns.model.BusinessType;
import com.bns.repository.BusinessPmrRepository;
import com.bns.repository.BusinessTypeRepository;
import com.bns.service.BusinessPmrService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessPmrController {
	@Autowired
	private BusinessTypeRepository businessTypeRepository;
	@Autowired
	private BusinessPmrRepository businessPmrRepository;
	@Autowired
	private BusinessPmrService businessPmrService;

	// BusinessPmr creation
	@PostMapping("/businessPmr")
	public BusinessPmr createBusinessPmr(@Valid @RequestBody BusinessPmr businessPmr) throws Exception {

		Long businessTypeid = businessPmr.getBusinessType().getBusinessTypeId();

		BusinessType businessType = businessTypeRepository.findById(businessTypeid).get();
		businessPmr.setBusinessType(businessType);

		return businessPmrService.createBusinessPmr(businessPmr);

	}

	// business Pmr getAll List Value by BusinessTypeID
	@GetMapping("/businessPmrBusinessTypeID/{id}")
	public List<BusinessPmr> getbusinessPmrBusinessTypeID(@PathVariable(value = "id") Long businessPmrID)
			throws Exception {
		return businessPmrRepository.findByBusinessTypeID(businessPmrID);
	}

	@GetMapping("/businessPmr/{id}")
	public ResponseEntity<BusinessPmr> BusinessPmrList(@PathVariable(value = "id") Long businessPmrId)
			throws ResourceNotFoundException {
		BusinessPmr businessPmr = businessPmrService.getBusinessPmrId(businessPmrId).orElseThrow(
				() -> new ResourceNotFoundException("Business Pmr not found for this id :: " + businessPmrId));
		return ResponseEntity.ok().body(businessPmr);
	}

}
