package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.AccountOpeningAddressTab;



@Repository
public interface AccountOpeningAddressTabRepository extends JpaRepository<AccountOpeningAddressTab, Long> {
	
	@Query("from AccountOpeningAddressTab a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<AccountOpeningAddressTab> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);

}
