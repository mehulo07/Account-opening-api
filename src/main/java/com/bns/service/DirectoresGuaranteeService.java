package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.DirectoresGuarantee;
import com.bns.repository.DirectoresGuaranteeRepository;

@Service
public class DirectoresGuaranteeService {
	
	@Autowired
	private DirectoresGuaranteeRepository directoresGuaranteeRepository;
	
	public DirectoresGuarantee save(DirectoresGuarantee directoresGuarantee){
		return directoresGuaranteeRepository.save(directoresGuarantee);
	}
	
	public List<DirectoresGuarantee> getAllDirectoreGuarentees(){
		return directoresGuaranteeRepository.findAll();
	}
	
	public DirectoresGuarantee update(Long guaranteeId,DirectoresGuarantee directoresGuarantee) throws ResourceNotFoundException{
		DirectoresGuarantee tempDirectoresGuarantee = directoresGuaranteeRepository.findById(guaranteeId).orElseThrow(() -> new ResourceNotFoundException(
					"Directores Guarantee data not found"+ guaranteeId +"."));
		
		tempDirectoresGuarantee.setGuaranteeId(guaranteeId);
		tempDirectoresGuarantee.setGuarantorName(directoresGuarantee.getGuarantorName());
		tempDirectoresGuarantee.setGuarantorSign(directoresGuarantee.getGuarantorSign());
		tempDirectoresGuarantee.setInsertedOn(directoresGuarantee.getInsertedOn());
		tempDirectoresGuarantee.setWitnessName(directoresGuarantee.getWitnessName());
		tempDirectoresGuarantee.setWitnessSign(directoresGuarantee.getWitnessSign());
		tempDirectoresGuarantee.setWitnessPostcode(directoresGuarantee.getWitnessPostcode());
		tempDirectoresGuarantee.setWitnesscity(directoresGuarantee.getWitnesscity());
		tempDirectoresGuarantee.setWitnessState(directoresGuarantee.getWitnessState());
		tempDirectoresGuarantee.setWitnessCountry(directoresGuarantee.getWitnessCountry());
		
		
		return directoresGuaranteeRepository.save(tempDirectoresGuarantee);
	}
	
	public DirectoresGuarantee findByReferenceIdService(Long guaranteeRefId) {
		return directoresGuaranteeRepository.findByReferenceId(guaranteeRefId);
	}
	
	public DirectoresGuarantee getById(Long guaranteeId) throws ResourceNotFoundException {
		return directoresGuaranteeRepository.findById(guaranteeId).orElseThrow(() ->new ResourceNotFoundException("Directores Guarantee data not found"+ guaranteeId ));
	}
}
