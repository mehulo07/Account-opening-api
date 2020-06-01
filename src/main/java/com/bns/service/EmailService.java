package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bns.model.Registration;
import com.bns.repository.RegistrationRepository;
import com.bns.utility.VerificationMailSendingCls;

@Service
public class EmailService {
	
	@Autowired
	private RegistrationRepository accOpeningRegRepository;
	
	@Autowired
	private VerificationMailSendingCls verificationMailSendingCls;
	
	
	public ResponseEntity<Boolean> resendEmailService(Integer regId){
		Boolean returnVal =false;
		Registration accOpeningRegObject =accOpeningRegRepository.findById(regId).get();
		System.out.println("Resend Email Address is :"+accOpeningRegObject.getRegEmailAddress());
		returnVal = verificationMailSendingCls.sendMailFunc(accOpeningRegObject.getRegEmailAddress(), regId,true);
		
		if(returnVal) {
			return ResponseEntity.ok(true);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
		}
	}
	
}
