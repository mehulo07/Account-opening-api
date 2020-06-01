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
import com.bns.model.BusinessBuyingGroupMaster;

import com.bns.model.BusinessTypeMaster;
import com.bns.repository.BusinessBuyingGroupRepository;
import com.bns.repository.BusinessTypeMasterRepository;
import com.bns.service.BusinessBuyingGroupService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessBuyingGroupController {

	@Autowired
	private BusinessTypeMasterRepository businessTypeRepository;
	@Autowired
	private BusinessBuyingGroupRepository businessBuyingGroupRepository;
	@Autowired
	private BusinessBuyingGroupService businessBuyingGroupService;

	// Business Buying Group creation
	@PostMapping("/businessBuyingGroup")
	public BusinessBuyingGroupMaster createBusinessBuyingGroup(@Valid @RequestBody BusinessBuyingGroupMaster businessBuyingGroup)
			throws Exception {

		Long businessTypeid = businessBuyingGroup.getBusinessType().getBusinessTypeId();

		BusinessTypeMaster businessType = businessTypeRepository.findById(businessTypeid).get();
		businessBuyingGroup.setBusinessType(businessType);

		return businessBuyingGroupService.createBusinessBuyingGroup(businessBuyingGroup);

	}

	// Business Buying Group getAll List Value by BusinessTypeID
	@GetMapping("/businessBuyingGroupBusinessTypeID/{id}")
	public List<BusinessBuyingGroupMaster> getbusinessBuyingGroupBusinessTypeID(
			@PathVariable(value = "id") Long businessTypeID) throws Exception {
		return businessBuyingGroupRepository.findByBusinessTypeID(businessTypeID);
	}

	@GetMapping("/businessBuyingGroup/{id}")
	public ResponseEntity<BusinessBuyingGroupMaster> businessBuyingGroupList(
			@PathVariable(value = "id") Long businessBuyingGroupId) throws ResourceNotFoundException {
		BusinessBuyingGroupMaster businessBuyingGroup = businessBuyingGroupService
				.getBusinessBuyingGroupId(businessBuyingGroupId).orElseThrow(() -> new ResourceNotFoundException(
						"Business Buying Group not found for this id :: " + businessBuyingGroupId));
		return ResponseEntity.ok().body(businessBuyingGroup);
	}

}
