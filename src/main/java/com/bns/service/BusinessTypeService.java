package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.BusinessType;
import com.bns.repository.BusinessTypeRepository;



@Service
public class BusinessTypeService {
	
	@Autowired
    private BusinessTypeRepository businessTypeRepository;
	
	 public BusinessType createBusinessType(BusinessType businessType) {
	        return businessTypeRepository.save(businessType);
	    }
	 
	 public List <BusinessType> getAllBusinessType() {
	        return businessTypeRepository.findAll();
	    }
	 
	 
}
