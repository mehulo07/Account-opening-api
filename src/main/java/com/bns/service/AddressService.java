package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccountAddress;
import com.bns.model.BusinessInfo;
import com.bns.repository.AddressRepository;
import com.bns.repository.BusinessInfoRepository;

@Service
public class AddressService {

	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private AddressRepository accountOpeningAddressTabRepository;

	public AccountAddress createAccountOpeningAddressTab(AccountAddress accountOpeningAddressTab) {
		return accountOpeningAddressTabRepository.save(accountOpeningAddressTab);
	}

	public Optional<AccountAddress> getAccountOpeningAddressTabId(Long accountOpeningAddressTabId)
			throws ResourceNotFoundException {
		return accountOpeningAddressTabRepository.findById(accountOpeningAddressTabId);
	}

	public AccountAddress updateAccountOpeningAddressTab(Long accountOpeningAddressTabId,
			AccountAddress accountOpeningAddressTab) throws ResourceNotFoundException {
		AccountAddress accountOpeningAddressTab1 = accountOpeningAddressTabRepository
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

		final AccountAddress updatedAccountOpeningAddressTab = accountOpeningAddressTabRepository
				.save(accountOpeningAddressTab1);
		return updatedAccountOpeningAddressTab;
	}

}
