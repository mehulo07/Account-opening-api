package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bns.model.SecurityQuestion;
import com.bns.repository.SecurityQuestionRepository;

@Service
public class SecurityQuestionService {
	 @Autowired
	    private SecurityQuestionRepository securityQuestionRepository;
	
	 public SecurityQuestion createSecurityQuestion(SecurityQuestion securityQuestion) {
	        return securityQuestionRepository.save(securityQuestion);
	    }
	 
	 public List <SecurityQuestion> getAllSecurityQuestion() {
	        return securityQuestionRepository.findAll();
	    }
}
