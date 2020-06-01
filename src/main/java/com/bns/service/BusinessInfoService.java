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
import com.bns.model.Registration;
import com.bns.model.BusinessInfo;
import com.bns.model.LinkedAccount;
import com.bns.model.BusinessTypeMaster;
import com.bns.model.CompanyTypeMaster;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessTypeMasterRepository;
import com.bns.repository.CompanyTypeMasterRepository;

@Service
public class BusinessInfoService {
	
	@Autowired
    private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	
	@Autowired
    private RegistrationRepository accOpeningRegRepository;
	
	@Autowired
    private BusinessTypeMasterRepository businessTypeRepository;
	@Autowired
    private CompanyTypeMasterRepository companyTypeRepository;
	
	
	
	public BusinessInfo createAccountOpeningBusinessInfoc(BusinessInfo accountOpeningBusinessInfo) {
        return accountOpeningBusinessInfoRepository.save(accountOpeningBusinessInfo);
    }
	
	public Optional < BusinessInfo > getAccountOpeningBusinessInfoId(Long accountOpeningBusinessInfoId)
		    throws ResourceNotFoundException {
		        return accountOpeningBusinessInfoRepository.findById(accountOpeningBusinessInfoId);
		    }
	
	public BusinessInfo updateAccountOpeningBusinessInfo(Long accountOpeningBusinessInfoId,
			BusinessInfo accountOpeningBusinessInfo) throws ResourceNotFoundException {
		BusinessInfo accountOpeningBusinessInfo1 = accountOpeningBusinessInfoRepository.findById(accountOpeningBusinessInfoId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningBusinessInfoID not found for this id :: " + accountOpeningBusinessInfoId));
		 	int reg = accountOpeningBusinessInfo.getAccOpeningReg().getAccountOpeningRegInfoId();
			Registration accOpeningReg = accOpeningRegRepository.findById(reg).get();
			accountOpeningBusinessInfo1.setAccOpeningReg(accOpeningReg);
			
			long businessTypeid=accountOpeningBusinessInfo.getBusinessType().getBusinessTypeId();
			BusinessTypeMaster businessType=businessTypeRepository.findById(businessTypeid).get();
			accountOpeningBusinessInfo1.setBusinessType(businessType);
			
			long companyid=accountOpeningBusinessInfo.getCompanyType().getCompanyId();
			CompanyTypeMaster companyType=companyTypeRepository.findById(companyid).get();
			accountOpeningBusinessInfo1.setCompanyType(companyType);
			
			accountOpeningBusinessInfo1.setCompanyRegisteredAddress(accountOpeningBusinessInfo.getCompanyRegisteredAddress());
			accountOpeningBusinessInfo1.setCompanyRegistrationNumber(accountOpeningBusinessInfo.getCompanyRegistrationNumber());
			accountOpeningBusinessInfo1.setCompanyRegName(accountOpeningBusinessInfo.getCompanyRegName());
			
			accountOpeningBusinessInfo1.setVatNumber(accountOpeningBusinessInfo.getVatNumber());
			accountOpeningBusinessInfo1.setOtherCompanyStatus(accountOpeningBusinessInfo.getOtherCompanyStatus());
			accountOpeningBusinessInfo1.setOtherBusinessType(accountOpeningBusinessInfo.getOtherBusinessType());
			accountOpeningBusinessInfo1.setDateofBusinessCommenced(accountOpeningBusinessInfo.getDateofBusinessCommenced());

			
			
		        final BusinessInfo updatedAccountOpeningBusinessInfo = accountOpeningBusinessInfoRepository.save(accountOpeningBusinessInfo1);
		        return updatedAccountOpeningBusinessInfo;
		    }
	
	


}
