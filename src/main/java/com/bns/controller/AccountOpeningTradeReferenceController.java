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
import com.bns.model.AccountOpeningTradeReference;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.AccountOpeningTradeReferenceRepository;
import com.bns.service.AccountOpeningTradeReferenceService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AccountOpeningTradeReferenceController {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private AccountOpeningTradeReferenceRepository accountOpeningTradeReferenceRepository;

	@Autowired
	private AccountOpeningTradeReferenceService accountOpeningTradeReferenceService;

	@PostMapping("/accountOpeningTradeReference")
	public AccountOpeningTradeReference accountOpeningTradeReferenceSave(
			@Valid @RequestBody AccountOpeningTradeReference accountOpeningTradeReference) throws Exception {

		long businessinfoid = accountOpeningTradeReference.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningTradeReference.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningTradeReferenceService.createAccountOpeningTradeReference(accountOpeningTradeReference);
	}

	@GetMapping("/accountOpeningTradeReference/{id}")
	public ResponseEntity<AccountOpeningTradeReference> getAccountOpeningTradeReferenceById(
			@PathVariable(value = "id") Long accountOpeningTradeReferenceId) throws ResourceNotFoundException {
		AccountOpeningTradeReference accountOpeningTradeReference = accountOpeningTradeReferenceService
				.getAccountOpeningTradeReferenceId(accountOpeningTradeReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningTradeReference not found for this id :: " + accountOpeningTradeReferenceId));
		return ResponseEntity.ok().body(accountOpeningTradeReference);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningTradeReferenceByBusinessinfoId/{id}")
	public List<AccountOpeningTradeReference> getAccountOpeningTradeReferenceBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningTradeReferenceRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningTradeReference/{id}")
	public ResponseEntity<AccountOpeningTradeReference> updateAccountOpeningTradeReference(
			@PathVariable(value = "id") Long accountOpeningTradeReferenceId,
			@Valid @RequestBody AccountOpeningTradeReference accountOpeningTradeReference)
			throws ResourceNotFoundException {

		AccountOpeningTradeReference accountOpeningTradeReference1 = accountOpeningTradeReferenceService
				.updateAccountOpeningTradeReference(accountOpeningTradeReferenceId, accountOpeningTradeReference);
		return ResponseEntity.ok(accountOpeningTradeReference1);
	}

}
