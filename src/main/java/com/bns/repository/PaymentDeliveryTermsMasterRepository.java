package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.PaymentDeliveryTermsMaster;

@Repository
public interface PaymentDeliveryTermsMasterRepository extends JpaRepository<PaymentDeliveryTermsMaster, Long> {

}
