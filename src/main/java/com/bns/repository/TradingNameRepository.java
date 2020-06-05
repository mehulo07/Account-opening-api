package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bns.model.TradingName;

@Repository
public interface TradingNameRepository extends JpaRepository<TradingName, String> {

	@Query(value="select a.* , b.* from  cust_ord_tab a , cust_ord_tab b where a.CUSTOMER_ID=:custId AND  b.CUSTOMER_NO=:custId AND ADDRESS_ID ='01'",nativeQuery = true)
	public TradingName getTradingInfoByCustId(String custId);
	
}
