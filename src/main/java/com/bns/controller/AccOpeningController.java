package com.bns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.Registration;
import com.bns.repository.RegistrationRepository;
import com.bns.service.EmailInfoService;
import com.bns.service.RegistrationService;

import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class AccOpeningController {

	@Autowired
	private RegistrationService accOpeningRegService;

	@Autowired
	private EmailInfoService accOpeningEmailInfoService;

	@Autowired
	private RegistrationRepository registrationRepository;

//	@PostMapping("/")
//	public String accOpeningForm(@RequestBody Registration accOpeningReg) throws Exception {
//		System.out.println("inisde accOpeningForm");
//		System.out.println("Added by hussain 1");
//		return accOpeningRegService.createAccount(accOpeningReg);
//	}

	@PostMapping("/")
	public JSONObject accOpeningForm(@RequestBody Registration accOpeningReg) throws Exception {
		System.out.println("inisde accOpeningForm");
		System.out.println("Added by hussain 1");
		JSONObject json = new JSONObject();

		List<Registration> existsEmail = registrationRepository
				.getRegistrationByemail(accOpeningReg.getRegEmailAddress());

		if (existsEmail.isEmpty()) {
			Registration t = accOpeningRegService.createAccount(accOpeningReg);

			json.put("Registration", t);
			json.put("Message", "User Registration Successfully.");

		} else {

			json.put("Message", "There is already a User registered with the Email Address provided.");

		}

		return json;

	}
}
