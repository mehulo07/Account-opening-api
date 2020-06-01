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
import com.bns.model.AccountAddress;
import com.bns.model.BusinessInfo;
import com.bns.model.BusinessBuyingGroupMaster;
import com.bns.model.BusinessOrderSystemMaster;
import com.bns.model.BusinessPmrMaster;
import com.bns.model.BusinessSupplierMaster;
import com.bns.model.TradingInformationDetails;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessBuyingGroupRepository;
import com.bns.repository.BusinessOrderSystemMasterRepository;
import com.bns.repository.BusinessPmrMasterRepository;
import com.bns.repository.BusinessSupplierMasterRepository;
import com.bns.repository.TradingInformationDetailsRepository;
import com.bns.service.TradingInformationDetailsService;

@RestController
@CrossOrigin
public class TradingInformationDetailsController {

	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private TradingInformationDetailsRepository tradingInformationDetailsRepository;
	@Autowired
	private TradingInformationDetailsService tradingInformationDetailsService;
	@Autowired
	private BusinessSupplierMasterRepository businessSupplierRepository;
	@Autowired
	private BusinessPmrMasterRepository businessPmrRepository;
	@Autowired
	private BusinessOrderSystemMasterRepository businessOrderSystemRepository;

	@Autowired
	private BusinessBuyingGroupRepository businessBuyingGroupRepository;

	@PostMapping("/tradingInformationDetails")
	public TradingInformationDetails tradingInformationDetailsSave(
			@Valid @RequestBody TradingInformationDetails tradingInformationDetails) throws Exception {

		long businessinfoid = tradingInformationDetails.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		tradingInformationDetails.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		long suppierid = tradingInformationDetails.getBusinessSupplier().getBusinessSupplierId();
		BusinessSupplierMaster businessSupplier = businessSupplierRepository.findById(suppierid).get();
		tradingInformationDetails.setBusinessSupplier(businessSupplier);

		long businessPmrid = tradingInformationDetails.getBusinessPmr().getBusinessPmrId();
		BusinessPmrMaster businessPmr = businessPmrRepository.findById(businessPmrid).get();
		tradingInformationDetails.setBusinessPmr(businessPmr);

		long businessSystemId = tradingInformationDetails.getBusinessOrderSystem().getBusinessOrderSystemId();
		BusinessOrderSystemMaster businessOrderSystem = businessOrderSystemRepository.findById(businessSystemId).get();
		tradingInformationDetails.setBusinessOrderSystem(businessOrderSystem);

		long businessGpId = tradingInformationDetails.getBusinessBuyingGroup().getBusinessBuyingGroupId();
		BusinessBuyingGroupMaster businessBuyingGroup = businessBuyingGroupRepository.findById(businessGpId).get();
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
