package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountOpeningAddressTab;
import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.repository.AccountOpeningAddressTabRepository;
import com.bns.repository.AccountOpeningBusinessInfoRepository;

@Service
public class AccountOpeningAddressTabService {

	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private AccountOpeningAddressTabRepository accountOpeningAddressTabRepository;

	public AccountOpeningAddressTab createAccountOpeningAddressTab(AccountOpeningAddressTab accountOpeningAddressTab) {
		return accountOpeningAddressTabRepository.save(accountOpeningAddressTab);
	}

	public Optional<AccountOpeningAddressTab> getAccountOpeningAddressTabId(Long accountOpeningAddressTabId)
			throws ResourceNotFoundException {
		return accountOpeningAddressTabRepository.findById(accountOpeningAddressTabId);
	}

	public AccountOpeningAddressTab updateAccountOpeningAddressTab(Long accountOpeningAddressTabId,
			AccountOpeningAddressTab accountOpeningAddressTab) throws ResourceNotFoundException {
		AccountOpeningAddressTab accountOpeningAddressTab1 = accountOpeningAddressTabRepository
				.findById(accountOpeningAddressTabId).orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening AddressTabIe not found for this id :: " + accountOpeningAddressTabId));

		long businessinfoid = accountOpeningAddressTab.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningAddressTab1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
		accountOpeningAddressTab1.setAddressLineTwo(accountOpeningAddressTab.getAddressLineTwo());
		accountOpeningAddressTab1.setAddressLineOne(accountOpeningAddressTab.getAddressLineOne());
		accountOpeningAddressTab1.setCityTab(accountOpeningAddressTab.getCityTab());
		accountOpeningAddressTab1.setCountryTab(accountOpeningAddressTab.getCountryTab());
		accountOpeningAddressTab1.setCqcName(accountOpeningAddressTab.getCqcName());
		accountOpeningAddressTab1.setPostCode(accountOpeningAddressTab.getPostCode());
		accountOpeningAddressTab1.setStateTab(accountOpeningAddressTab.getStateTab());

		final AccountOpeningAddressTab updatedAccountOpeningAddressTab = accountOpeningAddressTabRepository
				.save(accountOpeningAddressTab1);
		return updatedAccountOpeningAddressTab;
	}

}
