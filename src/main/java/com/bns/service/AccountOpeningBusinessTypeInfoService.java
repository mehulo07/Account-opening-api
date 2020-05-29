package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.AccountOpeningBusinessTypeInfo;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.AccountOpeningBusinessTypeInfoRepository;

@Service
public class AccountOpeningBusinessTypeInfoService {
	@Autowired
    private AccountOpeningBusinessTypeInfoRepository accountOpeningBusinessTypeInfoRepository;
	
	@Autowired
    private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;
	
	public AccountOpeningBusinessTypeInfo createAccountOpeningBusinessTypeInfo(AccountOpeningBusinessTypeInfo accountOpeningBusinessTypeInfo) {
        return accountOpeningBusinessTypeInfoRepository.save(accountOpeningBusinessTypeInfo);
    }
	
	public Optional < AccountOpeningBusinessTypeInfo > getAccountOpeningBusinessTypeInfoId(Long accountOpeningBusinessTypeInfoId)
		    throws ResourceNotFoundException {
		        return accountOpeningBusinessTypeInfoRepository.findById(accountOpeningBusinessTypeInfoId);
		    }
	
	public  AccountOpeningBusinessTypeInfo updateAccountOpeningBusinessTypeInfo(Long accountOpeningBusinessTypeInfoId,
			AccountOpeningBusinessTypeInfo accountOpeningBusinessTypeInfo) throws ResourceNotFoundException {
		AccountOpeningBusinessTypeInfo accountOpeningBusinessTypeInfo1 = accountOpeningBusinessTypeInfoRepository.findById(accountOpeningBusinessTypeInfoId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningBusinessTypeInfo not found for this id :: " + accountOpeningBusinessTypeInfoId));
		 	
			long businessinfoid=accountOpeningBusinessTypeInfo.getAccountOpeningBusinessInfo().getAccountOpeningBusinessInfoId();
			AccountOpeningBusinessInfo accountOpeningBusinessInfo=accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
			accountOpeningBusinessTypeInfo1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			
			accountOpeningBusinessTypeInfo1.setAddressLineOne(accountOpeningBusinessTypeInfo.getAddressLineOne());
			accountOpeningBusinessTypeInfo1.setAddressLineTwo(accountOpeningBusinessTypeInfo.getAddressLineTwo());
			accountOpeningBusinessTypeInfo1.setCityTab(accountOpeningBusinessTypeInfo.getCityTab());
			accountOpeningBusinessTypeInfo1.setCountryTab(accountOpeningBusinessTypeInfo.getCountryTab());
			accountOpeningBusinessTypeInfo1.setNameOnLicense(accountOpeningBusinessTypeInfo.getNameOnLicense());
			accountOpeningBusinessTypeInfo1.setOwnerName(accountOpeningBusinessTypeInfo.getOwnerName());
			accountOpeningBusinessTypeInfo1.setTradingName(accountOpeningBusinessTypeInfo.getTradingName());
			accountOpeningBusinessTypeInfo1.setPremisesNumber(accountOpeningBusinessTypeInfo.getPremisesNumber());
			accountOpeningBusinessTypeInfo1.setPostCode(accountOpeningBusinessTypeInfo.getPostCode());
			accountOpeningBusinessTypeInfo1.setChangeofOwner(accountOpeningBusinessTypeInfo.getChangeofOwner());
			accountOpeningBusinessTypeInfo1.setNorthernland(accountOpeningBusinessTypeInfo.getNorthernland());
			accountOpeningBusinessTypeInfo1.setStateTab(accountOpeningBusinessTypeInfo.getStateTab());
			
			


			
		        final AccountOpeningBusinessTypeInfo updatedAccountOpeningBusinessTypeInfo = accountOpeningBusinessTypeInfoRepository.save(accountOpeningBusinessTypeInfo1);
		        return updatedAccountOpeningBusinessTypeInfo;
		    }	

}
