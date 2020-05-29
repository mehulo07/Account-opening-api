package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.PaymentDeliveryTerms;

@Repository
public interface PaymentDeliveryTermsRepository extends JpaRepository<PaymentDeliveryTerms, Long> {

}
