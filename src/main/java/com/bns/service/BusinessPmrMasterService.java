package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessPmrMaster;
import com.bns.repository.BusinessPmrMasterRepository;

@Service
public class BusinessPmrMasterService {
	@Autowired
    private BusinessPmrMasterRepository businessPmrRepository;
	
	
	public BusinessPmrMaster createBusinessPmr(BusinessPmrMaster businessPmr) {
        return businessPmrRepository.save(businessPmr);
    }
	
	public Optional < BusinessPmrMaster > getBusinessPmrId(Long businessPmrId)
		    throws ResourceNotFoundException {
		        return businessPmrRepository.findById(businessPmrId);
		    }
}
