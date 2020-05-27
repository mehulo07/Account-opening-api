/**
 * 
 */
package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessSupplier;
import com.bns.model.BusinessType;


/**
 * @author Hussain 
 *
 */

@Repository
public interface BusinessSupplierRepository extends JpaRepository <BusinessSupplier, Long > {
	
	@Query("from BusinessSupplier a join a.businessType c where c.businessTypeId=:businessTypeId")
    public List<BusinessSupplier> findByBusinessTypeID(@Param("businessTypeId")Long businessTypeId);


}
