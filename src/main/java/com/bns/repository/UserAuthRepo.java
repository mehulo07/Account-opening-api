package com.bns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bns.model.UserAuthDetail;

@Repository
public interface UserAuthRepo extends JpaRepository<UserAuthDetail, String> {

	Optional<UserAuthDetail> findByUserName(String userName); 
}
