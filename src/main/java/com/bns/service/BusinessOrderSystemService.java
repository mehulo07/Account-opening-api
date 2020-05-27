package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessOrderSystem;
import com.bns.repository.BusinessOrderSystemRepository;

@Service
public class BusinessOrderSystemService {
	@Autowired
    private BusinessOrderSystemRepository businessOrderSystemRepository;
	
	public BusinessOrderSystem createBusinessOrderSystem(BusinessOrderSystem businessOrderSystem) {
        return businessOrderSystemRepository.save(businessOrderSystem);
    }
	
	public Optional < BusinessOrderSystem > getBusinessOrderSystemId(Long businessOrderSystemId)
		    throws ResourceNotFoundException {
		        return businessOrderSystemRepository.findById(businessOrderSystemId);
		    }

}
