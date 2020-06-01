package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.PaymentTermsRequestMaster;

@Repository
public interface PaymentTermsRequestMasterRepository extends JpaRepository<PaymentTermsRequestMaster, Long> {

}
