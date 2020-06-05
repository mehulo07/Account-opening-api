package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.EmailInfo;

@Repository
public interface EmailInfoRepository extends JpaRepository<com.bns.model.EmailInfo,Long> {

		@Query(value = "select * from acc_opening_email_info_tab g where g.account_opening_reg_info_id = :ReferanceId",nativeQuery = true)
		EmailInfo findByReferanceId(@Param("ReferanceId") Long ReferanceId);

	
}
