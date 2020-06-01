package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.SecurityQue;

import com.bns.repository.SecurityQueRepository;


@Service
public class SecurityQueService {
	@Autowired
    private SecurityQueRepository accountOpeningSecurityQueRepository;
	
	public SecurityQue createAccountOpeningSecurityQue(SecurityQue accountOpeningSecurityQue) {
        return accountOpeningSecurityQueRepository.save(accountOpeningSecurityQue);
    }
	

}
