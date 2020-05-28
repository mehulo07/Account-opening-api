package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bns.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{

}
