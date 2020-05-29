package com.bns.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccOpeningReg;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.AccountOpeningLinkedAcc;
import com.bns.model.BusinessType;
import com.bns.model.CompanyType;
import com.bns.repository.AccOpeningRegRepository;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.BusinessTypeRepository;
import com.bns.repository.CompanyTypeRepository;

@Service
public class AccountOpeningBusinessInfoService {
	
	@Autowired
    private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;
	
	@Autowired
    private AccOpeningRegRepository accOpeningRegRepository;
	
	@Autowired
    private BusinessTypeRepository businessTypeRepository;
	@Autowired
    private CompanyTypeRepository companyTypeRepository;
	
	
	
	public AccountOpeningBusinessInfo createAccountOpeningBusinessInfoc(AccountOpeningBusinessInfo accountOpeningBusinessInfo) {
        return accountOpeningBusinessInfoRepository.save(accountOpeningBusinessInfo);
    }
	
	public Optional < AccountOpeningBusinessInfo > getAccountOpeningBusinessInfoId(Long accountOpeningBusinessInfoId)
		    throws ResourceNotFoundException {
		        return accountOpeningBusinessInfoRepository.findById(accountOpeningBusinessInfoId);
		    }
	
	public AccountOpeningBusinessInfo updateAccountOpeningBusinessInfo(Long accountOpeningBusinessInfoId,
			AccountOpeningBusinessInfo accountOpeningBusinessInfo) throws ResourceNotFoundException {
		AccountOpeningBusinessInfo accountOpeningBusinessInfo1 = accountOpeningBusinessInfoRepository.findById(accountOpeningBusinessInfoId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningBusinessInfoID not found for this id :: " + accountOpeningBusinessInfoId));
		 	int reg = accountOpeningBusinessInfo.getAccOpeningReg().getAccountOpeningRegInfoId();
			AccOpeningReg accOpeningReg = accOpeningRegRepository.findById(reg).get();
			accountOpeningBusinessInfo1.setAccOpeningReg(accOpeningReg);
			
			long businessTypeid=accountOpeningBusinessInfo.getBusinessType().getBusinessTypeId();
			BusinessType businessType=businessTypeRepository.findById(businessTypeid).get();
			accountOpeningBusinessInfo1.setBusinessType(businessType);
			
			long companyid=accountOpeningBusinessInfo.getCompanyType().getCompanyId();
			CompanyType companyType=companyTypeRepository.findById(companyid).get();
			accountOpeningBusinessInfo1.setCompanyType(companyType);
			
			accountOpeningBusinessInfo1.setCompanyRegisteredAddress(accountOpeningBusinessInfo.getCompanyRegisteredAddress());
			accountOpeningBusinessInfo1.setCompanyRegistrationNumber(accountOpeningBusinessInfo.getCompanyRegistrationNumber());
			accountOpeningBusinessInfo1.setCompanyRegName(accountOpeningBusinessInfo.getCompanyRegName());
			
			accountOpeningBusinessInfo1.setVatNumber(accountOpeningBusinessInfo.getVatNumber());
			accountOpeningBusinessInfo1.setOtherCompanyStatus(accountOpeningBusinessInfo.getOtherCompanyStatus());
			accountOpeningBusinessInfo1.setOtherBusinessType(accountOpeningBusinessInfo.getOtherBusinessType());
			accountOpeningBusinessInfo1.setDateofBusinessCommenced(accountOpeningBusinessInfo.getDateofBusinessCommenced());

			
			
		        final AccountOpeningBusinessInfo updatedAccountOpeningBusinessInfo = accountOpeningBusinessInfoRepository.save(accountOpeningBusinessInfo1);
		        return updatedAccountOpeningBusinessInfo;
		    }
	
	


}
