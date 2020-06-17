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
import com.bns.model.BusinessTypeInfo;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessTypeInfoRepository;
import com.bns.service.BusinessTypeInfoService;

import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessTypeInfoController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private BusinessTypeInfoRepository accountOpeningBusinessTypeInfoRepository;

	@Autowired
	private BusinessTypeInfoService accountOpeningBusinessTypeInfoService;

	@PostMapping("/accountOpeningBusinessTypeInfo")
	public BusinessTypeInfo accountOpeningBusinessTypeInfoSave(
			@Valid @RequestBody BusinessTypeInfo accountOpeningBusinessTypeInfo) throws Exception {

		long businessinfoid = accountOpeningBusinessTypeInfo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
		accountOpeningBusinessTypeInfo.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

//		JSONObject json = new JSONObject();
//		json.put("Status", 200);
//		json.put("message", "Successfully Added");
//		json.put("accountOpeningBusinessTypeInfo", );

		return accountOpeningBusinessTypeInfoService
				.createAccountOpeningBusinessTypeInfo(accountOpeningBusinessTypeInfo);

	}

	@GetMapping("/accountOpeningBusinessTypeInfo/{id}")
	public ResponseEntity<BusinessTypeInfo> getAccountOpeningBusinessTypeInfoById(
			@PathVariable(value = "id") Long accountOpeningBusinessTypeInfoId) throws ResourceNotFoundException {
		BusinessTypeInfo acountOpeningBusinessTypeInfo = accountOpeningBusinessTypeInfoService
				.getAccountOpeningBusinessTypeInfoId(accountOpeningBusinessTypeInfoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening BusinessType Info not found for this id :: "
								+ accountOpeningBusinessTypeInfoId));
		return ResponseEntity.ok().body(acountOpeningBusinessTypeInfo);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningBusinessTypeInfoByBusinessinfoId/{id}")
	public List<BusinessTypeInfo> getAccountOpeningBusinessTypeInfoBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningBusinessTypeInfoRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningBusinessTypeInfo/{id}")
	public ResponseEntity<BusinessTypeInfo> updateAccountOpeningBusinessTypeInfo(
			@PathVariable(value = "id") Long accountOpeningBusinessTypeInfoId,
			@Valid @RequestBody BusinessTypeInfo accountOpeningBusinessTypeInfo) throws ResourceNotFoundException {

		BusinessTypeInfo accountOpeningBusinessTypeInfo1 = accountOpeningBusinessTypeInfoService
				.updateAccountOpeningBusinessTypeInfo(accountOpeningBusinessTypeInfoId, accountOpeningBusinessTypeInfo);
		return ResponseEntity.ok(accountOpeningBusinessTypeInfo1);
	}

}
