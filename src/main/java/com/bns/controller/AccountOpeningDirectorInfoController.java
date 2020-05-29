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
import com.bns.model.AccountOpeningAddressTab;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.AccountOpeningDirectorInfo;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.AccountOpeningDirectorInfoRepository;
import com.bns.service.AccountOpeningDirectorInfoService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AccountOpeningDirectorInfoController {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private AccountOpeningDirectorInfoRepository accountOpeningDirectorInfoRepository;

	@Autowired
	private AccountOpeningDirectorInfoService accountOpeningDirectorInfoService;

	@PostMapping("/accountOpeningDirectorInfo")
	public AccountOpeningDirectorInfo accountOpeningDirectorInfoSave(
			@Valid @RequestBody AccountOpeningDirectorInfo accountOpeningDirectorInfo) throws Exception {

		long businessinfoid = accountOpeningDirectorInfo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningDirectorInfo.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningDirectorInfoService.createAccountOpeningDirectorInfo(accountOpeningDirectorInfo);

	}

	@GetMapping("/accountOpeningDirectorInfo/{id}")
	public ResponseEntity<AccountOpeningDirectorInfo> getAccountOpeningDirectorInfoById(
			@PathVariable(value = "id") Long accountOpeningDirectorInfoId) throws ResourceNotFoundException {
		AccountOpeningDirectorInfo accountOpeningDirectorInfo = accountOpeningDirectorInfoService
				.getAccountOpeningDirectorInfoId(accountOpeningDirectorInfoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningDirectorInfo not found for this id :: " + accountOpeningDirectorInfoId));
		return ResponseEntity.ok().body(accountOpeningDirectorInfo);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningDirectorInfoByBusinessinfoId/{id}")
	public List<AccountOpeningDirectorInfo> getAccountOpeningDirectorInfoBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningDirectorInfoRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningDirectorInfo/{id}")
	public ResponseEntity<AccountOpeningDirectorInfo> updateAccountOpeningDirectorInfo(
			@PathVariable(value = "id") Long accountOpeningDirectorInfoId,
			@Valid @RequestBody AccountOpeningDirectorInfo accountOpeningDirectorInfo)
			throws ResourceNotFoundException {

		AccountOpeningDirectorInfo accountOpeningDirectorInfo1 = accountOpeningDirectorInfoService
				.updateAccountOpeningDirectorInfo(accountOpeningDirectorInfoId, accountOpeningDirectorInfo);
		return ResponseEntity.ok(accountOpeningDirectorInfo1);
	}

}
