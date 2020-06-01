package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessOrderSystemMaster;
import com.bns.repository.BusinessOrderSystemMasterRepository;

@Service
public class BusinessOrderSystemMasterService {
	@Autowired
    private BusinessOrderSystemMasterRepository businessOrderSystemRepository;
	
	public BusinessOrderSystemMaster createBusinessOrderSystem(BusinessOrderSystemMaster businessOrderSystem) {
        return businessOrderSystemRepository.save(businessOrderSystem);
    }
	
	public Optional < BusinessOrderSystemMaster > getBusinessOrderSystemId(Long businessOrderSystemId)
		    throws ResourceNotFoundException {
		        return businessOrderSystemRepository.findById(businessOrderSystemId);
		    }

}
