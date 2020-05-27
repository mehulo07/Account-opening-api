package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.AccOpeningReg;

@Repository
public interface AccOpeningRegRepository extends JpaRepository<AccOpeningReg, Integer> {

}
