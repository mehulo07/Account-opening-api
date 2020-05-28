package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.AccountOpeningBusinessTypeInfo;

@Repository
public interface AccountOpeningBusinessTypeInfoRepository extends JpaRepository<AccountOpeningBusinessTypeInfo, Long>{
	
	@Query("from AccountOpeningBusinessTypeInfo a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<AccountOpeningBusinessTypeInfo> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);

}
