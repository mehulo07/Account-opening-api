package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.Registration;
import com.bns.model.MarketingPref;
import com.bns.model.SecurityQue;
import com.bns.model.SecurityQuestion;
import com.bns.repository.RegistrationRepository;
import com.bns.service.SecurityQueService;
import com.bns.service.SecurityQuestionService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class SecurityQuestionController {

	@Autowired
	private SecurityQuestionService securityQuestionService;

	@Autowired
	private SecurityQueService accountOpeningSecurityQueService;

	@Autowired
	private RegistrationRepository accOpeningRegRepository;

	// securityQuestion creation
	@PostMapping("/securityQuestion")
	public SecurityQuestion createSecurityQuestion(@Valid @RequestBody SecurityQuestion securityQuestion) {
		System.out.println("inisde Security Question creation");
		return securityQuestionService.createSecurityQuestion(securityQuestion);
	}

	// securityQuestion getAll List Value
	@GetMapping("/securityQuestion")
	public List<SecurityQuestion> getquestionList() {
		return securityQuestionService.getAllSecurityQuestion();
	}

	@PostMapping("/securityQuestionAnswer")
	public SecurityQue saveQuestionAndAns(
			@Valid @RequestBody SecurityQue accountOpeningSecurityQue) throws Exception {

		int reg = accountOpeningSecurityQue.getAccOpeningReg().getAccountOpeningRegInfoId();

		Registration accOpeningReg = accOpeningRegRepository.findById(reg).get();

		accountOpeningSecurityQue.setAccOpeningReg(accOpeningReg);
		return accountOpeningSecurityQueService.createAccountOpeningSecurityQue(accountOpeningSecurityQue);

	}
}
