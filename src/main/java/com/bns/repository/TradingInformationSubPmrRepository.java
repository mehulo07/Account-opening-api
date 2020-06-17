package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.TradingInformationSubPmr;


@Repository
public interface TradingInformationSubPmrRepository extends JpaRepository<TradingInformationSubPmr, Long> {

}
