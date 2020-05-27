package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.CompanyType;



@Repository
public interface CompanyTypeRepository extends JpaRepository <CompanyType, Long > {

}
