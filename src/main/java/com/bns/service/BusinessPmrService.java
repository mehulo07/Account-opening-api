package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessPmr;
import com.bns.repository.BusinessPmrRepository;

@Service
public class BusinessPmrService {
	@Autowired
    private BusinessPmrRepository businessPmrRepository;
	
	
	public BusinessPmr createBusinessPmr(BusinessPmr businessPmr) {
        return businessPmrRepository.save(businessPmr);
    }
	
	public Optional < BusinessPmr > getBusinessPmrId(Long businessPmrId)
		    throws ResourceNotFoundException {
		        return businessPmrRepository.findById(businessPmrId);
		    }
}
