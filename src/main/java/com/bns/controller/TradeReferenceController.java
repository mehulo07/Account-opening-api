package com.bns.controller;

import java.util.List;

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
import com.bns.model.BusinessInfo;
import com.bns.model.TradeReference;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.TradeReferenceRepository;
import com.bns.service.TradeReferenceService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class TradeReferenceController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private TradeReferenceRepository accountOpeningTradeReferenceRepository;

	@Autowired
	private TradeReferenceService accountOpeningTradeReferenceService;

	@PostMapping("/accountOpeningTradeReference")
	public TradeReference accountOpeningTradeReferenceSave(
			@Valid @RequestBody TradeReference accountOpeningTradeReference) throws Exception {

		long businessinfoid = accountOpeningTradeReference.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningTradeReference.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningTradeReferenceService.createAccountOpeningTradeReference(accountOpeningTradeReference);
	}

	@GetMapping("/accountOpeningTradeReference/{id}")
	public ResponseEntity<TradeReference> getAccountOpeningTradeReferenceById(
			@PathVariable(value = "id") Long accountOpeningTradeReferenceId) throws ResourceNotFoundException {
		TradeReference accountOpeningTradeReference = accountOpeningTradeReferenceService
				.getAccountOpeningTradeReferenceId(accountOpeningTradeReferenceId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningTradeReference not found for this id :: " + accountOpeningTradeReferenceId));
		return ResponseEntity.ok().body(accountOpeningTradeReference);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningTradeReferenceByBusinessinfoId/{id}")
	public List<TradeReference> getAccountOpeningTradeReferenceBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningTradeReferenceRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningTradeReference/{id}")
	public ResponseEntity<TradeReference> updateAccountOpeningTradeReference(
			@PathVariable(value = "id") Long accountOpeningTradeReferenceId,
			@Valid @RequestBody TradeReference accountOpeningTradeReference)
			throws ResourceNotFoundException {

		TradeReference accountOpeningTradeReference1 = accountOpeningTradeReferenceService
				.updateAccountOpeningTradeReference(accountOpeningTradeReferenceId, accountOpeningTradeReference);
		return ResponseEntity.ok(accountOpeningTradeReference1);
	}

}
