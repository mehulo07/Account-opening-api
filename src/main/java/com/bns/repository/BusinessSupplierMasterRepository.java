/**
 * 
 */
package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessSupplierMaster;
import com.bns.model.BusinessTypeMaster;


/**
 * @author Hussain 
 *
 */

@Repository
public interface BusinessSupplierMasterRepository extends JpaRepository <BusinessSupplierMaster, Long > {
	
	@Query("from BusinessSupplierMaster a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessSupplierMaster> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);


}
