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
import com.bns.model.AccountAddressTab;
import com.bns.model.BusinessInfo;
import com.bns.repository.AddressTabRepository;
import com.bns.repository.BusinessInfoRepository;
import com.bns.service.AddressTabService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AddressTabController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private AddressTabRepository accountOpeningAddressTabRepository;

	@Autowired
	private AddressTabService accountOpeningAddressTabService;

	@PostMapping("/accountOpeningAddressTab")
	public AccountAddressTab accountOpeningAddressTabSave(
			@Valid @RequestBody AccountAddressTab accountOpeningAddressTab) throws Exception {

		long businessinfoid = accountOpeningAddressTab.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningAddressTab.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningAddressTabService.createAccountOpeningAddressTab(accountOpeningAddressTab);

	}

	@GetMapping("/accountOpeningAddressTab/{id}")
	public ResponseEntity<AccountAddressTab> getAccountOpeningAddressTabById(
			@PathVariable(value = "id") Long accountOpeningAddressTabId) throws ResourceNotFoundException {
		AccountAddressTab accountOpeningAddressTab = accountOpeningAddressTabService
				.getAccountOpeningAddressTabId(accountOpeningAddressTabId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening AddressTab not found for this id :: " + accountOpeningAddressTabId));
		return ResponseEntity.ok().body(accountOpeningAddressTab);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningAddressTabByBusinessinfoId/{id}")
	public List<AccountAddressTab> getAccountOpeningAddressTabBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningAddressTabRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningAddressTab/{id}")
	public ResponseEntity<AccountAddressTab> updateAccountOpeningAddressTab(
			@PathVariable(value = "id") Long accountOpeningAddressTabId,
			@Valid @RequestBody AccountAddressTab accountOpeningAddressTab) throws ResourceNotFoundException {

		AccountAddressTab accountOpeningAddressTab1 = accountOpeningAddressTabService
				.updateAccountOpeningAddressTab(accountOpeningAddressTabId, accountOpeningAddressTab);
		return ResponseEntity.ok(accountOpeningAddressTab1);
	}

}
