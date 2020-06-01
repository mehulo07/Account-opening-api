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
import com.bns.model.LinkedAccount;

import com.bns.repository.RegistrationRepository;
import com.bns.repository.LinkedAccRepository;
import com.bns.service.LinkedAccService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class LinkedAccController {

	@Autowired
	private RegistrationRepository accOpeningRegRepository;

	@Autowired
	private LinkedAccRepository accountOpeningLinkedAccRepository;

	@Autowired
	private LinkedAccService accountOpeningLinkedAccService;

	@PostMapping("/accountOpeningLinkedAcc")
	public LinkedAccount saveAccountOpeningLinkedAcc(
			@Valid @RequestBody LinkedAccount accountOpeningLinkedAcc) throws Exception {

		int reg = accountOpeningLinkedAcc.getAccOpeningReg().getAccountOpeningRegInfoId();

		Registration accOpeningReg = accOpeningRegRepository.findById(reg).get();

		accountOpeningLinkedAcc.setAccOpeningReg(accOpeningReg);
		return accountOpeningLinkedAccService.createAccountOpeningLinkedAcc(accountOpeningLinkedAcc);

	}

	@GetMapping("/accountOpeningLinkedAcc/{id}")
	public ResponseEntity<LinkedAccount> getAccountOpeningLinkedAccById(
			@PathVariable(value = "id") Long accountOpeningLinkedAccId) throws ResourceNotFoundException {
		LinkedAccount accountOpeningLinkedAcc = accountOpeningLinkedAccService
				.getAccountOpeningLinkedAccId(accountOpeningLinkedAccId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening Linked Account not found for this id :: " + accountOpeningLinkedAccId));
		return ResponseEntity.ok().body(accountOpeningLinkedAcc);
	}

	// BusinessType getAll List Value by companyID
	@GetMapping("/accountOpeningLinkedAccRegID/{id}")
	public List<LinkedAccount> getAccountOpeningLinkedAccListByAccRegID(
			@PathVariable(value = "id") Long accRegId) {
		return accountOpeningLinkedAccRepository.findByaccRegId(accRegId);
	}

	@PutMapping("/accountOpeningLinkedAcc/{id}")
	public ResponseEntity<LinkedAccount> updateAccountOpeningLinkedAcc(
			@PathVariable(value = "id") Long accountOpeningLinkedAccId,
			@Valid @RequestBody LinkedAccount accountOpeningLinkedAcc) throws ResourceNotFoundException {

		LinkedAccount accountOpeningLinkedAcc1 = accountOpeningLinkedAccService
				.updateAccountOpeningLinkedAcc(accountOpeningLinkedAccId, accountOpeningLinkedAcc);
		return ResponseEntity.ok(accountOpeningLinkedAcc1);
	}

}
