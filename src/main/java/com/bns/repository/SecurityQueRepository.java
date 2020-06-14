package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.SecurityQue;


@Repository
public interface SecurityQueRepository extends JpaRepository <SecurityQue, Long >  {
	

	@Query("from SecurityQue a join a.accOpeningReg c where c.accountOpeningRegInfoId=:accRegId")
    public List<SecurityQue> findByaccRegId(@Param("accRegId")Long accRegId);


}
