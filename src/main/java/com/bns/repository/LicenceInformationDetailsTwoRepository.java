package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.LicenceInformationDetailsTwo;

@Repository
public interface LicenceInformationDetailsTwoRepository extends JpaRepository<LicenceInformationDetailsTwo, Long> {
	@Query("from LicenceInformationDetailsTwo a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
	public List<LicenceInformationDetailsTwo> findByBusinessInfoId(@Param("businessinfoId") Long businessinfoId);

}
