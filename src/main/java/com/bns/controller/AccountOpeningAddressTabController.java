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

import com.bns.repository.AccountOpeningAddressTabRepository;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.service.AccountOpeningAddressTabService;

@RestController
@CrossOrigin
public class AccountOpeningAddressTabController {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private AccountOpeningAddressTabRepository accountOpeningAddressTabRepository;

	@Autowired
	private AccountOpeningAddressTabService accountOpeningAddressTabService;

	@PostMapping("/accountOpeningAddressTab")
	public AccountOpeningAddressTab accountOpeningAddressTabSave(
			@Valid @RequestBody AccountOpeningAddressTab accountOpeningAddressTab) throws Exception {

		long businessinfoid = accountOpeningAddressTab.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningAddressTab.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningAddressTabService.createAccountOpeningAddressTab(accountOpeningAddressTab);

	}

	@GetMapping("/accountOpeningAddressTab/{id}")
	public ResponseEntity<AccountOpeningAddressTab> getAccountOpeningAddressTabById(
			@PathVariable(value = "id") Long accountOpeningAddressTabId) throws ResourceNotFoundException {
		AccountOpeningAddressTab accountOpeningAddressTab = accountOpeningAddressTabService
				.getAccountOpeningAddressTabId(accountOpeningAddressTabId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening AddressTab not found for this id :: " + accountOpeningAddressTabId));
		return ResponseEntity.ok().body(accountOpeningAddressTab);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningAddressTabByBusinessinfoId/{id}")
	public List<AccountOpeningAddressTab> getAccountOpeningAddressTabBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningAddressTabRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningAddressTab/{id}")
	public ResponseEntity<AccountOpeningAddressTab> updateAccountOpeningAddressTab(
			@PathVariable(value = "id") Long accountOpeningAddressTabId,
			@Valid @RequestBody AccountOpeningAddressTab accountOpeningAddressTab) throws ResourceNotFoundException {

		AccountOpeningAddressTab accountOpeningAddressTab1 = accountOpeningAddressTabService
				.updateAccountOpeningAddressTab(accountOpeningAddressTabId, accountOpeningAddressTab);
		return ResponseEntity.ok(accountOpeningAddressTab1);
	}

}
