package com.bns.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.CustomerBankInfo;
import com.bns.service.CustomerBankInfoService;

@CrossOrigin()
@RestController
@RequestMapping("/v1/openAccount")
public class CustomerBankInfoController {
	private final Logger log = LogManager.getLogger(this.getClass());
	@Autowired
	private CustomerBankInfoService customerBankInfoService;
	
	@PostMapping("/customerBankInfo")
	public String createCustBankInfo(@RequestBody CustomerBankInfo custBankInfo) {
		return customerBankInfoService.createCustBankInfo(custBankInfo);
	}
	@GetMapping("/customerBankInfo")
	public List<CustomerBankInfo> getAllCustBankInfo(){
		return customerBankInfoService.getAllCustBankInfo();
	}
	@GetMapping("/customerBankInfo/{id}")
	public ResponseEntity<CustomerBankInfo> getCustBankInfoById(@PathVariable(value = "id") Long custBankInfoId) throws ResourceNotFoundException{
		CustomerBankInfo customerBankInfo = customerBankInfoService.getCustBankInfoById(custBankInfoId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
		return ResponseEntity.ok().body(customerBankInfo);
	}
	@PutMapping("/customerBankInfo/{id}")
	public ResponseEntity<CustomerBankInfo> updateCustBankInfo(@PathVariable(value = "id") Long custBankInfoId
			,@Valid @RequestBody CustomerBankInfo customerBankInfo) throws ResourceNotFoundException{
		CustomerBankInfo updateCustomerBankInfo = customerBankInfoService.updateCustBankInfo(custBankInfoId, customerBankInfo);
		return ResponseEntity.ok(updateCustomerBankInfo);
		
	}
	@DeleteMapping("/customerBankInfo/{id}")
	public Map<String, Boolean> deleteCustomerBankInfo(@PathVariable(value = "id") Long custBankInfoId) throws ResourceNotFoundException{
		return customerBankInfoService.deleteCustomerBankInfo(custBankInfoId);
	}

}
