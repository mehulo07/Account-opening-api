package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;

import com.bns.model.AccountOpeningBusinessInfo;
import com.bns.model.LicenceInformationDetailsOne;
import com.bns.repository.AccountOpeningBusinessInfoRepository;
import com.bns.repository.LicenceInformationDetailsOneRepository;

@Service
public class LicenceInformationDetailsOneService {
	@Autowired
	private AccountOpeningBusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private LicenceInformationDetailsOneRepository licenceInformationDetailsOneRepository;

	public LicenceInformationDetailsOne createLicenceInformationDetailsOne(
			LicenceInformationDetailsOne licenceInformationDetailsOne) {
		return licenceInformationDetailsOneRepository.save(licenceInformationDetailsOne);
	}

	public Optional<LicenceInformationDetailsOne> getLicenceInformationDetailsOneId(Long licenceInformationDetailsOneId)
			throws ResourceNotFoundException {
		return licenceInformationDetailsOneRepository.findById(licenceInformationDetailsOneId);
	}

	public LicenceInformationDetailsOne updateLicenceInformationDetailsOne(Long licenceInformationDetailsOneId,
			LicenceInformationDetailsOne licenceInformationDetailsOne) throws ResourceNotFoundException {
		LicenceInformationDetailsOne licenceInformationDetailsOne1 = licenceInformationDetailsOneRepository
				.findById(licenceInformationDetailsOneId).orElseThrow(() -> new ResourceNotFoundException(
						"licenceInformationDetailsOne1 not found for this id :: " + licenceInformationDetailsOneId));

		long businessinfoid = licenceInformationDetailsOne.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		AccountOpeningBusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		licenceInformationDetailsOne1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		licenceInformationDetailsOne1
				.setCdsCounrtyLicenseIssuing(licenceInformationDetailsOne.getCdsCounrtyLicenseIssuing());
		licenceInformationDetailsOne1.setCdsLicenseExpiryDate(licenceInformationDetailsOne.getCdsLicenseExpiryDate());
		licenceInformationDetailsOne1
				.setCdsLicenseReleasingDate(licenceInformationDetailsOne.getCdsLicenseReleasingDate());
		licenceInformationDetailsOne1
				.setCdsNameofIssuingAuthority(licenceInformationDetailsOne.getCdsNameofIssuingAuthority());
		licenceInformationDetailsOne1.setCdsNo(licenceInformationDetailsOne.getCdsNo());
		licenceInformationDetailsOne1
				.setMaCounrtyLicenseIssuing(licenceInformationDetailsOne.getMaCounrtyLicenseIssuing());
		licenceInformationDetailsOne1.setMaLicenseExpiryDate(licenceInformationDetailsOne.getMaLicenseExpiryDate());
		licenceInformationDetailsOne1
				.setMaLicenseReleasingDate(licenceInformationDetailsOne.getMaLicenseReleasingDate());
		licenceInformationDetailsOne1
				.setMaNameofIssuingAuthority(licenceInformationDetailsOne.getMaNameofIssuingAuthority());
		licenceInformationDetailsOne1.setMaNo(licenceInformationDetailsOne.getMaNo());
		licenceInformationDetailsOne1
				.setWdaCounrtyLicenseIssuing(licenceInformationDetailsOne.getWdaCounrtyLicenseIssuing());
		licenceInformationDetailsOne1.setWdaLicenseExpiryDate(licenceInformationDetailsOne.getMaLicenseExpiryDate());
		licenceInformationDetailsOne1
				.setWdaLicenseReleasingDate(licenceInformationDetailsOne.getWdaLicenseReleasingDate());
		licenceInformationDetailsOne1
				.setWdaNameofIssuingAuthority(licenceInformationDetailsOne.getWdaNameofIssuingAuthority());
		licenceInformationDetailsOne1.setWdaNo(licenceInformationDetailsOne.getWdaNo());

		final LicenceInformationDetailsOne updatedLicenceInformationDetailsOne = licenceInformationDetailsOneRepository
				.save(licenceInformationDetailsOne1);
		return updatedLicenceInformationDetailsOne;
	}
}
