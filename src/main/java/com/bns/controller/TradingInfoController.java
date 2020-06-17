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

import com.bns.model.TradingInfo;
import com.bns.repository.BusinessInfoRepository;

import com.bns.repository.TradingInfoRepository;
import com.bns.service.TradingInfoService;

import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class TradingInfoController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private TradingInfoRepository accountOpeningTradingInfoRepository;

	@Autowired
	private TradingInfoService accountOpeningTradingInfoService;

	@PostMapping("/accountOpeningTradingInfo")
	public TradingInfo accountOpeningTradingInfoSave(@Valid @RequestBody TradingInfo accountOpeningTradingInfo)
			throws Exception {

		long businessinfoid = accountOpeningTradingInfo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository.findById(businessinfoid).get();
		accountOpeningTradingInfo.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
//		JSONObject json = new JSONObject();
//		json.put("Status", 200);
//		json.put("message", "Successfully Added");
//		json.put("accountOpeningTradingInfo",
//				);

		return accountOpeningTradingInfoService.createAccountOpeningTradingInfo(accountOpeningTradingInfo);

	}

	@GetMapping("/accountOpeningTradingInfo/{id}")
	public ResponseEntity<TradingInfo> getAccountOpeningTradingInfoById(
			@PathVariable(value = "id") Long accountOpeningTradingInfoId) throws ResourceNotFoundException {
		TradingInfo accountOpeningTradingInfo = accountOpeningTradingInfoService
				.getAccountOpeningTradingInfoId(accountOpeningTradingInfoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningTradingInfo not found for this id :: " + accountOpeningTradingInfoId));
		return ResponseEntity.ok().body(accountOpeningTradingInfo);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningTradingInfoByBusinessinfoId/{id}")
	public List<TradingInfo> getAccountOpeningTradingInfoBusinessID(@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningTradingInfoRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningTradingInfo/{id}")
	public ResponseEntity<TradingInfo> updateAccountOpeningTradingInfo(
			@PathVariable(value = "id") Long accountOpeningTradingInfoId,
			@Valid @RequestBody TradingInfo accountOpeningTradingInfo) throws ResourceNotFoundException {

		TradingInfo accountOpeningTradingInfo1 = accountOpeningTradingInfoService
				.updateAccountOpeningTradingInfo(accountOpeningTradingInfoId, accountOpeningTradingInfo);
		return ResponseEntity.ok(accountOpeningTradingInfo1);
	}

}
