package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.TradingInformationSubSupplier;

@Repository
public interface TradingInformationSubSupplierRepository extends JpaRepository<TradingInformationSubSupplier, Long> {

}
