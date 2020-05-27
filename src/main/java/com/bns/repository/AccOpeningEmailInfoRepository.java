package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.AccOpeningEmailInfo;

@Repository
public interface AccOpeningEmailInfoRepository extends JpaRepository<com.bns.model.AccOpeningEmailInfo,Long> {

		@Query(value = "FROM Account_Opening_Email_Info g where g.ACCOUNT_OPENING_REG_INFO_ID = :ReferanceId" , nativeQuery = true)
		AccOpeningEmailInfo findAllByReferanceId(@Param("ReferanceId") Long ReferanceId);

	
}
