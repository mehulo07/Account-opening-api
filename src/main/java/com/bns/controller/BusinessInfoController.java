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
import com.bns.model.Registration;
import com.bns.model.BusinessInfo;
import com.bns.model.LinkedAccount;
import com.bns.model.BusinessType;
import com.bns.model.CompanyType;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessTypeRepository;
import com.bns.repository.CompanyTypeRepository;
import com.bns.service.BusinessInfoService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessInfoController {

	@Autowired
	private RegistrationRepository accOpeningRegRepository;
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private BusinessInfoService accountOpeningBusinessInfoService;

	@Autowired
	private BusinessTypeRepository businessTypeRepository;
	@Autowired
	private CompanyTypeRepository companyTypeRepository;

	@PostMapping("/accountOpeningBusinessInfo")
	public BusinessInfo accountOpeningBusinessInfoSave(
			@Valid @RequestBody BusinessInfo accountOpeningBusinessInfo) throws Exception {

		int reg = accountOpeningBusinessInfo.getAccOpeningReg().getAccountOpeningRegInfoId();
		Registration accOpeningReg = accOpeningRegRepository.findById(reg).get();
		accountOpeningBusinessInfo.setAccOpeningReg(accOpeningReg);

		long businessTypeid = accountOpeningBusinessInfo.getBusinessType().getBusinessTypeId();
		BusinessType businessType = businessTypeRepository.findById(businessTypeid).get();
		accountOpeningBusinessInfo.setBusinessType(businessType);

		long companyid = accountOpeningBusinessInfo.getCompanyType().getCompanyId();
		CompanyType companyType = companyTypeRepository.findById(companyid).get();
		accountOpeningBusinessInfo.setCompanyType(companyType);

		return accountOpeningBusinessInfoService.createAccountOpeningBusinessInfoc(accountOpeningBusinessInfo);

	}

	@GetMapping("/accountOpeningBusinessInfo/{id}")
	public ResponseEntity<BusinessInfo> getAccountOpeningBusinessInfoById(
			@PathVariable(value = "id") Long accountOpeningBusinessInfoId) throws ResourceNotFoundException {
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoService
				.getAccountOpeningBusinessInfoId(accountOpeningBusinessInfoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening Business Info not found for this id :: " + accountOpeningBusinessInfoId));
		return ResponseEntity.ok().body(accountOpeningBusinessInfo);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningBusinessInfoByRegId/{id}")
	public List<BusinessInfo> getAccountOpeningBusinessInfoRegID(
			@PathVariable(value = "id") Long accRegId) {
		return accountOpeningBusinessInfoRepository.findByaccRegId(accRegId);
	}

	@PutMapping("/accountOpeningBusinessInfo/{id}")
	public ResponseEntity<BusinessInfo> updateAccountOpeningBusinessInfo(
			@PathVariable(value = "id") Long accountOpeningBusinessInfoId,
			@Valid @RequestBody BusinessInfo accountOpeningBusinessInfo)
			throws ResourceNotFoundException {

		BusinessInfo accountOpeningBusinessInfo1 = accountOpeningBusinessInfoService
				.updateAccountOpeningBusinessInfo(accountOpeningBusinessInfoId, accountOpeningBusinessInfo);
		return ResponseEntity.ok(accountOpeningBusinessInfo1);
	}

}
