package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.TradingName;
import com.bns.repository.TradingNameRepository;

@Service
public class TradingNameService {

	@Autowired
	private TradingNameRepository tradingNameRepository;
	
	public TradingName getTradingNameInfo(String customerAccNO) {
		return tradingNameRepository.findById(customerAccNO).get();
	}
	
}
