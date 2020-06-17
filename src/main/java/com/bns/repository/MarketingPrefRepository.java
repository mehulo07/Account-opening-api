package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.MarketingPref;

@Repository
public interface MarketingPrefRepository extends JpaRepository<MarketingPref, Long>  {
	
	@Query("from MarketingPref a join a.accOpeningReg c where c.accountOpeningRegInfoId=:accRegId")
    public List<MarketingPref> findByaccRegId(@Param("accRegId")Long accRegId);

}
