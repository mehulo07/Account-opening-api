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

import com.bns.model.BusinessOrderSystemMaster;
import com.bns.model.BusinessTypeMaster;
import com.bns.repository.BusinessOrderSystemMasterRepository;
import com.bns.repository.BusinessTypeMasterRepository;
import com.bns.service.BusinessOrderSystemMasterService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessOrderSystemMasterController {
	@Autowired
	private BusinessTypeMasterRepository businessTypeRepository;
	@Autowired
	private BusinessOrderSystemMasterRepository businessOrderSystemRepository;
	@Autowired
	private BusinessOrderSystemMasterService businessOrderSystemService;
	
	// Business Order System creation
				@PostMapping("/businessOrderSystem")
				public BusinessOrderSystemMaster createBusinessOrderSystem(@Valid @RequestBody BusinessOrderSystemMaster businessOrderSystem) throws Exception {
				
						Long businessTypeid= businessOrderSystem.getBusinessType().getBusinessTypeId();

						BusinessTypeMaster businessType = businessTypeRepository.findById(businessTypeid).get();
						businessOrderSystem.setBusinessType(businessType);
						
						return businessOrderSystemService.createBusinessOrderSystem(businessOrderSystem);
					
				}
				
				// Business Order System  getAll List Value by BusinessTypeID
				@GetMapping("/businessOrderSystemBusinessTypeID/{id}")
				public List<BusinessOrderSystemMaster> getBusinessOrderSystemBusinessTypeID(@PathVariable(value = "id") Long businessTypeID) throws Exception {
					return businessOrderSystemRepository.findByBusinessTypeID(businessTypeID);
				}
				
				
				@GetMapping("/businessOrderSystem/{id}")
				public ResponseEntity<BusinessOrderSystemMaster> businessOrderSystemList(
						@PathVariable(value = "id") Long businessOrderSystemId) throws ResourceNotFoundException {
					BusinessOrderSystemMaster businessOrderSystem = businessOrderSystemService
							.getBusinessOrderSystemId(businessOrderSystemId).orElseThrow(() -> new ResourceNotFoundException(
									"Business Order System not found for this id :: " + businessOrderSystemId));
					return ResponseEntity.ok().body(businessOrderSystem);
				}

}
