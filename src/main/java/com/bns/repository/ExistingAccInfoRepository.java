package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.ExistingAccInfo;

@Repository
public interface ExistingAccInfoRepository extends JpaRepository<ExistingAccInfo, String> {
	
	@Query(value = "select * from cust_info_address_tab  where CUSTOMER_ID =:customerId and  ADDRESS_ID='01'",nativeQuery = true)
    public ExistingAccInfo findByCustomerId(@Param("customerId")String customerId);
	
}
