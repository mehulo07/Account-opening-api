package com.bns.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.PaymentDeliveryTermsMaster;
import com.bns.model.PaymentMethodMaster;
import com.bns.model.PaymentMethodInfo;
import com.bns.model.PaymentTermsRequestMaster;
import com.bns.repository.PaymentDeliveryTermsMasterRepository;
import com.bns.repository.PaymentMethodInfoRepository;
import com.bns.repository.PaymentMethodMasterRepository;
import com.bns.repository.PaymentTermsRequestMasterRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentMethodMasterRepository paymentMethodRepository;
	
	@Autowired
	private PaymentTermsRequestMasterRepository paymentTermsRequestRepository;
	
	@Autowired
	private PaymentDeliveryTermsMasterRepository paymentDeliveryTermsRepository;
	
	@Autowired
	private PaymentMethodInfoRepository paymentMethodInfoRepository;

	public List<PaymentMethodMaster> getAllPaymentMethod() {
		return paymentMethodRepository.findAll();
	}

	public List<PaymentTermsRequestMaster> getAllTermsReq() {
		return paymentTermsRequestRepository.findAll();
	}
	
	public List<PaymentDeliveryTermsMaster> getAllDeliveryTerms(){
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
