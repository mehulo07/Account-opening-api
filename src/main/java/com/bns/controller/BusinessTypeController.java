package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.BusinessType;
import com.bns.model.CompanyType;
import com.bns.repository.BusinessTypeRepository;
import com.bns.repository.CompanyTypeRepository;
import com.bns.service.BusinessTypeService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessTypeController {

	@Autowired
	private BusinessTypeService businessTypeService;

	@Autowired
	private CompanyTypeRepository companyTypeRepository;

	@Autowired
	private BusinessTypeRepository businessTypeRepository;

	// BusinessType creation
	@PostMapping("/businessType")
	public BusinessType createBusinessType(@Valid @RequestBody BusinessType businessType) {
		try {
			Long companyId = businessType.getCompanyType().getCompanyId();

			CompanyType companyType = companyTypeRepository.findById(companyId).get();

			businessType.setCompanyType(companyType);
			return businessTypeService.createBusinessType(businessType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception while save Business Type Data");
		}
		return businessType;
	}

	// BusinessType getAll List Value
	@GetMapping("/bussinessType")
	public List<BusinessType> getbussinessTypeList() {
		return businessTypeService.getAllBusinessType();
	}

	// BusinessType getAll List Value by companyID
	@GetMapping("/bussinessTypeCompanyID/{id}")
	public List<BusinessType> getbussinessTypeListByCompanyID(@PathVariable(value = "id") Long companyid) {
		return businessTypeRepository.findByCompanyID(companyid);
	}

}
