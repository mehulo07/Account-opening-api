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
import com.bns.model.AccountOpeningAddressTab;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.AccountOpeningBusinessTypeInfo;
import com.bns.model.AccountOpeningLinkedAcc;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.AccountOpeningBusinessTypeInfoRepository;
import com.bns.service.AccountOpeningBusinessTypeInfoService;

@RestController
@CrossOrigin
public class AccountOpeningBusinessTypeInfoController {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private AccountOpeningBusinessTypeInfoRepository accountOpeningBusinessTypeInfoRepository;

	@Autowired
	private AccountOpeningBusinessTypeInfoService accountOpeningBusinessTypeInfoService;

	@PostMapping("/accountOpeningBusinessTypeInfo")
	public AccountOpeningBusinessTypeInfo accountOpeningBusinessTypeInfoSave(
			@Valid @RequestBody AccountOpeningBusinessTypeInfo accountOpeningBusinessTypeInfo) throws Exception {

		long businessinfoid = accountOpeningBusinessTypeInfo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningBusinessTypeInfo.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningBusinessTypeInfoService
				.createAccountOpeningBusinessTypeInfo(accountOpeningBusinessTypeInfo);

	}

	@GetMapping("/accountOpeningBusinessTypeInfo/{id}")
	public ResponseEntity<AccountOpeningBusinessTypeInfo> getAccountOpeningBusinessTypeInfoById(
			@PathVariable(value = "id") Long accountOpeningBusinessTypeInfoId) throws ResourceNotFoundException {
		AccountOpeningBusinessTypeInfo acountOpeningBusinessTypeInfo = accountOpeningBusinessTypeInfoService
				.getAccountOpeningBusinessTypeInfoId(accountOpeningBusinessTypeInfoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening BusinessType Info not found for this id :: "
								+ accountOpeningBusinessTypeInfoId));
		return ResponseEntity.ok().body(acountOpeningBusinessTypeInfo);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningBusinessTypeInfoByBusinessinfoId/{id}")
	public List<AccountOpeningBusinessTypeInfo> getAccountOpeningBusinessTypeInfoBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningBusinessTypeInfoRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningBusinessTypeInfo/{id}")
	public ResponseEntity<AccountOpeningBusinessTypeInfo> updateAccountOpeningBusinessTypeInfo(
			@PathVariable(value = "id") Long accountOpeningBusinessTypeInfoId,
			@Valid @RequestBody AccountOpeningBusinessTypeInfo accountOpeningBusinessTypeInfo)
			throws ResourceNotFoundException {

		AccountOpeningBusinessTypeInfo accountOpeningBusinessTypeInfo1 = accountOpeningBusinessTypeInfoService
				.updateAccountOpeningBusinessTypeInfo(accountOpeningBusinessTypeInfoId, accountOpeningBusinessTypeInfo);
		return ResponseEntity.ok(accountOpeningBusinessTypeInfo1);
	}

}
