package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.MarketingPref;
import com.bns.model.Employee;
import com.bns.repository.MarketingPrefRepository;

@Service
public class MarketingPrefService {
	@Autowired
    private MarketingPrefRepository accountOpeningMarketingPrefRepository;
	
	public MarketingPref createAccountOpeningMarketingPref(MarketingPref accountOpeningMarketingPref) {
        return accountOpeningMarketingPrefRepository.save(accountOpeningMarketingPref);
    }
	
	 public Optional < MarketingPref > getMarketingPrefId(Long marketingPrefId)
			    throws ResourceNotFoundException {
			        return accountOpeningMarketingPrefRepository.findById(marketingPrefId);
			    }
	
}
