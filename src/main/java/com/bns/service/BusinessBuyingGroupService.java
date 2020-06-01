package com.bns.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.BusinessBuyingGroupMaster;

import com.bns.repository.BusinessBuyingGroupRepository;


@Service
public class BusinessBuyingGroupService {

	@Autowired
    private BusinessBuyingGroupRepository businessBuyingGroupRepository;
	
	
	
	public BusinessBuyingGroupMaster createBusinessBuyingGroup(BusinessBuyingGroupMaster businessBuyingGroup) {
        return businessBuyingGroupRepository.save(businessBuyingGroup);
    }
	
	public Optional < BusinessBuyingGroupMaster > getBusinessBuyingGroupId(Long businessBuyingGroupId)
		    throws ResourceNotFoundException {
		        return businessBuyingGroupRepository.findById(businessBuyingGroupId);
		    }
	
}
