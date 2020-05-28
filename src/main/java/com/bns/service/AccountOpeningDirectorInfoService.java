package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningAddressTab;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.AccountOpeningDirectorInfo;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.AccountOpeningDirectorInfoRepository;

@Service
public class AccountOpeningDirectorInfoService {
	@Autowired
    private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private AccountOpeningDirectorInfoRepository accountOpeningDirectorInfoRepository;
	
	public AccountOpeningDirectorInfo createAccountOpeningDirectorInfo(AccountOpeningDirectorInfo accountOpeningDirectorInfo) {
        return accountOpeningDirectorInfoRepository.save(accountOpeningDirectorInfo);
    }
	
	public Optional < AccountOpeningDirectorInfo > getAccountOpeningDirectorInfoId(Long accountOpeningDirectorInfoId)
		    throws ResourceNotFoundException {
		        return accountOpeningDirectorInfoRepository.findById(accountOpeningDirectorInfoId);
		    }
	
	public AccountOpeningDirectorInfo updateAccountOpeningDirectorInfo(Long accountOpeningDirectorInfoId,
			AccountOpeningDirectorInfo accountOpeningDirectorInfo) throws ResourceNotFoundException {
		AccountOpeningDirectorInfo accountOpeningDirectorInfo1 = accountOpeningDirectorInfoRepository.findById(accountOpeningDirectorInfoId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningDirectorInfo not found for this id :: " + accountOpeningDirectorInfoId));
		 	
			long businessinfoid=accountOpeningDirectorInfo.getAccountOpeningBusinessInfo().getAccountOpeningBusinessInfoId();
			AccountOpeningBusinessInfo accountOpeningBusinessInfo=accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
			accountOpeningDirectorInfo1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			
			accountOpeningDirectorInfo1.setFullName(accountOpeningDirectorInfo.getFullName());
			accountOpeningDirectorInfo1.setFullAddress(accountOpeningDirectorInfo.getFullAddress());
			

			
		        final AccountOpeningDirectorInfo updatedAccountOpeningDirectorInfo = accountOpeningDirectorInfoRepository.save(accountOpeningDirectorInfo1);
		        return updatedAccountOpeningDirectorInfo;
		    }
	

}
