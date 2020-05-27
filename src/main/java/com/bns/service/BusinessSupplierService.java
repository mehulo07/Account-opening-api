package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningMarketingPref;
import com.bns.model.BusinessSupplier;
import com.bns.repository.BusinessSupplierRepository;



@Service
public class BusinessSupplierService {

	
	@Autowired
    private BusinessSupplierRepository businessSupplierRepository;
	
	public BusinessSupplier createBusinessSupplier(BusinessSupplier businessSupplier) {
        return businessSupplierRepository.save(businessSupplier);
    }
	
	public Optional < BusinessSupplier > getBusinessSupplierId(Long businessSupplierId)
		    throws ResourceNotFoundException {
		        return businessSupplierRepository.findById(businessSupplierId);
		    }
}
