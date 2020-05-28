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
import com.bns.model.BusinessBuyingGroup;

import com.bns.model.BusinessType;
import com.bns.repository.BusinessBuyingGroupRepository;
import com.bns.repository.BusinessTypeRepository;
import com.bns.service.BusinessBuyingGroupService;

@RestController
@CrossOrigin
public class BusinessBuyingGroupController {

	@Autowired
	private BusinessTypeRepository businessTypeRepository;
	@Autowired
	private BusinessBuyingGroupRepository businessBuyingGroupRepository;
	@Autowired
	private BusinessBuyingGroupService businessBuyingGroupService;

	// Business Buying Group creation
	@PostMapping("/businessBuyingGroup")
	public BusinessBuyingGroup createBusinessBuyingGroup(@Valid @RequestBody BusinessBuyingGroup businessBuyingGroup)
			throws Exception {

		Long businessTypeid = businessBuyingGroup.getBusinessType().getBusinessTypeId();

		BusinessType businessType = businessTypeRepository.findById(businessTypeid).get();
		businessBuyingGroup.setBusinessType(businessType);

		return businessBuyingGroupService.createBusinessBuyingGroup(businessBuyingGroup);

	}

	// Business Buying Group getAll List Value by BusinessTypeID
	@GetMapping("/businessBuyingGroupBusinessTypeID/{id}")
	public List<BusinessBuyingGroup> getbusinessBuyingGroupBusinessTypeID(
			@PathVariable(value = "id") Long businessTypeID) throws Exception {
		return businessBuyingGroupRepository.findByBusinessTypeID(businessTypeID);
	}

	@GetMapping("/businessBuyingGroup/{id}")
	public ResponseEntity<BusinessBuyingGroup> businessBuyingGroupList(
			@PathVariable(value = "id") Long businessBuyingGroupId) throws ResourceNotFoundException {
		BusinessBuyingGroup businessBuyingGroup = businessBuyingGroupService
				.getBusinessBuyingGroupId(businessBuyingGroupId).orElseThrow(() -> new ResourceNotFoundException(
						"Business Buying Group not found for this id :: " + businessBuyingGroupId));
		return ResponseEntity.ok().body(businessBuyingGroup);
	}

}
