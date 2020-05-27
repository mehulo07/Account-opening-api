package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.AccountOpeningSecurityQue;

import com.bns.repository.AccountOpeningSecurityQueRepository;


@Service
public class AccountOpeningSecurityQueService {
	@Autowired
    private AccountOpeningSecurityQueRepository accountOpeningSecurityQueRepository;
	
	public AccountOpeningSecurityQue createAccountOpeningSecurityQue(AccountOpeningSecurityQue accountOpeningSecurityQue) {
        return accountOpeningSecurityQueRepository.save(accountOpeningSecurityQue);
    }
	

}
