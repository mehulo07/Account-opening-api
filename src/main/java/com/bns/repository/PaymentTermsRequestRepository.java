package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.PaymentTermsRequest;

@Repository
public interface PaymentTermsRequestRepository extends JpaRepository<PaymentTermsRequest, Long> {

}
