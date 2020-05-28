package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.AccountOpeningTradingInfo;

@Repository
public interface AccountOpeningTradingInfoRepository extends JpaRepository<AccountOpeningTradingInfo, Long> {
	
	@Query("from AccountOpeningTradingInfo a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<AccountOpeningTradingInfo> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);
}
