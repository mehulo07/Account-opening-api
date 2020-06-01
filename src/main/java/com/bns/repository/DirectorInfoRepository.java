package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.DirectorInfo;

@Repository
public interface DirectorInfoRepository  extends JpaRepository<DirectorInfo, Long>{
	
	@Query("from AccountOpeningDirectorInfo a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<DirectorInfo> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);
}
