package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessTypeMaster;



@Repository
public interface BusinessTypeMasterRepository extends JpaRepository <BusinessTypeMaster, Long > {
	
	
	
	@Query("from BusinessTypeMaster a join a.companyType c where c.companyId=:companyTypeId")
    public List<BusinessTypeMaster> findByCompanyID(@Param("companyTypeId")Long companyTypeId);


}
