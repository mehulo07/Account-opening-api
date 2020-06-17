package com.bns.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.Registration;
import com.bns.model.SecurityQue;
import com.bns.model.MarketingPref;
import com.bns.repository.MarketingPrefRepository;
import com.bns.repository.RegistrationRepository;
import com.bns.service.MarketingPrefService;

import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class MarketingPrefController {
	@Autowired
	private MarketingPrefService accountOpeningMarketingPrefService;

	@Autowired
	private RegistrationRepository accOpeningRegRepository;

	@Autowired
	private MarketingPrefRepository marketingPrefRepository;

	@PostMapping("/accountOpeningMarketingPref")
	public MarketingPref marketingpreferenceSave(@Valid @RequestBody MarketingPref accountOpeningMarketingPref)
			throws Exception {
		int reg = accountOpeningMarketingPref.getAccOpeningReg().getAccountOpeningRegInfoId();

		Registration accOpeningReg = accOpeningRegRepository.findById(reg).get();

		accountOpeningMarketingPref.setAccOpeningReg(accOpeningReg);
//		JSONObject json = new JSONObject();
//		json.put("status", 200);
//		json.put("message", "Successfully Added");
//		json.put("accountOpeningMarketingPref",
//				);
		return accountOpeningMarketingPrefService.createAccountOpeningMarketingPref(accountOpeningMarketingPref);

	}

	@GetMapping("/accountOpeningMarketingPref/{id}")
	public ResponseEntity<MarketingPref> marketingpreferenceList(@PathVariable(value = "id") Long marketingpreId)
			throws ResourceNotFoundException {
		MarketingPref accountOpeningMarketingPref = accountOpeningMarketingPrefService
				.getMarketingPrefId(marketingpreId).orElseThrow(() -> new ResourceNotFoundException(
						"Marketing preference not found for this id :: " + marketingpreId));
		return ResponseEntity.ok().body(accountOpeningMarketingPref);
	}

	@GetMapping("/accountOpeningMarketingPrefAccRegID/{id}")
	public List<MarketingPref> getaccountOpeningMarketingPrefAccRegID(@PathVariable(value = "id") Long accRegId) {
		return marketingPrefRepository.findByaccRegId(accRegId);
	}

}
