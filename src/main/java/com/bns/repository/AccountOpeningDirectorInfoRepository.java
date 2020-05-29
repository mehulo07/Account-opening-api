package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.AccountOpeningDirectorInfo;

@Repository
public interface AccountOpeningDirectorInfoRepository  extends JpaRepository<AccountOpeningDirectorInfo, Long>{
	
	@Query("from AccountOpeningDirectorInfo a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<AccountOpeningDirectorInfo> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);
}
