package com.bns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.Registration;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
	

	@Query(value="from  Registration where regEmailAddress=:emailAdd")
	public List<Registration>getRegistrationByemail(@Param("emailAdd")String emailAdd);
	
}
