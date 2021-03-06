package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessInformationWorkingHours;

@Repository
public interface BusinessInformationWorkingHoursRepository
		extends JpaRepository<BusinessInformationWorkingHours, Long> {
	@Query("from BusinessInformationWorkingHours a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
	public List<BusinessInformationWorkingHours> findByBusinessInfoId(@Param("businessinfoId") Long businessinfoId);
}
