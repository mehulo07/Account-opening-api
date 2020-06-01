package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountAddressTab;
import com.bns.model.BusinessInfo;
import com.bns.model.BusinessBuyingGroup;
import com.bns.model.BusinessOrderSystem;
import com.bns.model.BusinessPmr;
import com.bns.model.BusinessSupplier;
import com.bns.model.TradingInformationDetails;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessBuyingGroupRepository;
import com.bns.repository.BusinessOrderSystemRepository;
import com.bns.repository.BusinessPmrRepository;
import com.bns.repository.BusinessSupplierRepository;
import com.bns.repository.TradingInformationDetailsRepository;

@Service
public class TradingInformationDetailsService {

	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private TradingInformationDetailsRepository tradingInformationDetailsRepository;
	@Autowired
	private BusinessSupplierRepository businessSupplierRepository;

	@Autowired
	private BusinessPmrRepository businessPmrRepository;
	@Autowired
	private BusinessOrderSystemRepository businessOrderSystemRepository;
	@Autowired
	private BusinessBuyingGroupRepository businessBuyingGroupRepository;

	public TradingInformationDetails createTradingInformationDetails(
			TradingInformationDetails tradingInformationDetails) {
		return tradingInformationDetailsRepository.save(tradingInformationDetails);
	}

	public Optional<TradingInformationDetails> getTradingInformationDetailsId(Long tradingInformationDetailsId)
			throws ResourceNotFoundException {
		return tradingInformationDetailsRepository.findById(tradingInformationDetailsId);
	}

	public TradingInformationDetails updateTradingInformationDetails(Long tradingInformationDetailsId,
			TradingInformationDetails tradingInformationDetails) throws ResourceNotFoundException {
		TradingInformationDetails tradingInformationDetails1 = tradingInformationDetailsRepository
				.findById(tradingInformationDetailsId).orElseThrow(() -> new ResourceNotFoundException(
						"TradingInformationDetails not found for this id :: " + tradingInformationDetailsId));

		long businessinfoid = tradingInformationDetails.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		tradingInformationDetails1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
		long suppierid = tradingInformationDetails.getBusinessSupplier().getBusinessSupplierId();
		BusinessSupplier businessSupplier = businessSupplierRepository.findById(suppierid).get();
		tradingInformationDetails1.setBusinessSupplier(businessSupplier);

		long businessPmrid = tradingInformationDetails.getBusinessPmr().getBusinessPmrId();
		BusinessPmr businessPmr = businessPmrRepository.findById(businessPmrid).get();
		tradingInformationDetails1.setBusinessPmr(businessPmr);

		long businessSystemId = tradingInformationDetails.getBusinessOrderSystem().getBusinessOrderSystemId();
		BusinessOrderSystem businessOrderSystem = businessOrderSystemRepository.findById(businessSystemId).get();
		tradingInformationDetails1.setBusinessOrderSystem(businessOrderSystem);

		long businessGpId = tradingInformationDetails.getBusinessBuyingGroup().getBusinessBuyingGroupId();
		BusinessBuyingGroup businessBuyingGroup = businessBuyingGroupRepository.findById(businessGpId).get();
		tradingInformationDetails1.setBusinessBuyingGroup(businessBuyingGroup);

		tradingInformationDetails1.setBuyerName(tradingInformationDetails.getBuyerName());
		tradingInformationDetails1.setEmailAdd(tradingInformationDetails.getEmailAdd());

		tradingInformationDetails1.setFaxNumber(tradingInformationDetails.getFaxNumber());
		tradingInformationDetails1.setMoblieNo(tradingInformationDetails.getMoblieNo());
		tradingInformationDetails1.setOtherContactName(tradingInformationDetails.getOtherContactName());
		tradingInformationDetails1.setTelephoneNumber(tradingInformationDetails.getTelephoneNumber());

		tradingInformationDetails1.setWebsiteurl(tradingInformationDetails.getWebsiteurl());

		final TradingInformationDetails updatedTradingInformationDetails = tradingInformationDetailsRepository
				.save(tradingInformationDetails1);
		return updatedTradingInformationDetails;
	}

}
