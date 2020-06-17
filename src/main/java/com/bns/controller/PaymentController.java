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
import com.bns.model.PaymentDeliveryTermsMaster;
import com.bns.model.PaymentMethodMaster;
import com.bns.model.PaymentMethodInfo;
import com.bns.model.PaymentTermsRequestMaster;
import com.bns.repository.PaymentDeliveryTermsMasterRepository;
import com.bns.repository.PaymentMethodMasterRepository;
import com.bns.repository.PaymentTermsRequestMasterRepository;
import com.bns.service.PaymentService;

@CrossOrigin()
@RestController
@RequestMapping("/v1/openAccount")
public class PaymentController {
	private final Logger log = LogManager.getLogger(this.getClass());
	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PaymentMethodMasterRepository paymentMethodRepository;

	@Autowired
	private PaymentTermsRequestMasterRepository paymentTermsRequestRepository;

	@Autowired
	private PaymentDeliveryTermsMasterRepository paymentDeliveryTermsRepository;

	@GetMapping("/paymentMethod")
	public List<PaymentMethodMaster> getAllPaymentMethod() {
		return paymentService.getAllPaymentMethod();
	}

	@GetMapping("/paymentTermsReq")
	public List<PaymentTermsRequestMaster> getAllTermsReq() {
		return paymentService.getAllTermsReq();
	}

	@GetMapping("/paymentDeliveryTerms")
	public List<PaymentDeliveryTermsMaster> getAllDeliveryTerms() {
		return paymentService.getAllDeliveryTerms();
	}

	@PostMapping("/paymentMethodInfo")
	public String createPaymentMethodInfo(@RequestBody PaymentMethodInfo paymentMethodInfo) {
		return paymentService.createPaymentMethodInfo(paymentMethodInfo);
	}

	@GetMapping("/paymentMethodInfo")
	public List<PaymentMethodInfo> getAllPaymentMethodInfo() {
		return paymentService.getAllPaymentMethodInfo();
	}

	@GetMapping("/paymentMethodInfo/{id}")
	public ResponseEntity<PaymentMethodInfo> getPaymentMethodInfoById(@PathVariable(value = "id") Long methodInfoId)
			throws ResourceNotFoundException {
		PaymentMethodInfo paymentMethodInfo = paymentService.getPaymentMethodInfoById(methodInfoId)
				.orElseThrow(() -> new ResourceNotFoundException("Method not Found"));
		return ResponseEntity.ok().body(paymentMethodInfo);
	}

	@PutMapping("/paymentMethodInfo/{id}")
	public ResponseEntity<PaymentMethodInfo> updatePaymentMethodInfo(@PathVariable(value = "id") Long methodInfoId,
			@Valid @RequestBody PaymentMethodInfo paymentMethodInfo) throws ResourceNotFoundException {
		PaymentMethodInfo updatePaymentMethodInfo = paymentService.updatePaymentMethodInfo(methodInfoId,
				paymentMethodInfo);
		return ResponseEntity.ok(updatePaymentMethodInfo);
	}

	@DeleteMapping("/paymentMethodInfo/{id}")
	public Map<String, Boolean> deletePaymentMethodInfo(@PathVariable(value = "id") Long methodInfoId)
			throws ResourceNotFoundException {
		return paymentService.deletePaymentMethodInfo(methodInfoId);
	}

	@PostMapping("/paymentMethod")
	public PaymentMethodMaster createPaymentMethod(@RequestBody PaymentMethodMaster paymentMethodMaster) {
		return paymentMethodRepository.save(paymentMethodMaster);
	}

	@PostMapping("/paymentDeliveryTerms")
	public PaymentDeliveryTermsMaster createPaymentDeliveryTermsMaster(
			@RequestBody PaymentDeliveryTermsMaster paymentDeliveryTermsMaster) {
		return paymentDeliveryTermsRepository.save(paymentDeliveryTermsMaster);
	}

	@PostMapping("/paymentTermsReq")
	public PaymentTermsRequestMaster createPaymentTermsRequestMaster(
			@RequestBody PaymentTermsRequestMaster paymentTermsRequestMaster) {
		return paymentTermsRequestRepository.save(paymentTermsRequestMaster);
	}

}
