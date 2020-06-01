package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.BusinessTypeMaster;
import com.bns.repository.BusinessTypeMasterRepository;



@Service
public class BusinessTypeMasterService {
	
	@Autowired
    private BusinessTypeMasterRepository businessTypeRepository;
	
	 public BusinessTypeMaster createBusinessType(BusinessTypeMaster businessType) {
	        return businessTypeRepository.save(businessType);
	    }
	 
	 public List <BusinessTypeMaster> getAllBusinessType() {
	        return businessTypeRepository.findAll();
	    }
	 
	 
}
