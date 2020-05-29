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
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessOrderSystem;
import com.bns.model.BusinessType;
import com.bns.repository.BusinessOrderSystemRepository;
import com.bns.repository.BusinessTypeRepository;
import com.bns.service.BusinessOrderSystemService;

@RestController
@CrossOrigin
public class BusinessOrderSystemController {
	@Autowired
	private BusinessTypeRepository businessTypeRepository;
	@Autowired
	private BusinessOrderSystemRepository businessOrderSystemRepository;
	@Autowired
	private BusinessOrderSystemService businessOrderSystemService;
	
	// Business Order System creation
				@PostMapping("/businessOrderSystem")
				public BusinessOrderSystem createBusinessOrderSystem(@Valid @RequestBody BusinessOrderSystem businessOrderSystem) throws Exception {
				
						Long businessTypeid= businessOrderSystem.getBusinessType().getBusinessTypeId();

						BusinessType businessType = businessTypeRepository.findById(businessTypeid).get();
						businessOrderSystem.setBusinessType(businessType);
						
						return businessOrderSystemService.createBusinessOrderSystem(businessOrderSystem);
					
				}
				
				// Business Order System  getAll List Value by BusinessTypeID
				@GetMapping("/businessOrderSystemBusinessTypeID/{id}")
				public List<BusinessOrderSystem> getBusinessOrderSystemBusinessTypeID(@PathVariable(value = "id") Long businessTypeID) throws Exception {
					return businessOrderSystemRepository.findByBusinessTypeID(businessTypeID);
				}
				
				
				@GetMapping("/businessOrderSystem/{id}")
				public ResponseEntity<BusinessOrderSystem> businessOrderSystemList(
						@PathVariable(value = "id") Long businessOrderSystemId) throws ResourceNotFoundException {
					BusinessOrderSystem businessOrderSystem = businessOrderSystemService
							.getBusinessOrderSystemId(businessOrderSystemId).orElseThrow(() -> new ResourceNotFoundException(
									"Business Order System not found for this id :: " + businessOrderSystemId));
					return ResponseEntity.ok().body(businessOrderSystem);
				}

}
