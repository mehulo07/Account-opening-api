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
import com.bns.repository.AddressRepository;
import com.bns.repository.BusinessInfoRepository;
import com.bns.service.AddressService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AddressController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private AddressRepository accountOpeningAddressTabRepository;

	@Autowired
	private AddressService accountOpeningAddressTabService;

	@PostMapping("/accountOpeningAddressTab")
	public AccountAddress accountOpeningAddressTabSave(
			@Valid @RequestBody AccountAddress accountOpeningAddressTab) throws Exception {

		long businessinfoid = accountOpeningAddressTab.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningAddressTab.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningAddressTabService.createAccountOpeningAddressTab(accountOpeningAddressTab);

	}

	@GetMapping("/accountOpeningAddressTab/{id}")
	public ResponseEntity<AccountAddress> getAccountOpeningAddressTabById(
			@PathVariable(value = "id") Long accountOpeningAddressTabId) throws ResourceNotFoundException {
		AccountAddress accountOpeningAddressTab = accountOpeningAddressTabService
				.getAccountOpeningAddressTabId(accountOpeningAddressTabId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening AddressTab not found for this id :: " + accountOpeningAddressTabId));
		return ResponseEntity.ok().body(accountOpeningAddressTab);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningAddressTabByBusinessinfoId/{id}")
	public List<AccountAddress> getAccountOpeningAddressTabBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningAddressTabRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningAddressTab/{id}")
	public ResponseEntity<AccountAddress> updateAccountOpeningAddressTab(
			@PathVariable(value = "id") Long accountOpeningAddressTabId,
			@Valid @RequestBody AccountAddress accountOpeningAddressTab) throws ResourceNotFoundException {

		AccountAddress accountOpeningAddressTab1 = accountOpeningAddressTabService
				.updateAccountOpeningAddressTab(accountOpeningAddressTabId, accountOpeningAddressTab);
		return ResponseEntity.ok(accountOpeningAddressTab1);
	}

}
