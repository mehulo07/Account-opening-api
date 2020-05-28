package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bns.model.PaymentTermsRequest;

public interface PaymentTermsRequestRepository extends JpaRepository<PaymentTermsRequest, Long> {

}
