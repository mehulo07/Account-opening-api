package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.LicenceInformationDetailsOne;

@Repository
public interface LicenceInformationDetailsOneRepository extends JpaRepository<LicenceInformationDetailsOne, Long> {
	@Query("from LicenceInformationDetailsOne a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
	public List<LicenceInformationDetailsOne> findByBusinessInfoId(@Param("businessinfoId") Long businessinfoId);

}
