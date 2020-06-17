package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.TradingInformationSubOrder;

@Repository
public interface TradingInformationSubOrderRepository   extends JpaRepository<TradingInformationSubOrder, Long>{

}
