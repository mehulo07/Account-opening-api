package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.AccountOpeningLinkedAcc;



@Repository
public interface AccountOpeningLinkedAccRepository extends JpaRepository<AccountOpeningLinkedAcc, Long> {
	
	@Query("from AccountOpeningLinkedAcc a join a.accOpeningReg c where c.accountOpeningRegInfoId=:accRegId")
    public List<AccountOpeningLinkedAcc> findByaccRegId(@Param("accRegId")Long accRegId);

}
