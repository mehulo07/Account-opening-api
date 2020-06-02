package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.LinkedAccount;



@Repository
public interface LinkedAccRepository extends JpaRepository<LinkedAccount, Long> {
	
	@Query("from LinkedAccount a join a.accOpeningReg c where c.accountOpeningRegInfoId=:accRegId")
    public List<LinkedAccount> findByaccRegId(@Param("accRegId")Long accRegId);

}
