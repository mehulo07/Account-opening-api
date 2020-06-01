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

import com.bns.model.BusinessSupplierMaster;
import com.bns.model.BusinessTypeMaster;
import com.bns.repository.BusinessSupplierMasterRepository;
import com.bns.repository.BusinessTypeMasterRepository;
import com.bns.service.BusinessSupplierMasterService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class BusinessSupplierMasterController {

	@Autowired
	private BusinessSupplierMasterService businessSupplierService;
	@Autowired
	private BusinessTypeMasterRepository businessTypeRepository;

	@Autowired
	private BusinessSupplierMasterRepository businessSupplierRepository;

	// Business Supplier creation
	@PostMapping("/businessSupplier")
	public BusinessSupplierMaster createBusinessSupplier(@Valid @RequestBody BusinessSupplierMaster businessSupplier)
			throws Exception {

		Long businessTypeid = businessSupplier.getBusinessType().getBusinessTypeId();

		BusinessTypeMaster businessType = businessTypeRepository.findById(businessTypeid).get();
		businessSupplier.setBusinessType(businessType);

		return businessSupplierService.createBusinessSupplier(businessSupplier);

	}

	// Business Supplier getAll List Value by BusinessTypeID
	@GetMapping("/businessSupplierBusinessTypeID/{id}")
	public List<BusinessSupplierMaster> getbussinessSupplierBusinessTypeID(@PathVariable(value = "id") Long businessTypeID)
			throws Exception {
		return businessSupplierRepository.findByBusinessTypeID(businessTypeID);
	}

	@GetMapping("/businessSupplier/{id}")
	public ResponseEntity<BusinessSupplierMaster> BusinessSupplierList(@PathVariable(value = "id") Long businessSupplierId)
			throws ResourceNotFoundException {
		BusinessSupplierMaster businessSupplier = businessSupplierService.getBusinessSupplierId(businessSupplierId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"Business Supplier not found for this id :: " + businessSupplierId));
		return ResponseEntity.ok().body(businessSupplier);
	}

}
