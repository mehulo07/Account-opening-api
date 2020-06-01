package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.Registration;
import com.bns.model.LinkedAccount;
import com.bns.model.Employee;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.LinkedAccRepository;


@Service
public class LinkedAccService {
	@Autowired
    private LinkedAccRepository accountOpeningLinkedAccRepository;
	@Autowired
    private RegistrationRepository accOpeningRegRepository;
	
	
	public LinkedAccount createAccountOpeningLinkedAcc(LinkedAccount accountOpeningLinkedAcc) {
        return accountOpeningLinkedAccRepository.save(accountOpeningLinkedAcc);
    }
	
	public Optional < LinkedAccount > getAccountOpeningLinkedAccId(Long accountOpeningLinkedAccId)
		    throws ResourceNotFoundException {
		        return accountOpeningLinkedAccRepository.findById(accountOpeningLinkedAccId);
		    }
	
	
	 public LinkedAccount updateAccountOpeningLinkedAcc(Long accountOpeningLinkedAccId,
			 LinkedAccount accountOpeningLinkedAcc) throws ResourceNotFoundException {
		 LinkedAccount accountOpeningLinkedAcc1 = accountOpeningLinkedAccRepository.findById(accountOpeningLinkedAccId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningLinkedAccId not found for this id :: " + accountOpeningLinkedAccId));
		 int reg = accountOpeningLinkedAcc.getAccOpeningReg().getAccountOpeningRegInfoId();

			Registration accOpeningReg = accOpeningRegRepository.findById(reg).get();

			accountOpeningLinkedAcc1.setAccOpeningReg(accOpeningReg);
			
			accountOpeningLinkedAcc1.setWebOrdering(accountOpeningLinkedAcc.getWebOrdering());
			accountOpeningLinkedAcc1.setTenderOrdering(accountOpeningLinkedAcc.getTenderOrdering());
			accountOpeningLinkedAcc1.setSpecialsOrdering(accountOpeningLinkedAcc.getSpecialsOrdering());
			accountOpeningLinkedAcc1.setOldAccountNumber(accountOpeningLinkedAcc.getOldAccountNumber());
			accountOpeningLinkedAcc1.setNewlinkedAccounts(accountOpeningLinkedAcc.getNewlinkedAccounts());
			accountOpeningLinkedAcc1.setAcccomments(accountOpeningLinkedAcc.getAcccomments());
			
			
		        final LinkedAccount updatedAccountOpeningLinkedAcc = accountOpeningLinkedAccRepository.save(accountOpeningLinkedAcc1);
		        return updatedAccountOpeningLinkedAcc;
		    }

}
