package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bns.model.SecurityQuestionMaster;
import com.bns.repository.SecurityQuestionMasterRepository;

@Service
public class SecurityQuestionMasterService {
	 @Autowired
	    private SecurityQuestionMasterRepository securityQuestionRepository;
	
	 public SecurityQuestionMaster createSecurityQuestion(SecurityQuestionMaster securityQuestion) {
	        return securityQuestionRepository.save(securityQuestion);
	    }
	 
	 public List <SecurityQuestionMaster> getAllSecurityQuestion() {
	        return securityQuestionRepository.findAll();
	    }
}
