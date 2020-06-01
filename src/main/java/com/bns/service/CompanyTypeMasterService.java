package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.CompanyTypeMaster;

import com.bns.repository.CompanyTypeMasterRepository;


@Service
public class CompanyTypeMasterService {
	@Autowired
    private CompanyTypeMasterRepository companyTypeRepository;
	
	 public CompanyTypeMaster createCompanyType(CompanyTypeMaster companyType) {
	        return companyTypeRepository.save(companyType);
	    }
	 
	 public List <CompanyTypeMaster> getAllCompanyType() {
	        return companyTypeRepository.findAll();
	    }

}
