package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.CompanyTypeMaster;



@Repository
public interface CompanyTypeMasterRepository extends JpaRepository <CompanyTypeMaster, Long > {

}
