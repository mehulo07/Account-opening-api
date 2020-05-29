package com.bns.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
//@PropertySource(value = "classpath:cipher.properties" , ignoreResourceNotFound = true)
public class UtilityController {
	
	/*
	 * @Autowired private AccOpeningEmailInfoService accOpeningEmailInfoService;
	 * 
	 * @Autowired private Environment env;
	 * 
	 * @GetMapping("/verifyEmail") public String
	 * validateAccountMail(@RequestParam(name = "key") String key) { String
	 * accRegId; System.out.println("Key is :" + key); accRegId =
	 * EncryptionDecryptionUtility.decrypt(String.valueOf(key),
	 * env.getProperty("cipherkey")); return
	 * accOpeningEmailInfoService.verifyAccEmailAddress(accRegId); }
	 * 
	 * 
	 * @GetMapping("/resendEmail") public String
	 * resendVerificationLink(@RequestParam(name = "key") String key) { String
	 * accRegId; System.out.println("Key is :" + key); accRegId =
	 * EncryptionDecryptionUtility.decrypt(String.valueOf(key),
	 * env.getProperty("cipherkey")); return
	 * accOpeningEmailInfoService.verifyAccEmailAddress(accRegId); }
	 */
}
