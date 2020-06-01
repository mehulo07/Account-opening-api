package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.TradeReference;

@Repository
public interface TradeReferenceRepository extends JpaRepository<TradeReference, Long> {

	@Query("from AccountOpeningTradeReference a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
	public List<TradeReference> findByBusinessInfoId(@Param("businessinfoId") Long businessinfoId);

}
