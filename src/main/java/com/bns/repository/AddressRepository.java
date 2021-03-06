package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.AccountAddress;



@Repository
public interface AddressRepository extends JpaRepository<AccountAddress, Long> {
	
	@Query("from AccountAddress a join a.accountOpeningBusinessInfo c where c.accountOpeningBusinessInfoId=:businessinfoId")
    public List<AccountAddress> findByBusinessInfoId(@Param("businessinfoId")Long businessinfoId);

}
