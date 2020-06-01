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

import com.bns.model.BusinessTypeMaster;
import com.bns.model.CompanyTypeMaster;
import com.bns.repository.BusinessTypeMasterRepository;
import com.bns.repository.CompanyTypeMasterRepository;
import com.bns.service.BusinessTypeMasterService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessTypeMasterController {

	@Autowired
	private BusinessTypeMasterService businessTypeService;

	@Autowired
	private CompanyTypeMasterRepository companyTypeRepository;

	@Autowired
	private BusinessTypeMasterRepository businessTypeRepository;

	// BusinessType creation
	@PostMapping("/businessType")
	public BusinessTypeMaster createBusinessType(@Valid @RequestBody BusinessTypeMaster businessType) {
		try {
			Long companyId = businessType.getCompanyType().getCompanyId();

			CompanyTypeMaster companyType = companyTypeRepository.findById(companyId).get();

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
	public List<BusinessTypeMaster> getbussinessTypeList() {
		return businessTypeService.getAllBusinessType();
	}

	// BusinessType getAll List Value by companyID
	@GetMapping("/bussinessTypeCompanyID/{id}")
	public List<BusinessTypeMaster> getbussinessTypeListByCompanyID(@PathVariable(value = "id") Long companyid) {
		return businessTypeRepository.findByCompanyID(companyid);
	}

}
