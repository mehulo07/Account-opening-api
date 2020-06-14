package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.BusinessInfo;
import com.bns.model.BusinessInformationWorkingHours;
import com.bns.model.LicenceInformationDetailsOne;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessInformationWorkingHoursRepository;
import com.bns.repository.LicenceInformationDetailsOneRepository;
import com.bns.service.BusinessInformationWorkingHoursService;
import com.bns.service.LicenceInformationDetailsOneService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessInformationWorkingHoursController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private BusinessInformationWorkingHoursRepository businessInformationWorkingHoursRepository;

	@Autowired
	private BusinessInformationWorkingHoursService businessInformationWorkingHoursService;

	@PostMapping("/businessInformationWorkingHours")
	public BusinessInformationWorkingHours businessInformationWorkingHoursSave(
			@Valid @RequestBody BusinessInformationWorkingHours businessInformationWorkingHours) throws Exception {

		long businessinfoid = businessInformationWorkingHours.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		businessInformationWorkingHours.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return businessInformationWorkingHoursService
				.createBusinessInformationWorkingHours(businessInformationWorkingHours);
	}

	@GetMapping("/businessInformationWorkingHours/{id}")
	public ResponseEntity<BusinessInformationWorkingHours> getBusinessInformationWorkingHoursById(
			@PathVariable(value = "id") Long businessInformationWorkingHoursId) throws ResourceNotFoundException {
		BusinessInformationWorkingHours businessInformationWorkingHours = businessInformationWorkingHoursService
				.getBusinessInformationWorkingHoursId(businessInformationWorkingHoursId).orElseThrow(
						() -> new ResourceNotFoundException("BusinessInformationWorkingHours not found for this id :: "
								+ businessInformationWorkingHoursId));
		return ResponseEntity.ok().body(businessInformationWorkingHours);
		
	}
	
	// reg id getAll List
		@GetMapping("/businessInformationWorkingHoursByBusinessinfoId/{id}")
		public List<BusinessInformationWorkingHours> getBusinessInformationWorkingHoursBusinessID(
				@PathVariable(value = "id") Long businessinfoId) {
			return businessInformationWorkingHoursRepository.findByBusinessInfoId(businessinfoId);
		}

		@PutMapping("/businessInformationWorkingHours/{id}")
		public ResponseEntity<BusinessInformationWorkingHours> updateBusinessInformationWorkingHours(
				@PathVariable(value = "id") Long businessInformationWorkingHoursId,
				@Valid @RequestBody BusinessInformationWorkingHours businessInformationWorkingHours)
				throws ResourceNotFoundException {

			BusinessInformationWorkingHours businessInformationWorkingHours1 = businessInformationWorkingHoursService
					.updateBusinessInformationWorkingHours(businessInformationWorkingHoursId, businessInformationWorkingHours);
			return ResponseEntity.ok(businessInformationWorkingHours1);
		}

}
