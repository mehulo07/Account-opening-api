package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.TradingInfo;

@Repository
public interface TradingInfoRepository extends JpaRepository<TradingInfo, Long> {
	
	@Query("from AccountOpeningTradingInfo a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<TradingInfo> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);
}
