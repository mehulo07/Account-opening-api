package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.VerificationToken;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	@Query("from VerificationToken a join a.accOpeningReg c where c.accountOpeningRegInfoId=:accRegId")
	public VerificationToken findByaccRegId(@Param("accRegId") Integer accRegId);
}
