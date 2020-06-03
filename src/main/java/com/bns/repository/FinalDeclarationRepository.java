package com.bns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.FinalDeclaration;

@Repository
public interface FinalDeclarationRepository extends JpaRepository<FinalDeclaration, Long> {

	
}
