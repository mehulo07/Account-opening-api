package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.BusinessInfo;
import com.bns.model.TradeReference;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.TradeReferenceRepository;

@Service
public class TradeReferenceService {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private TradeReferenceRepository accountOpeningTradeReferenceRepository;

	public TradeReference createAccountOpeningTradeReference(
			TradeReference accountOpeningTradeReference) {
		return accountOpeningTradeReferenceRepository.save(accountOpeningTradeReference);
	}

	public Optional<TradeReference> getAccountOpeningTradeReferenceId(Long accountOpeningTradeReferenceId)
			throws ResourceNotFoundException {
		return accountOpeningTradeReferenceRepository.findById(accountOpeningTradeReferenceId);
	}

	public TradeReference updateAccountOpeningTradeReference(Long accountOpeningTradeReferenceId,
			TradeReference accountOpeningTradeReference) throws ResourceNotFoundException {
		
		TradeReference accountOpeningTradeReference1 = accountOpeningTradeReferenceRepository
				.findById(accountOpeningTradeReferenceId).orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningTradeReference not found for this id :: " + accountOpeningTradeReferenceId));

		long businessinfoid = accountOpeningTradeReference.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
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

		final TradeReference updatedAccountOpeningTradeReference = accountOpeningTradeReferenceRepository
				.save(accountOpeningTradeReference1);
		return updatedAccountOpeningTradeReference;
	}
	
	

}
