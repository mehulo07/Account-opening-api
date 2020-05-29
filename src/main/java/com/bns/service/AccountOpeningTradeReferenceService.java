package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.AccountOpeningTradeReference;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.AccountOpeningTradeReferenceRepository;

@Service
public class AccountOpeningTradeReferenceService {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private AccountOpeningTradeReferenceRepository accountOpeningTradeReferenceRepository;

	public AccountOpeningTradeReference createAccountOpeningTradeReference(
			AccountOpeningTradeReference accountOpeningTradeReference) {
		return accountOpeningTradeReferenceRepository.save(accountOpeningTradeReference);
	}

	public Optional<AccountOpeningTradeReference> getAccountOpeningTradeReferenceId(Long accountOpeningTradeReferenceId)
			throws ResourceNotFoundException {
		return accountOpeningTradeReferenceRepository.findById(accountOpeningTradeReferenceId);
	}

	public AccountOpeningTradeReference updateAccountOpeningTradeReference(Long accountOpeningTradeReferenceId,
			AccountOpeningTradeReference accountOpeningTradeReference) throws ResourceNotFoundException {
		
		AccountOpeningTradeReference accountOpeningTradeReference1 = accountOpeningTradeReferenceRepository
				.findById(accountOpeningTradeReferenceId).orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningTradeReference not found for this id :: " + accountOpeningTradeReferenceId));

		long businessinfoid = accountOpeningTradeReference.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningTradeReference1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
		accountOpeningTradeReference1.setCompanyName(accountOpeningTradeReference.getCompanyName());
		accountOpeningTradeReference1.setCompanyNameTwo(accountOpeningTradeReference.getCompanyNameTwo());
		accountOpeningTradeReference1.setContactName(accountOpeningTradeReference.getCompanyName());
		accountOpeningTradeReference1.setContactNameTwo(accountOpeningTradeReference.getCompanyNameTwo());
		accountOpeningTradeReference1.setEmailAddress(accountOpeningTradeReference.getEmailAddress());
		accountOpeningTradeReference1.setEmailAddressTwo(accountOpeningTradeReference.getEmailAddressTwo());
		accountOpeningTradeReference1.setTelephoneNumber(accountOpeningTradeReference.getTelephoneNumber());
		accountOpeningTradeReference1.setTelephoneNumberTwo(accountOpeningTradeReference.getTelephoneNumberTwo());

		final AccountOpeningTradeReference updatedAccountOpeningTradeReference = accountOpeningTradeReferenceRepository
				.save(accountOpeningTradeReference1);
		return updatedAccountOpeningTradeReference;
	}
	
	

}
