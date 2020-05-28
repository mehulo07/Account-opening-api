package com.bns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.PaymentDeliveryTerms;
import com.bns.model.PaymentMethod;
import com.bns.model.PaymentTermsRequest;
import com.bns.repository.PaymentDeliveryTermsRepository;
import com.bns.repository.PaymentMethodRepository;
import com.bns.repository.PaymentTermsRequestRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
	
	@Autowired
	private PaymentTermsRequestRepository paymentTermsRequestRepository;
	
	@Autowired
	private PaymentDeliveryTermsRepository paymentDeliveryTermsRepository;

	public List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodRepository.findAll();
	}

	public List<PaymentTermsRequest> getAllTermsReq() {
		return paymentTermsRequestRepository.findAll();
	}
	
	public List<PaymentDeliveryTerms> getAllDeliveryTerms(){
		return paymentDeliveryTermsRepository.findAll();
	}

}
