package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.AccountOpeningBusinessInfo;



@Repository
public interface AccountOpeningBusinessInfoRepository extends JpaRepository<AccountOpeningBusinessInfo, Long> {
	
	@Query("from AccountOpeningBusinessInfo a join a.accOpeningReg c where c.accountOpeningRegInfoId=:accRegId")
    public List<AccountOpeningBusinessInfo> findByaccRegId(@Param("accRegId")Long accRegId);


}
