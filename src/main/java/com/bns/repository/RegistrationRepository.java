package com.bns.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.bns.model.Registration;
import com.bns.model.UserAuthDetail;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
	

	@Query(value="from  Registration where regEmailAddress=:emailAdd")
	public List<Registration>getRegistrationByemail(@Param("emailAdd")String emailAdd);
	
	
	Optional<Registration> findByRegEmailAddress(String userName); 
	
}
