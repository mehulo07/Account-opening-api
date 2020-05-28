package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.AccOpeningReg;
import com.bns.service.AccOpeningEmailInfoService;
import com.bns.service.AccOpeningRegService;

@RestController
@CrossOrigin
@RequestMapping("/openAccount")
public class AccOpeningController {

	@Autowired
	private AccOpeningRegService accOpeningRegService;

	@Autowired
	private AccOpeningEmailInfoService accOpeningEmailInfoService;

	@PostMapping("/")
	public String accOpeningForm(@RequestBody AccOpeningReg accOpeningReg) throws Exception {
		System.out.println("inisde accOpeningForm");
		return accOpeningRegService.createAccount(accOpeningReg);
	}
	
}
