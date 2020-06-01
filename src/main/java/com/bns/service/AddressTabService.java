package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountAddressTab;
import com.bns.model.BusinessInfo;
import com.bns.repository.AddressTabRepository;
import com.bns.repository.BusinessInfoRepository;

@Service
public class AddressTabService {

	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private AddressTabRepository accountOpeningAddressTabRepository;

	public AccountAddressTab createAccountOpeningAddressTab(AccountAddressTab accountOpeningAddressTab) {
		return accountOpeningAddressTabRepository.save(accountOpeningAddressTab);
	}

	public Optional<AccountAddressTab> getAccountOpeningAddressTabId(Long accountOpeningAddressTabId)
			throws ResourceNotFoundException {
		return accountOpeningAddressTabRepository.findById(accountOpeningAddressTabId);
	}

	public AccountAddressTab updateAccountOpeningAddressTab(Long accountOpeningAddressTabId,
			AccountAddressTab accountOpeningAddressTab) throws ResourceNotFoundException {
		AccountAddressTab accountOpeningAddressTab1 = accountOpeningAddressTabRepository
				.findById(accountOpeningAddressTabId).orElseThrow(() -> new ResourceNotFoundException(
						"Account Opening AddressTabIe not found for this id :: " + accountOpeningAddressTabId));

		long businessinfoid = accountOpeningAddressTab.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningAddressTab1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
		accountOpeningAddressTab1.setAddressLineTwo(accountOpeningAddressTab.getAddressLineTwo());
		accountOpeningAddressTab1.setAddressLineOne(accountOpeningAddressTab.getAddressLineOne());
		accountOpeningAddressTab1.setCityTab(accountOpeningAddressTab.getCityTab());
		accountOpeningAddressTab1.setCountryTab(accountOpeningAddressTab.getCountryTab());
		accountOpeningAddressTab1.setCqcName(accountOpeningAddressTab.getCqcName());
		accountOpeningAddressTab1.setPostCode(accountOpeningAddressTab.getPostCode());
		accountOpeningAddressTab1.setStateTab(accountOpeningAddressTab.getStateTab());

		final AccountAddressTab updatedAccountOpeningAddressTab = accountOpeningAddressTabRepository
				.save(accountOpeningAddressTab1);
		return updatedAccountOpeningAddressTab;
	}

}
