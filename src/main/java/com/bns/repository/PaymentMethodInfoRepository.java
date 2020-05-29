package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.PaymentMethodInfo;

@Repository
public interface PaymentMethodInfoRepository extends JpaRepository<PaymentMethodInfo, Long> {

}
