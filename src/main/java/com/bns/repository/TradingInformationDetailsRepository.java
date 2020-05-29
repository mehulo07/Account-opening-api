package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.TradingInformationDetails;

@Repository
public interface TradingInformationDetailsRepository extends JpaRepository<TradingInformationDetails, Long> {
	@Query("from TradingInformationDetails a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
	public List<TradingInformationDetails> findByBusinessInfoId(@Param("businessinfoId") Long businessinfoId);
}
