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
import com.bns.model.AccountAddress;
import com.bns.model.BusinessInfo;
import com.bns.model.LicenceInformationDetailsOne;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.LicenceInformationDetailsOneRepository;
import com.bns.service.LicenceInformationDetailsOneService;

import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class LicenceInformationDetailsOneController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private LicenceInformationDetailsOneRepository licenceInformationDetailsOneRepository;

	@Autowired
	private LicenceInformationDetailsOneService licenceInformationDetailsOneService;

	@PostMapping("/licenceInformationDetailsOne")
	public LicenceInformationDetailsOne licenceInformationDetailsOneSave(
			@Valid @RequestBody LicenceInformationDetailsOne licenceInformationDetailsOne) throws Exception {

		long businessinfoid = licenceInformationDetailsOne.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
		licenceInformationDetailsOne.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
//		JSONObject json = new JSONObject();
//		json.put("Status", 200);
//		json.put("message", "Successfully Added");
//		json.put("licenceInformationDetailsOne",
//				);

		return licenceInformationDetailsOneService.createLicenceInformationDetailsOne(licenceInformationDetailsOne);

	}

	@GetMapping("/licenceInformationDetailsOne/{id}")
	public ResponseEntity<LicenceInformationDetailsOne> getLicenceInformationDetailsOneById(
			@PathVariable(value = "id") Long licenceInformationDetailsOneId) throws ResourceNotFoundException {
		LicenceInformationDetailsOne licenceInformationDetailsOne = licenceInformationDetailsOneService
				.getLicenceInformationDetailsOneId(licenceInformationDetailsOneId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"LicenceInformationDetailsOne not found for this id :: " + licenceInformationDetailsOneId));
		return ResponseEntity.ok().body(licenceInformationDetailsOne);
	}

	// reg id getAll List
	@GetMapping("/licenceInformationDetailsOneByBusinessinfoId/{id}")
	public List<LicenceInformationDetailsOne> getLicenceInformationDetailsOneBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return licenceInformationDetailsOneRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/licenceInformationDetailsOne/{id}")
	public ResponseEntity<LicenceInformationDetailsOne> updateLicenceInformationDetailsOne(
			@PathVariable(value = "id") Long licenceInformationDetailsOneId,
			@Valid @RequestBody LicenceInformationDetailsOne licenceInformationDetailsOne)
			throws ResourceNotFoundException {

		LicenceInformationDetailsOne licenceInformationDetailsOne1 = licenceInformationDetailsOneService
				.updateLicenceInformationDetailsOne(licenceInformationDetailsOneId, licenceInformationDetailsOne);
		return ResponseEntity.ok(licenceInformationDetailsOne1);
	}

}
