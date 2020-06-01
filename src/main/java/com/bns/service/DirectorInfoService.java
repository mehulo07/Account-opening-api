package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountAddressTab;
import com.bns.model.BusinessInfo;
import com.bns.model.DirectorInfo;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.DirectorInfoRepository;

@Service
public class DirectorInfoService {
	@Autowired
    private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private DirectorInfoRepository accountOpeningDirectorInfoRepository;
	
	public DirectorInfo createAccountOpeningDirectorInfo(DirectorInfo accountOpeningDirectorInfo) {
        return accountOpeningDirectorInfoRepository.save(accountOpeningDirectorInfo);
    }
	
	public Optional < DirectorInfo > getAccountOpeningDirectorInfoId(Long accountOpeningDirectorInfoId)
		    throws ResourceNotFoundException {
		        return accountOpeningDirectorInfoRepository.findById(accountOpeningDirectorInfoId);
		    }
	
	public DirectorInfo updateAccountOpeningDirectorInfo(Long accountOpeningDirectorInfoId,
			DirectorInfo accountOpeningDirectorInfo) throws ResourceNotFoundException {
		DirectorInfo accountOpeningDirectorInfo1 = accountOpeningDirectorInfoRepository.findById(accountOpeningDirectorInfoId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningDirectorInfo not found for this id :: " + accountOpeningDirectorInfoId));
		 	
			long businessinfoid=accountOpeningDirectorInfo.getAccountOpeningBusinessInfo().getAccountOpeningBusinessInfoId();
			BusinessInfo accountOpeningBusinessInfo=accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
			accountOpeningDirectorInfo1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			
			accountOpeningDirectorInfo1.setFullName(accountOpeningDirectorInfo.getFullName());
			accountOpeningDirectorInfo1.setFullAddress(accountOpeningDirectorInfo.getFullAddress());
			

			
		        final DirectorInfo updatedAccountOpeningDirectorInfo = accountOpeningDirectorInfoRepository.save(accountOpeningDirectorInfo1);
		        return updatedAccountOpeningDirectorInfo;
		    }
	

}
