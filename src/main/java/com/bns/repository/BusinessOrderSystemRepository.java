package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.BusinessOrderSystem;

@Repository
public interface BusinessOrderSystemRepository extends JpaRepository <BusinessOrderSystem, Long >{
	
	@Query("from BusinessOrderSystem a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessOrderSystem> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);

}
