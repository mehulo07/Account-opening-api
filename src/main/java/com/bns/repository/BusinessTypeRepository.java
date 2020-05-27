package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessType;



@Repository
public interface BusinessTypeRepository extends JpaRepository <BusinessType, Long > {
	
	
	
	@Query("from BusinessType a join a.companyType c where c.companyId=:companyTypeId")
    public List<BusinessType> findByCompanyID(@Param("companyTypeId")Long companyTypeId);


}
