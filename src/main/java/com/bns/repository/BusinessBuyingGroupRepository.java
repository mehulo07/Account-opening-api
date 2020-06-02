package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessBuyingGroupMaster;



@Repository
public interface BusinessBuyingGroupRepository extends JpaRepository <BusinessBuyingGroupMaster, Long >{

	@Query("from BusinessBuyingGroupMaster a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessBuyingGroupMaster> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);
}
