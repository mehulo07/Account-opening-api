package com.bns.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class WelcomeController {

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String getEmployees() {
		return "Welcome!";
	}

}