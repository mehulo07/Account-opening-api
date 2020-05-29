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
import com.bns.model.PaymentDeliveryTerms;
import com.bns.model.PaymentMethod;
import com.bns.model.PaymentMethodInfo;
import com.bns.model.PaymentTermsRequest;
import com.bns.service.PaymentService;

@CrossOrigin()
@RestController
@RequestMapping("/v1/openAccount")
public class PaymentController {
	private final Logger log = LogManager.getLogger(this.getClass());
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/paymentMethod")
	public List<PaymentMethod> getAllPaymentMethod(){
		return paymentService.getAllPaymentMethod();
	}
	
	@GetMapping("/paymentTermsReq")
	public List<PaymentTermsRequest> getAllTermsReq(){
		return paymentService.getAllTermsReq();
	}
	
	@GetMapping("/paymentDeliveryTerms")
	public List<PaymentDeliveryTerms> getAllDeliveryTerms(){
		return paymentService.getAllDeliveryTerms();
	}
	@PostMapping("/paymentMethodInfo")
	public String createPaymentMethodInfo(@RequestBody PaymentMethodInfo paymentMethodInfo) {
		return paymentService.createPaymentMethodInfo(paymentMethodInfo);
	}
	@GetMapping("/paymentMethodInfo")
	public List<PaymentMethodInfo> getAllPaymentMethodInfo(){
		return paymentService.getAllPaymentMethodInfo();
	}
	@GetMapping("/paymentMethodInfo/{id}")
	public ResponseEntity<PaymentMethodInfo> getPaymentMethodInfoById(@PathVariable(value = "id") Long methodInfoId) throws ResourceNotFoundException{
		PaymentMethodInfo paymentMethodInfo = paymentService.getPaymentMethodInfoById(methodInfoId).orElseThrow(()-> new ResourceNotFoundException("Method not Found"));
		return ResponseEntity.ok().body(paymentMethodInfo);
	}
	@PutMapping("/paymentMethodInfo/{id}")
	public ResponseEntity<PaymentMethodInfo> updatePaymentMethodInfo(@PathVariable(value = "id") Long methodInfoId
			, @Valid @RequestBody PaymentMethodInfo paymentMethodInfo) throws ResourceNotFoundException{
		PaymentMethodInfo updatePaymentMethodInfo = paymentService.updatePaymentMethodInfo(methodInfoId, paymentMethodInfo);
		return ResponseEntity.ok(updatePaymentMethodInfo);
	}
	@DeleteMapping("/paymentMethodInfo/{id}")
	public Map<String, Boolean> deletePaymentMethodInfo(@PathVariable(value = "id") Long methodInfoId) throws ResourceNotFoundException{
		return paymentService.deletePaymentMethodInfo(methodInfoId);
	}

}
