package com.bns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bns.model.TradingName;
import com.bns.service.ExistingAccInfoService;
import com.bns.service.TradingNameService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class ExistingAccountInfoController {
	
	@Autowired
	private ExistingAccInfoService existingAccInfoService;
	
	@Autowired
	private TradingNameService tradingNameService;
	
	@GetMapping("/existingAccount/{id}")
	public TradingName getExistingAccount(@PathVariable(value = "id") String accountNo) {
		System.out.println("inside getExistingAccount");
		TradingName tradingName =tradingNameService.getTradingNameInfo(accountNo);
		tradingName.setExistingAccInfo(existingAccInfoService.getByCustomerId(accountNo));
		return tradingName;
	}
	
}
