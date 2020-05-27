package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.CompanyType;

import com.bns.repository.CompanyTypeRepository;


@Service
public class CompanyTypeService {
	@Autowired
    private CompanyTypeRepository companyTypeRepository;
	
	 public CompanyType createCompanyType(CompanyType companyType) {
	        return companyTypeRepository.save(companyType);
	    }
	 
	 public List <CompanyType> getAllCompanyType() {
	        return companyTypeRepository.findAll();
	    }

}
