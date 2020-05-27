package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bns.service.AccOpeningEmailInfoService;
import com.bns.utility.EncryptionDecryptionUtility;

@RestController
@CrossOrigin
@PropertySource(value = "classpath:cipher.properties" , ignoreResourceNotFound = true)
public class UtilityController {
	
	@Autowired
	private AccOpeningEmailInfoService accOpeningEmailInfoService;

	@Autowired
	private Environment env;
	
	@GetMapping("/verifyEmail")
	public String validateAccountMail(@RequestParam(name = "key") String key) {
		String accRegId;
		System.out.println("Key is :" + key);
		accRegId = EncryptionDecryptionUtility.decrypt(String.valueOf(key), env.getProperty("cipherkey"));
		return accOpeningEmailInfoService.verifyAccEmailAddress(accRegId);
	}
}
