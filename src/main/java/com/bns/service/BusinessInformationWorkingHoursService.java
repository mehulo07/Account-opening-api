package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.BusinessInfo;
import com.bns.model.BusinessInformationWorkingHours;

import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessInformationWorkingHoursRepository;

@Service
public class BusinessInformationWorkingHoursService {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;
	@Autowired
	private BusinessInformationWorkingHoursRepository businessInformationWorkingHoursRepository;

	public BusinessInformationWorkingHours createBusinessInformationWorkingHours(
			BusinessInformationWorkingHours businessInformationWorkingHours) {
		return businessInformationWorkingHoursRepository.save(businessInformationWorkingHours);
	}

	public Optional<BusinessInformationWorkingHours> getBusinessInformationWorkingHoursId(
			Long businessInformationWorkingHoursId) throws ResourceNotFoundException {
		return businessInformationWorkingHoursRepository.findById(businessInformationWorkingHoursId);
	}

	public BusinessInformationWorkingHours updateBusinessInformationWorkingHours(Long businessInformationWorkingHoursId,
			BusinessInformationWorkingHours businessInformationWorkingHours) throws ResourceNotFoundException {
		BusinessInformationWorkingHours businessInformationWorkingHours1 = businessInformationWorkingHoursRepository
				.findById(businessInformationWorkingHoursId).orElseThrow(
						() -> new ResourceNotFoundException("BusinessInformationWorkingHours not found for this id :: "
								+ businessInformationWorkingHoursId));

		long businessinfoid = businessInformationWorkingHours.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		businessInformationWorkingHours1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		businessInformationWorkingHours1.setMoncloseHours(businessInformationWorkingHours.getMoncloseHours());
		businessInformationWorkingHours1.setTueCloseHours(businessInformationWorkingHours.getTueCloseHours());
		businessInformationWorkingHours1.setWedCloseHours(businessInformationWorkingHours.getWedCloseHours());
		businessInformationWorkingHours1.setThuCloseHours(businessInformationWorkingHours.getThuCloseHours());
		businessInformationWorkingHours1.setFriCloseHours(businessInformationWorkingHours.getFriCloseHours());
		businessInformationWorkingHours1.setSatCloseHours(businessInformationWorkingHours.getSatCloseHours());

		businessInformationWorkingHours1.setMonOpeningHours(businessInformationWorkingHours.getMonOpeningHours());
		businessInformationWorkingHours1.setTueOpeningHours(businessInformationWorkingHours.getTueOpeningHours());
		businessInformationWorkingHours1.setWedOpeningHours(businessInformationWorkingHours.getWedCloseHours());
		businessInformationWorkingHours1.setThuOpeningHours(businessInformationWorkingHours.getThuOpeningHours());
		businessInformationWorkingHours1.setFriOpeningHours(businessInformationWorkingHours.getFriOpeningHours());
		businessInformationWorkingHours1.setSatOpeningHours(businessInformationWorkingHours.getSatOpeningHours());

		businessInformationWorkingHours1.setTermCondition(businessInformationWorkingHours.getTermCondition());
		businessInformationWorkingHours1
				.setWorkingHoursComment(businessInformationWorkingHours.getWorkingHoursComment());

		final BusinessInformationWorkingHours updatedBusinessInformationWorkingHours = businessInformationWorkingHoursRepository
				.save(businessInformationWorkingHours1);
		return updatedBusinessInformationWorkingHours;
	}

}
