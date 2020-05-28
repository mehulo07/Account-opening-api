package com.bns.controller;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.PaymentDeliveryTerms;
import com.bns.model.PaymentMethod;
import com.bns.model.PaymentTermsRequest;
import com.bns.service.PaymentService;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1")
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

}
