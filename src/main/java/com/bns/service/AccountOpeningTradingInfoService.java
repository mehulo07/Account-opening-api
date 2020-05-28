package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.AccountOpeningBusinessTypeInfo;
import com.bns.model.AccountOpeningTradingInfo;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.AccountOpeningTradingInfoRepository;

@Service
public class AccountOpeningTradingInfoService {

	
	@Autowired
    private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
    private AccountOpeningTradingInfoRepository accountOpeningTradingInfoRepository;
	
	
	public AccountOpeningTradingInfo createAccountOpeningTradingInfo(AccountOpeningTradingInfo accountOpeningTradingInfo) {
        return accountOpeningTradingInfoRepository.save(accountOpeningTradingInfo);
    }
	
	public Optional < AccountOpeningTradingInfo > getAccountOpeningTradingInfoId(Long accountOpeningTradingInfoId)
		    throws ResourceNotFoundException {
		        return accountOpeningTradingInfoRepository.findById(accountOpeningTradingInfoId);
		    }
	
	public  AccountOpeningTradingInfo updateAccountOpeningTradingInfo(Long accountOpeningTradingInfoId,
			AccountOpeningTradingInfo accountOpeningTradingInfo) throws ResourceNotFoundException {
		AccountOpeningTradingInfo accountOpeningTradingInfo1 = accountOpeningTradingInfoRepository.findById(accountOpeningTradingInfoId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningTradingInfo not found for this id :: " + accountOpeningTradingInfoId));
		 	
			long businessinfoid=accountOpeningTradingInfo.getAccountOpeningBusinessInfo().getAccountOpeningBusinessInfoId();
			AccountOpeningBusinessInfo accountOpeningBusinessInfo=accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
			accountOpeningTradingInfo1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			
			accountOpeningTradingInfo1.setAddressLineOne(accountOpeningTradingInfo.getAddressLineOne());
			accountOpeningTradingInfo1.setAddressLineTwo(accountOpeningTradingInfo.getAddressLineTwo());
			accountOpeningTradingInfo1.setCityTab(accountOpeningTradingInfo.getCityTab());
			accountOpeningTradingInfo1.setCountryTab(accountOpeningTradingInfo.getCountryTab());
			
			accountOpeningTradingInfo1.setTradingName(accountOpeningTradingInfo.getTradingName());
			
			accountOpeningTradingInfo1.setPostCode(accountOpeningTradingInfo.getPostCode());
			accountOpeningTradingInfo1.setStateTab(accountOpeningTradingInfo.getStateTab());
			


			
		        final AccountOpeningTradingInfo updatedAccountOpeningTradingInfo = accountOpeningTradingInfoRepository.save(accountOpeningTradingInfo1);
		        return updatedAccountOpeningTradingInfo;
		    }	
	
}
