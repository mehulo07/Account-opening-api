package com.bns.controller;

import java.util.List;

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
import com.bns.model.Registration;
import com.bns.model.LinkedAccount;
import com.bns.model.MarketingPref;
import com.bns.model.SecurityQue;
import com.bns.model.SecurityQuestionMaster;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.SecurityQueRepository;
import com.bns.repository.SecurityQuestionMasterRepository;
import com.bns.service.SecurityQueService;
import com.bns.service.SecurityQuestionMasterService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class SecurityQuestionController {

	@Autowired
	private SecurityQuestionMasterService securityQuestionService;

	@Autowired
	private SecurityQueService accountOpeningSecurityQueService;

	@Autowired
	private RegistrationRepository accOpeningRegRepository;

	@Autowired
	private SecurityQueRepository securityQueRepository;

	// securityQuestion creation
	@PostMapping("/securityQuestion")
	public SecurityQuestionMaster createSecurityQuestion(@Valid @RequestBody SecurityQuestionMaster securityQuestion) {
		System.out.println("inisde Security Question creation");
		return securityQuestionService.createSecurityQuestion(securityQuestion);
	}

	// securityQuestion getAll List Value
	@GetMapping("/securityQuestion")
	public List<SecurityQuestionMaster> getquestionList() {
		return securityQuestionService.getAllSecurityQuestion();
	}

	@PostMapping("/securityQuestionAnswer")
	public SecurityQue saveQuestionAndAns(@Valid @RequestBody SecurityQue accountOpeningSecurityQue) throws Exception {

		int reg = accountOpeningSecurityQue.getAccOpeningReg().getAccountOpeningRegInfoId();

		Registration accOpeningReg = accOpeningRegRepository.findById(reg).get();

		accountOpeningSecurityQue.setAccOpeningReg(accOpeningReg);
		return accountOpeningSecurityQueService.createAccountOpeningSecurityQue(accountOpeningSecurityQue);

	}

	@GetMapping("/securityQuestionAccRegID/{id}")
	public List<SecurityQue> getSecurityQuestionMasterAccListByAccRegID(@PathVariable(value = "id") Long accRegId) {
		return securityQueRepository.findByaccRegId(accRegId);
	}

}
