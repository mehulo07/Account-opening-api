package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.BusinessOrderSystemMaster;

@Repository
public interface BusinessOrderSystemMasterRepository extends JpaRepository <BusinessOrderSystemMaster, Long >{
	
	@Query("from BusinessOrderSystemMaster a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessOrderSystemMaster> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);

}
