package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.bns.model.SecurityQuestion;

@Repository
public interface SecurityQuestionRepository extends JpaRepository <SecurityQuestion, Long >{

}
