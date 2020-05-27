package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccOpeningReg;
import com.bns.model.AccountOpeningLinkedAcc;
import com.bns.model.Employee;
import com.bns.repository.AccOpeningRegRepository;
import com.bns.repository.AccountOpeningLinkedAccRepository;


@Service
public class AccountOpeningLinkedAccService {
	@Autowired
    private AccountOpeningLinkedAccRepository accountOpeningLinkedAccRepository;
	@Autowired
    private AccOpeningRegRepository accOpeningRegRepository;
	
	
	public AccountOpeningLinkedAcc createAccountOpeningLinkedAcc(AccountOpeningLinkedAcc accountOpeningLinkedAcc) {
        return accountOpeningLinkedAccRepository.save(accountOpeningLinkedAcc);
    }
	
	public Optional < AccountOpeningLinkedAcc > getAccountOpeningLinkedAccId(Long accountOpeningLinkedAccId)
		    throws ResourceNotFoundException {
		        return accountOpeningLinkedAccRepository.findById(accountOpeningLinkedAccId);
		    }
	
	
	 public AccountOpeningLinkedAcc updateAccountOpeningLinkedAcc(Long accountOpeningLinkedAccId,
			 AccountOpeningLinkedAcc accountOpeningLinkedAcc) throws ResourceNotFoundException {
		 AccountOpeningLinkedAcc accountOpeningLinkedAcc1 = accountOpeningLinkedAccRepository.findById(accountOpeningLinkedAccId)
		        		.orElseThrow(() -> new ResourceNotFoundException("AccountOpeningLinkedAccId not found for this id :: " + accountOpeningLinkedAccId));
		 int reg = accountOpeningLinkedAcc.getAccOpeningReg().getAccountOpeningRegInfoId();

			AccOpeningReg accOpeningReg = accOpeningRegRepository.findById(reg).get();

			accountOpeningLinkedAcc1.setAccOpeningReg(accOpeningReg);
			
			accountOpeningLinkedAcc1.setWebOrdering(accountOpeningLinkedAcc.getWebOrdering());
			accountOpeningLinkedAcc1.setTenderOrdering(accountOpeningLinkedAcc.getTenderOrdering());
			accountOpeningLinkedAcc1.setSpecialsOrdering(accountOpeningLinkedAcc.getSpecialsOrdering());
			accountOpeningLinkedAcc1.setOldAccountNumber(accountOpeningLinkedAcc.getOldAccountNumber());
			accountOpeningLinkedAcc1.setNewlinkedAccounts(accountOpeningLinkedAcc.getNewlinkedAccounts());
			accountOpeningLinkedAcc1.setAcccomments(accountOpeningLinkedAcc.getAcccomments());
			
			
		        final AccountOpeningLinkedAcc updatedAccountOpeningLinkedAcc = accountOpeningLinkedAccRepository.save(accountOpeningLinkedAcc1);
		        return updatedAccountOpeningLinkedAcc;
		    }

}
