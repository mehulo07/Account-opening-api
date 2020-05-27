package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.AccountOpeningSecurityQue;


@Repository
public interface AccountOpeningSecurityQueRepository extends JpaRepository <AccountOpeningSecurityQue, Long >  {

}
