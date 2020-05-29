package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.service.FinalDeclarationService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class FinalDeclarationController {
	
	@Autowired
	private FinalDeclarationService  finalDeclarationService;
	
	@PostMapping("/finalDeclaration")
	public ResponseEntity<FinalDeclaration> saveFinalDeclaration(@RequestBody FinalDeclaration finalDeclaration){
		FinalDeclaration tempFinalDeclaration = finalDeclarationService.save(finalDeclaration);
		return ResponseEntity.ok(tempFinalDeclaration);
	}
	
	@GetMapping("/finalDeclaration/{id}")
	public ResponseEntity<FinalDeclaration> getById(@PathVariable(value = "id") Long declarationId) throws ResourceNotFoundException{
		FinalDeclaration tempFinalDeclaration = finalDeclarationService.findById(declarationId);
		return ResponseEntity.ok(tempFinalDeclaration);
	}

}
