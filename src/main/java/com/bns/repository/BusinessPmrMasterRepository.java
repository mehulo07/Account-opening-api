package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.BusinessPmrMaster;

@Repository
public interface BusinessPmrMasterRepository extends JpaRepository <BusinessPmrMaster, Long >{
	
	@Query("from BusinessPmrMaster a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessPmrMaster> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);
}
