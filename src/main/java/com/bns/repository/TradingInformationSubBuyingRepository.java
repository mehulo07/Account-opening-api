package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.TradingInformationSubBuying;


@Repository
public interface TradingInformationSubBuyingRepository  extends JpaRepository<TradingInformationSubBuying, Long> {

}
