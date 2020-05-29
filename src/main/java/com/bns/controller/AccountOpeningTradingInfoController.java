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
import com.bns.model.AccountOpeningBusinessInfo;

import com.bns.model.AccountOpeningTradingInfo;
import com.bns.repository.AccountOpeningBusinessInfoRepository;

import com.bns.repository.AccountOpeningTradingInfoRepository;
import com.bns.service.AccountOpeningTradingInfoService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AccountOpeningTradingInfoController {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private AccountOpeningTradingInfoRepository accountOpeningTradingInfoRepository;

	@Autowired
	private AccountOpeningTradingInfoService accountOpeningTradingInfoService;

	@PostMapping("/accountOpeningTradingInfo")
	public AccountOpeningTradingInfo accountOpeningTradingInfoSave(
			@Valid @RequestBody AccountOpeningTradingInfo accountOpeningTradingInfo) throws Exception {

		long businessinfoid = accountOpeningTradingInfo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningTradingInfo.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningTradingInfoService.createAccountOpeningTradingInfo(accountOpeningTradingInfo);

	}

	@GetMapping("/accountOpeningTradingInfo/{id}")
	public ResponseEntity<AccountOpeningTradingInfo> getAccountOpeningTradingInfoById(
			@PathVariable(value = "id") Long accountOpeningTradingInfoId) throws ResourceNotFoundException {
		AccountOpeningTradingInfo accountOpeningTradingInfo = accountOpeningTradingInfoService
				.getAccountOpeningTradingInfoId(accountOpeningTradingInfoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningTradingInfo not found for this id :: " + accountOpeningTradingInfoId));
		return ResponseEntity.ok().body(accountOpeningTradingInfo);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningTradingInfoByBusinessinfoId/{id}")
	public List<AccountOpeningTradingInfo> getAccountOpeningTradingInfoBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningTradingInfoRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningTradingInfo/{id}")
	public ResponseEntity<AccountOpeningTradingInfo> updateAccountOpeningTradingInfo(
			@PathVariable(value = "id") Long accountOpeningTradingInfoId,
			@Valid @RequestBody AccountOpeningTradingInfo accountOpeningTradingInfo) throws ResourceNotFoundException {

		AccountOpeningTradingInfo accountOpeningTradingInfo1 = accountOpeningTradingInfoService
				.updateAccountOpeningTradingInfo(accountOpeningTradingInfoId, accountOpeningTradingInfo);
		return ResponseEntity.ok(accountOpeningTradingInfo1);
	}

}
