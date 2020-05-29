package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.controller.FinalDeclaration;
import com.bns.exception.ResourceNotFoundException;
import com.bns.repository.FinalDeclarationRepository;

@Service
public class FinalDeclarationService {
	
	@Autowired
	private FinalDeclarationRepository finalDeclarationRepository;
	
	public FinalDeclaration save(FinalDeclaration finalDeclaration){
		return finalDeclarationRepository.save(finalDeclaration);
	}
	
	public FinalDeclaration findById(Long declarationId)throws ResourceNotFoundException{
		return finalDeclarationRepository.findById(declarationId).orElseThrow(()-> new ResourceNotFoundException
				("Final Declaration data not found ::"+declarationId));
	}
	
}
