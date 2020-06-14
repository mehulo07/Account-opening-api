package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.ApplicationUserDetails;
import com.bns.model.Registration;
import com.bns.model.RegistrationUserDetails;
import com.bns.model.UserAuthDetail;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.UserAuthRepo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Registration> user = registrationRepository.findByRegEmailAddress(username);
		user.orElseThrow(()->new UsernameNotFoundException("User not found"+username));
		return user.map(RegistrationUserDetails::new).get();
	}
	
//	public UserAuthDetail updateEntryId(String username , int regEntryId)throws ResourceNotFoundException {
//		UserAuthDetail userRegAuthDetail = userAuthRepo.findByUserName(username)
//        		.orElseThrow(() -> new ResourceNotFoundException("Not Found:: " + username));
//		final UserAuthDetail userAuthDetailUpdated = userAuthRepo.save(userRegAuthDetail);
//		
//		return userAuthDetailUpdated;
//		
//	}
}