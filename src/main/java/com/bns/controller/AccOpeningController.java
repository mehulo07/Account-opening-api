package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.Registration;
import com.bns.service.EmailInfoService;
import com.bns.service.RegistrationService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AccOpeningController {

	@Autowired
	private RegistrationService accOpeningRegService;

	@Autowired
	private EmailInfoService accOpeningEmailInfoService;

	@PostMapping("/")
	public String accOpeningForm(@RequestBody Registration accOpeningReg) throws Exception {
		System.out.println("inisde accOpeningForm");
		System.out.println("Added by hussain 1");
		return accOpeningRegService.createAccount(accOpeningReg);
	}
	
}
	