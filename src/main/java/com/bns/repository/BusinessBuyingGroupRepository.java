package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessBuyingGroup;



@Repository
public interface BusinessBuyingGroupRepository extends JpaRepository <BusinessBuyingGroup, Long >{

	
	@Query("from BusinessBuyingGroup a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessBuyingGroup> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);
}
