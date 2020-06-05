package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bns.model.DirectoresGuarantee;

@Repository
public interface DirectoresGuaranteeRepository extends JpaRepository<DirectoresGuarantee, Long> {

	@Query(value="select * from acc_opening_director_gur_tab where acc_opening_busi_info_id=:guaranteeId ",nativeQuery = true)
	public DirectoresGuarantee findByReferenceId(Long guaranteeId);
		
}
