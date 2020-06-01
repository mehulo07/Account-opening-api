package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.BusinessInfo;
import com.bns.model.LicenceInformationDetailsOne;
import com.bns.model.LicenceInformationDetailsTwo;
import com.bns.repository.BusinessInfoRepository;

import com.bns.repository.LicenceInformationDetailsTwoRepository;

@Service
public class LicenceInformationDetailsTwoService {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private LicenceInformationDetailsTwoRepository licenceInformationDetailsTwoRepository;

	public LicenceInformationDetailsTwo createLicenceInformationDetailsTwo(
			LicenceInformationDetailsTwo licenceInformationDetailsTwo) {
		return licenceInformationDetailsTwoRepository.save(licenceInformationDetailsTwo);
	}

	public Optional<LicenceInformationDetailsTwo> getLicenceInformationDetailsTwoId(Long licenceInformationDetailsTwoId)
			throws ResourceNotFoundException {
		return licenceInformationDetailsTwoRepository.findById(licenceInformationDetailsTwoId);
	}

	public LicenceInformationDetailsTwo updateLicenceInformationDetailsTwo(Long licenceInformationDetailsTwoId,
			LicenceInformationDetailsTwo licenceInformationDetailsTwo) throws ResourceNotFoundException {
		LicenceInformationDetailsTwo licenceInformationDetailsTwo1 = licenceInformationDetailsTwoRepository
				.findById(licenceInformationDetailsTwoId).orElseThrow(() -> new ResourceNotFoundException(
						"licenceInformationDetailsTwoId not found for this id :: " + licenceInformationDetailsTwoId));

		long businessinfoid = licenceInformationDetailsTwo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		licenceInformationDetailsTwo1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		licenceInformationDetailsTwo1
				.setGdpCounrtyLicenseIssuing(licenceInformationDetailsTwo.getGdpCounrtyLicenseIssuing());
		licenceInformationDetailsTwo1.setGdpLicenseExpiryDate(licenceInformationDetailsTwo.getGdpLicenseExpiryDate());
		licenceInformationDetailsTwo1
				.setGdpLicenseReleasingDate(licenceInformationDetailsTwo.getGdpLicenseReleasingDate());
		licenceInformationDetailsTwo1
				.setGdpNameofIssuingAuthority(licenceInformationDetailsTwo.getGdpNameofIssuingAuthority());
		licenceInformationDetailsTwo1.setGdpNo(licenceInformationDetailsTwo.getGdpNo());

		licenceInformationDetailsTwo1
				.setGmpCounrtyLicenseIssuing(licenceInformationDetailsTwo.getGmpCounrtyLicenseIssuing());
		licenceInformationDetailsTwo1.setGmpLicenseExpiryDate(licenceInformationDetailsTwo.getGmpLicenseExpiryDate());
		licenceInformationDetailsTwo1
				.setGmpLicenseReleasingDate(licenceInformationDetailsTwo.getGmpLicenseReleasingDate());
		licenceInformationDetailsTwo1
				.setGmpNameofIssuingAuthority(licenceInformationDetailsTwo.getGmpNameofIssuingAuthority());
		licenceInformationDetailsTwo1.setGmpNo(licenceInformationDetailsTwo.getGmpNo());

		licenceInformationDetailsTwo1
				.setMsCounrtyLicenseIssuing(licenceInformationDetailsTwo.getMsCounrtyLicenseIssuing());
		licenceInformationDetailsTwo1.setMsLicenseExpiryDate(licenceInformationDetailsTwo.getMsLicenseExpiryDate());
		licenceInformationDetailsTwo1
				.setMsLicenseReleasingDate(licenceInformationDetailsTwo.getMsLicenseReleasingDate());
		licenceInformationDetailsTwo1
				.setMsNameofIssuingAuthority(licenceInformationDetailsTwo.getMsNameofIssuingAuthority());
		licenceInformationDetailsTwo1.setMsNo(licenceInformationDetailsTwo.getMsNo());

		final LicenceInformationDetailsTwo updatedLicenceInformationDetailsTwo = licenceInformationDetailsTwoRepository
				.save(licenceInformationDetailsTwo1);
		return updatedLicenceInformationDetailsTwo;
	}

}
