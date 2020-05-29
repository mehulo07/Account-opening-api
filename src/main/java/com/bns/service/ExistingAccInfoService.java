package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.ExistingAccInfo;
import com.bns.repository.ExistingAccInfoRepository;

@Service
public class ExistingAccInfoService {
	
	@Autowired
	private ExistingAccInfoRepository existingAccInfoRepository;
	
	public ExistingAccInfo getByCustomerId(String customerId) {
		return existingAccInfoRepository.findByCustomerId(customerId);
	}
	
}
