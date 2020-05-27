package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.BusinessPmr;

@Repository
public interface BusinessPmrRepository extends JpaRepository <BusinessPmr, Long >{
	
	@Query("from BusinessPmr a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessPmr> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);
}
