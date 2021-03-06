package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.BusinessTypeInfo;

@Repository
public interface BusinessTypeInfoRepository extends JpaRepository<BusinessTypeInfo, Long>{
	
	@Query("from BusinessTypeInfo a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<BusinessTypeInfo> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);

}
