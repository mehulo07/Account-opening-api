package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.CustomerBankInfo;

@Repository
public interface CustomerBankInfoRepository extends JpaRepository<CustomerBankInfo, Long> {

}
