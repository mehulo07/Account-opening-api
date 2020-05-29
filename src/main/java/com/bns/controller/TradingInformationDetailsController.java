package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningAddressTab;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.BusinessBuyingGroup;
import com.bns.model.BusinessOrderSystem;
import com.bns.model.BusinessPmr;
import com.bns.model.BusinessSupplier;
import com.bns.model.TradingInformationDetails;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.BusinessBuyingGroupRepository;
import com.bns.repository.BusinessOrderSystemRepository;
import com.bns.repository.BusinessPmrRepository;
import com.bns.repository.BusinessSupplierRepository;
import com.bns.repository.TradingInformationDetailsRepository;
import com.bns.service.TradingInformationDetailsService;

@RestController
@CrossOrigin
public class TradingInformationDetailsController {

	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private TradingInformationDetailsRepository tradingInformationDetailsRepository;
	@Autowired
	private TradingInformationDetailsService tradingInformationDetailsService;
	@Autowired
	private BusinessSupplierRepository businessSupplierRepository;
	@Autowired
	private BusinessPmrRepository businessPmrRepository;
	@Autowired
	private BusinessOrderSystemRepository businessOrderSystemRepository;

	@Autowired
	private BusinessBuyingGroupRepository businessBuyingGroupRepository;

	@PostMapping("/tradingInformationDetails")
	public TradingInformationDetails tradingInformationDetailsSave(
			@Valid @RequestBody TradingInformationDetails tradingInformationDetails) throws Exception {

		long businessinfoid = tradingInformationDetails.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		tradingInformationDetails.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		long suppierid = tradingInformationDetails.getBusinessSupplier().getBusinessSupplierId();
		BusinessSupplier businessSupplier = businessSupplierRepository.findById(suppierid).get();
		tradingInformationDetails.setBusinessSupplier(businessSupplier);

		long businessPmrid = tradingInformationDetails.getBusinessPmr().getBusinessPmrId();
		BusinessPmr businessPmr = businessPmrRepository.findById(businessPmrid).get();
		tradingInformationDetails.setBusinessPmr(businessPmr);

		long businessSystemId = tradingInformationDetails.getBusinessOrderSystem().getBusinessOrderSystemId();
		BusinessOrderSystem businessOrderSystem = businessOrderSystemRepository.findById(businessSystemId).get();
		tradingInformationDetails.setBusinessOrderSystem(businessOrderSystem);

		long businessGpId = tradingInformationDetails.getBusinessBuyingGroup().getBusinessBuyingGroupId();
		BusinessBuyingGroup businessBuyingGroup = businessBuyingGroupRepository.findById(businessGpId).get();
		tradingInformationDetails.setBusinessBuyingGroup(businessBuyingGroup);

		return tradingInformationDetailsService.createTradingInformationDetails(tradingInformationDetails);

	}

	@GetMapping("/tradingInformationDetails/{id}")
	public ResponseEntity<TradingInformationDetails> getTradingInformationDetailsById(
			@PathVariable(value = "id") Long tradingInformationDetailsId) throws ResourceNotFoundException {
		TradingInformationDetails tradingInformationDetails = tradingInformationDetailsService
				.getTradingInformationDetailsId(tradingInformationDetailsId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"TradingInformationDetails not found for this id :: " + tradingInformationDetailsId));
		return ResponseEntity.ok().body(tradingInformationDetails);
	}

	@GetMapping("/tradingInformationDetailsByBusinessinfoId/{id}")
	public List<TradingInformationDetails> getTradingInformationDetailsBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return tradingInformationDetailsRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/tradingInformationDetails/{id}")
	public ResponseEntity<TradingInformationDetails> updateTradingInformationDetails(
			@PathVariable(value = "id") Long tradingInformationDetailsId,
			@Valid @RequestBody TradingInformationDetails tradingInformationDetails) throws ResourceNotFoundException {

		TradingInformationDetails tradingInformationDetails1 = tradingInformationDetailsService
				.updateTradingInformationDetails(tradingInformationDetailsId, tradingInformationDetails);
		return ResponseEntity.ok(tradingInformationDetails1);
	}

}
