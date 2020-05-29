package com.bns.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccOpeningReg;
import com.bns.model.AccountOpeningMarketingPref;
import com.bns.repository.AccOpeningRegRepository;
import com.bns.service.AccountOpeningMarketingPrefService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AccountOpeningMarketingPrefController {
	@Autowired
	private AccountOpeningMarketingPrefService accountOpeningMarketingPrefService;

	@Autowired
	private AccOpeningRegRepository accOpeningRegRepository;

	@PostMapping("/accountOpeningMarketingPref")
	public AccountOpeningMarketingPref marketingpreferenceSave(
			@Valid @RequestBody AccountOpeningMarketingPref accountOpeningMarketingPref) throws Exception {
		int reg = accountOpeningMarketingPref.getAccOpeningReg().getAccountOpeningRegInfoId();

		AccOpeningReg accOpeningReg = accOpeningRegRepository.findById(reg).get();

		accountOpeningMarketingPref.setAccOpeningReg(accOpeningReg);
		return accountOpeningMarketingPrefService.createAccountOpeningMarketingPref(accountOpeningMarketingPref);

	}

	@GetMapping("/accountOpeningMarketingPref/{id}")
	public ResponseEntity<AccountOpeningMarketingPref> marketingpreferenceList(
			@PathVariable(value = "id") Long marketingpreId) throws ResourceNotFoundException {
		AccountOpeningMarketingPref accountOpeningMarketingPref = accountOpeningMarketingPrefService
				.getMarketingPrefId(marketingpreId).orElseThrow(() -> new ResourceNotFoundException(
						"Marketing preference not found for this id :: " + marketingpreId));
		return ResponseEntity.ok().body(accountOpeningMarketingPref);
	}

}
