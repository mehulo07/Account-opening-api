package com.bns.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.PaymentDeliveryTerms;
import com.bns.model.PaymentMethod;
import com.bns.model.PaymentMethodInfo;
import com.bns.model.PaymentTermsRequest;
import com.bns.repository.PaymentDeliveryTermsRepository;
import com.bns.repository.PaymentMethodInfoRepository;
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
	
	@Autowired
	private PaymentMethodInfoRepository paymentMethodInfoRepository;

	public List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodRepository.findAll();
	}

	public List<PaymentTermsRequest> getAllTermsReq() {
		return paymentTermsRequestRepository.findAll();
	}
	
	public List<PaymentDeliveryTerms> getAllDeliveryTerms(){
		return paymentDeliveryTermsRepository.findAll();
	}
	public String createPaymentMethodInfo(PaymentMethodInfo paymentMethodInfo) {
		try {
			paymentMethodInfoRepository.save(paymentMethodInfo);
			return "Success";
		}catch (Exception e) {
			return "Error";
		}
	}
	public List<PaymentMethodInfo> getAllPaymentMethodInfo(){
		return paymentMethodInfoRepository.findAll();
	}
	public Optional<PaymentMethodInfo> getPaymentMethodInfoById(Long methodInfoId){
		return paymentMethodInfoRepository.findById(methodInfoId);
	}
	public PaymentMethodInfo updatePaymentMethodInfo(Long methodInfoId,PaymentMethodInfo paymentMethodInfoDetails) throws ResourceNotFoundException {
		PaymentMethodInfo paymentMethodInfo = paymentMethodInfoRepository.findById(methodInfoId)
				.orElseThrow(() -> new ResourceNotFoundException("Method not found"));
		paymentMethodInfo.setComments(paymentMethodInfoDetails.getComments());
		paymentMethodInfo.setPaymentMethodId(paymentMethodInfoDetails.getPaymentMethodId());
		paymentMethodInfo.setnHSIncome(paymentMethodInfoDetails.getnHSIncome());
		paymentMethodInfo.setPaymentTermId(paymentMethodInfoDetails.getPaymentTermId());
		paymentMethodInfo.setCreditReq(paymentMethodInfoDetails.getCreditReq());
		paymentMethodInfo.setPaymentDeliTermId(paymentMethodInfoDetails.getPaymentDeliTermId());
		paymentMethodInfo.setBusinessInfoId(paymentMethodInfoDetails.getBusinessInfoId());
		paymentMethodInfo.setUpdatedBy(paymentMethodInfoDetails.getUpdatedBy());
		final PaymentMethodInfo updatedPaymentMethodInfo = paymentMethodInfoRepository.save(paymentMethodInfo);
		return updatedPaymentMethodInfo;
	}
	public Map<String, Boolean> deletePaymentMethodInfo(Long methodInfoId) throws ResourceNotFoundException{
		PaymentMethodInfo paymentMethodInfo = paymentMethodInfoRepository.findById(methodInfoId)
				.orElseThrow(() -> new ResourceNotFoundException("Method Not Fount"));
		paymentMethodInfoRepository.delete(paymentMethodInfo);
		Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
		
	}

}
