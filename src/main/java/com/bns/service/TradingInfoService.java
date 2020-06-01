package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.BusinessInfo;
import com.bns.model.BusinessTypeInfo;
import com.bns.model.TradingInfo;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.TradingInfoRepository;

@Service
public class TradingInfoService {

	
	@Autowired
    private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
    private TradingInfoRepository accountOpeningTradingInfoRepository;
	
	
	public TradingInfo createAccountOpeningTradingInfo(TradingInfo accountOpeningTradingInfo) {
        return accountOpeningTradingInfoRepository.save(accountOpeningTradingInfo);
    }
	
	public Optional < TradingInfo > getAccountOpeningTradingInfoId(Long accountOpeningTradingInfoId)
		    throws ResourceNotFoundException {
		        return accountOpeningTradingInfoRepository.findById(accountOpeningTradingInfoId);
		    }
	
	public  TradingInfo updateAccountOpeningTradingInfo(Long accountOpeningTradingInfoId,
			TradingInfo accountOpeningTradingInfo) throws ResourceNotFoundException {
		TradingInfo accountOpeningTradingInfo1 = accountOpeningTradingInfoRepository.findById(accountOpeningTradingInfoId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningTradingInfo not found for this id :: " + accountOpeningTradingInfoId));
		 	
			long businessinfoid=accountOpeningTradingInfo.getAccountOpeningBusinessInfo().getAccountOpeningBusinessInfoId();
			BusinessInfo accountOpeningBusinessInfo=accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
			accountOpeningTradingInfo1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			
			accountOpeningTradingInfo1.setAddressLineOne(accountOpeningTradingInfo.getAddressLineOne());
			accountOpeningTradingInfo1.setAddressLineTwo(accountOpeningTradingInfo.getAddressLineTwo());
			accountOpeningTradingInfo1.setCityTab(accountOpeningTradingInfo.getCityTab());
			accountOpeningTradingInfo1.setCountryTab(accountOpeningTradingInfo.getCountryTab());
			
			accountOpeningTradingInfo1.setTradingName(accountOpeningTradingInfo.getTradingName());
			
			accountOpeningTradingInfo1.setPostCode(accountOpeningTradingInfo.getPostCode());
			accountOpeningTradingInfo1.setStateTab(accountOpeningTradingInfo.getStateTab());
			


			
		        final TradingInfo updatedAccountOpeningTradingInfo = accountOpeningTradingInfoRepository.save(accountOpeningTradingInfo1);
		        return updatedAccountOpeningTradingInfo;
		    }	
	
}
