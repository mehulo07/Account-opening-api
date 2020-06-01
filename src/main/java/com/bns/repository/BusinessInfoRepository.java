package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bns.model.BusinessInfo;



@Repository
public interface BusinessInfoRepository extends JpaRepository<BusinessInfo, Long> {
	
	@Query("from AccountOpeningBusinessInfo a join a.accOpeningReg c where c.accountOpeningRegInfoId=:accRegId")
    public List<BusinessInfo> findByaccRegId(@Param("accRegId")Long accRegId);


}
