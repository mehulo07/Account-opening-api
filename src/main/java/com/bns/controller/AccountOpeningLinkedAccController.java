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
import com.bns.model.AccOpeningReg;
import com.bns.model.AccountOpeningLinkedAcc;
import com.bns.model.BusinessType;
import com.bns.model.Employee;
import com.bns.repository.AccOpeningRegRepository;
import com.bns.repository.AccountOpeningLinkedAccRepository;
import com.bns.service.AccountOpeningLinkedAccService;

@RestController
@CrossOrigin
public class AccountOpeningLinkedAccController {
	
	@Autowired
	private AccOpeningRegRepository accOpeningRegRepository;
	
	@Autowired
	private AccountOpeningLinkedAccRepository accountOpeningLinkedAccRepository;
	
	@Autowired
	private AccountOpeningLinkedAccService accountOpeningLinkedAccService;
	
	@PostMapping("/accountOpeningLinkedAcc")
	public AccountOpeningLinkedAcc saveAccountOpeningLinkedAcc(
			@Valid @RequestBody AccountOpeningLinkedAcc accountOpeningLinkedAcc) throws Exception {

		int reg = accountOpeningLinkedAcc.getAccOpeningReg().getAccountOpeningRegInfoId();

		AccOpeningReg accOpeningReg = accOpeningRegRepository.findById(reg).get();

		accountOpeningLinkedAcc.setAccOpeningReg(accOpeningReg);
		return accountOpeningLinkedAccService.createAccountOpeningLinkedAcc(accountOpeningLinkedAcc);

	}
	
	@GetMapping("/accountOpeningLinkedAcc/{id}")
	public ResponseEntity<AccountOpeningLinkedAcc> getAccountOpeningLinkedAccById(@PathVariable(value = "id") Long accountOpeningLinkedAccId)
			throws ResourceNotFoundException {
		AccountOpeningLinkedAcc accountOpeningLinkedAcc = accountOpeningLinkedAccService.getAccountOpeningLinkedAccId(accountOpeningLinkedAccId)
				.orElseThrow(() -> new ResourceNotFoundException("Account Opening Linked Account not found for this id :: " + accountOpeningLinkedAccId));
		return ResponseEntity.ok().body(accountOpeningLinkedAcc);
	}
	
	// BusinessType getAll List Value by companyID
		@GetMapping("/accountOpeningLinkedAccRegID/{id}")
		public List<AccountOpeningLinkedAcc> getAccountOpeningLinkedAccListByAccRegID(@PathVariable(value = "id") Long accRegId) {
			return accountOpeningLinkedAccRepository.findByaccRegId(accRegId);
		}
	
		@PutMapping("/accountOpeningLinkedAcc/{id}")
		public ResponseEntity<AccountOpeningLinkedAcc> updateAccountOpeningLinkedAcc(@PathVariable(value = "id") Long accountOpeningLinkedAccId,
				@Valid @RequestBody AccountOpeningLinkedAcc accountOpeningLinkedAcc) throws ResourceNotFoundException {
			
			AccountOpeningLinkedAcc accountOpeningLinkedAcc1 = accountOpeningLinkedAccService.updateAccountOpeningLinkedAcc(accountOpeningLinkedAccId, accountOpeningLinkedAcc);
			return ResponseEntity.ok(accountOpeningLinkedAcc1);
		}

}
