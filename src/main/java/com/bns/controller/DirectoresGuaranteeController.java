package com.bns.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.DirectoresGuarantee;
import com.bns.service.DirectoresGuaranteeService;

@RestController
@CrossOrigin
@RequestMapping("/AccOpeningAPI")
public class DirectoresGuaranteeController {
	
	@Autowired
	private DirectoresGuaranteeService directoresGuaranteeService;
	
	@PostMapping("/directorsGuarantee")
	public ResponseEntity<DirectoresGuarantee> save(@Valid @RequestBody DirectoresGuarantee directoresGuarantee) throws Exception{
		DirectoresGuarantee tempDirectoresGuarantee = null;
		tempDirectoresGuarantee = directoresGuaranteeService.save(directoresGuarantee);
		return ResponseEntity.ok(tempDirectoresGuarantee);
	}
	
	
	@GetMapping("/directorsGuarantee/{id}")
	public ResponseEntity<DirectoresGuarantee> getDirectoresGuarantee(@PathVariable(value="id") Long id) throws Exception{
		DirectoresGuarantee tempDirectoresGuarantee = null;
		tempDirectoresGuarantee = directoresGuaranteeService.getById(id);
		return ResponseEntity.ok(tempDirectoresGuarantee);

	}
	
	@PutMapping("/directorsGuarantee/{id}")
	public ResponseEntity<DirectoresGuarantee> updateDirectoresGuarantee(
			@PathVariable(value = "id") Long guaranteeId,
			@Valid @RequestBody DirectoresGuarantee directoresGuarantee)
			throws ResourceNotFoundException {
		
		DirectoresGuarantee tempDirectoresGuarantee = directoresGuaranteeService.update(guaranteeId, directoresGuarantee);
		
		return ResponseEntity.ok(tempDirectoresGuarantee);
	}
	
}
