package com.bns.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.Registration;
import com.bns.repository.RegistrationRepository;
import com.bns.service.EmailInfoService;
import com.bns.service.RegistrationService;

import io.swagger.annotations.ApiModelProperty;
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

	@PostMapping("/accOpeningForm")
	@ApiModelProperty(name="Registration Form",value="Registration Form")
	public JSONObject accOpeningForm(@RequestBody Registration accOpeningReg,@RequestParam(name = "url") String url) throws Exception {
		System.out.println("inisde accOpeningForm");
		System.out.println("Added by hussain 1");
		JSONObject json = new JSONObject();

		List<Registration> existsEmail = registrationRepository
				.getRegistrationByemail(accOpeningReg.getRegEmailAddress());

		if (existsEmail.isEmpty()) {
			Registration t = accOpeningRegService.createAccount(accOpeningReg,url);

			json.put("Registration", t);
			json.put("Message", "User Registration Successfully.");
			json.put("status", 200);
			
			return json;

		} else {

			json.put("Message", "There is already a User registered with the Email Address provided.");
			json.put("status", 409);

			 return json;

		}

	}
}
