package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningMarketingPref;
import com.bns.model.Employee;
import com.bns.repository.AccountOpeningMarketingPrefRepository;

@Service
public class AccountOpeningMarketingPrefService {
	@Autowired
    private AccountOpeningMarketingPrefRepository accountOpeningMarketingPrefRepository;
	
	public AccountOpeningMarketingPref createAccountOpeningMarketingPref(AccountOpeningMarketingPref accountOpeningMarketingPref) {
        return accountOpeningMarketingPrefRepository.save(accountOpeningMarketingPref);
    }
	
	 public Optional < AccountOpeningMarketingPref > getMarketingPrefId(Long marketingPrefId)
			    throws ResourceNotFoundException {
			        return accountOpeningMarketingPrefRepository.findById(marketingPrefId);
			    }
	
}
