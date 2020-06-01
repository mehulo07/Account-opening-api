package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.CompanyTypeMaster;
import com.bns.service.CompanyTypeMasterService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class CompanyTypeMasterController {

	@Autowired
	private CompanyTypeMasterService companyTypeService;

	// Company Type creation
	@PostMapping("/companyType")
	public CompanyTypeMaster createCompanyType(@Valid @RequestBody CompanyTypeMaster companyType) {
		System.out.println("inisde Company Type creation");
		return companyTypeService.createCompanyType(companyType);
	}

	// Company Type getAll List Value
	@GetMapping("/companyType")
	public List<CompanyTypeMaster> getcompanyTypeList() {
		return companyTypeService.getAllCompanyType();
	}

}
