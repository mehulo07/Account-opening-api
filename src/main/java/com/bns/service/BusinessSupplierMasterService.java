package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.MarketingPref;
import com.bns.model.BusinessSupplierMaster;
import com.bns.repository.BusinessSupplierMasterRepository;



@Service
public class BusinessSupplierMasterService {

	
	@Autowired
    private BusinessSupplierMasterRepository businessSupplierRepository;
	
	public BusinessSupplierMaster createBusinessSupplier(BusinessSupplierMaster businessSupplier) {
        return businessSupplierRepository.save(businessSupplier);
    }
	
	public Optional < BusinessSupplierMaster > getBusinessSupplierId(Long businessSupplierId)
		    throws ResourceNotFoundException {
		        return businessSupplierRepository.findById(businessSupplierId);
		    }
}
