package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessSupplier;
import com.bns.model.BusinessType;
import com.bns.repository.BusinessSupplierRepository;
import com.bns.repository.BusinessTypeRepository;
import com.bns.service.BusinessSupplierService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessSupplierController {

	@Autowired
	private BusinessSupplierService businessSupplierService;
	@Autowired
	private BusinessTypeRepository businessTypeRepository;

	@Autowired
	private BusinessSupplierRepository businessSupplierRepository;

	// Business Supplier creation
	@PostMapping("/businessSupplier")
	public BusinessSupplier createBusinessSupplier(@Valid @RequestBody BusinessSupplier businessSupplier)
			throws Exception {

		Long businessTypeid = businessSupplier.getBusinessType().getBusinessTypeId();

		BusinessType businessType = businessTypeRepository.findById(businessTypeid).get();
		businessSupplier.setBusinessType(businessType);

		return businessSupplierService.createBusinessSupplier(businessSupplier);

	}

	// Business Supplier getAll List Value by BusinessTypeID
	@GetMapping("/businessSupplierBusinessTypeID/{id}")
	public List<BusinessSupplier> getbussinessSupplierBusinessTypeID(@PathVariable(value = "id") Long businessTypeID)
			throws Exception {
		return businessSupplierRepository.findByBusinessTypeID(businessTypeID);
	}

	@GetMapping("/businessSupplier/{id}")
	public ResponseEntity<BusinessSupplier> BusinessSupplierList(@PathVariable(value = "id") Long businessSupplierId)
			throws ResourceNotFoundException {
		BusinessSupplier businessSupplier = businessSupplierService.getBusinessSupplierId(businessSupplierId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Business Supplier not found for this id :: " + businessSupplierId));
		return ResponseEntity.ok().body(businessSupplier);
	}

}
