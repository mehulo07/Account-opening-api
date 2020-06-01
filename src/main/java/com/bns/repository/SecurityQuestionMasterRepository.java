package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bns.model.SecurityQuestionMaster;

@Repository
public interface SecurityQuestionMasterRepository extends JpaRepository <SecurityQuestionMaster, Long >{

}
