package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.AccountOpeningTradeReference;

@Repository
public interface AccountOpeningTradeReferenceRepository extends JpaRepository<AccountOpeningTradeReference, Long> {

	@Query("from AccountOpeningTradeReference a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
	public List<AccountOpeningTradeReference> findByBusinessInfoId(@Param("businessinfoId") Long businessinfoId);

}
