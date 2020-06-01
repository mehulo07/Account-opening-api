package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.SecurityQue;


@Repository
public interface SecurityQueRepository extends JpaRepository <SecurityQue, Long >  {

}
