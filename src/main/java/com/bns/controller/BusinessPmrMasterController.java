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

import com.bns.model.BusinessPmrMaster;
import com.bns.model.BusinessTypeMaster;
import com.bns.repository.BusinessPmrMasterRepository;
import com.bns.repository.BusinessTypeMasterRepository;
import com.bns.service.BusinessPmrMasterService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessPmrMasterController {
	@Autowired
	private BusinessTypeMasterRepository businessTypeRepository;
	@Autowired
	private BusinessPmrMasterRepository businessPmrRepository;
	@Autowired
	private BusinessPmrMasterService businessPmrService;

	// BusinessPmr creation
	@PostMapping("/businessPmr")
	public BusinessPmrMaster createBusinessPmr(@Valid @RequestBody BusinessPmrMaster businessPmr) throws Exception {

		Long businessTypeid = businessPmr.getBusinessType().getBusinessTypeId();

		BusinessTypeMaster businessType = businessTypeRepository.findById(businessTypeid).get();
		businessPmr.setBusinessType(businessType);

		return businessPmrService.createBusinessPmr(businessPmr);

	}

	// business Pmr getAll List Value by BusinessTypeID
	@GetMapping("/businessPmrBusinessTypeID/{id}")
	public List<BusinessPmrMaster> getbusinessPmrBusinessTypeID(@PathVariable(value = "id") Long businessPmrID)
			throws Exception {
		return businessPmrRepository.findByBusinessTypeID(businessPmrID);
	}

	@GetMapping("/businessPmr/{id}")
	public ResponseEntity<BusinessPmrMaster> BusinessPmrList(@PathVariable(value = "id") Long businessPmrId)
			throws ResourceNotFoundException {
		BusinessPmrMaster businessPmr = businessPmrService.getBusinessPmrId(businessPmrId).orElseThrow(
				() -> new ResourceNotFoundException("Business Pmr not found for this id :: " + businessPmrId));
		return ResponseEntity.ok().body(businessPmr);
	}

}
