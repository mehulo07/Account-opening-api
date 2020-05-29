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
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.LicenceInformationDetailsOne;
import com.bns.model.LicenceInformationDetailsTwo;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.LicenceInformationDetailsTwoRepository;

import com.bns.service.LicenceInformationDetailsTwoService;

@RestController
@CrossOrigin
public class LicenceInformationDetailsTwoController {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private LicenceInformationDetailsTwoRepository licenceInformationDetailsTwoRepository;

	@Autowired
	private LicenceInformationDetailsTwoService licenceInformationDetailsTwoService;

	@PostMapping("/licenceInformationDetailsTwo")
	public LicenceInformationDetailsTwo licenceInformationDetailsTwoSave(
			@Valid @RequestBody LicenceInformationDetailsTwo licenceInformationDetailsTwo) throws Exception {

		long businessinfoid = licenceInformationDetailsTwo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		licenceInformationDetailsTwo.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return licenceInformationDetailsTwoService.createLicenceInformationDetailsTwo(licenceInformationDetailsTwo);

	}

	@GetMapping("/licenceInformationDetailsTwo/{id}")
	public ResponseEntity<LicenceInformationDetailsTwo> getLicenceInformationDetailsTwoById(
			@PathVariable(value = "id") Long licenceInformationDetailsTwoId) throws ResourceNotFoundException {
		LicenceInformationDetailsTwo licenceInformationDetailsTwo = licenceInformationDetailsTwoService
				.getLicenceInformationDetailsTwoId(licenceInformationDetailsTwoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"licenceInformationDetailsTwoId not found for this id :: " + licenceInformationDetailsTwoId));
		return ResponseEntity.ok().body(licenceInformationDetailsTwo);
	}
	
	// reg id getAll List
		@GetMapping("/licenceInformationDetailsTwoByBusinessinfoId/{id}")
		public List<LicenceInformationDetailsTwo> getLicenceInformationDetailsTwoBusinessID(
				@PathVariable(value = "id") Long businessinfoId) {
			return licenceInformationDetailsTwoRepository.findByBusinessInfoId(businessinfoId);
		}

		@PutMapping("/licenceInformationDetailsTwo/{id}")
		public ResponseEntity<LicenceInformationDetailsTwo> updateLicenceInformationDetailsTwo(
				@PathVariable(value = "id") Long licenceInformationDetailsTwoId,
				@Valid @RequestBody LicenceInformationDetailsTwo licenceInformationDetailsTwo)
				throws ResourceNotFoundException {

			LicenceInformationDetailsTwo licenceInformationDetailsTwo1 = licenceInformationDetailsTwoService
					.updateLicenceInformationDetailsTwo(licenceInformationDetailsTwoId, licenceInformationDetailsTwo);
			return ResponseEntity.ok(licenceInformationDetailsTwo1);
		}


}
