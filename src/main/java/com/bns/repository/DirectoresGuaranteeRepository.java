package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bns.model.DirectoresGuarantee;

@Repository
public interface DirectoresGuaranteeRepository extends JpaRepository<DirectoresGuarantee, Long> {

	@Query(value="select * from account_Opening_Directors_Guarantee where account_Opening_Business_Info_id=:guaranteeId ",nativeQuery = true)
	public DirectoresGuarantee findByReferenceId(Long guaranteeId);
		
}
