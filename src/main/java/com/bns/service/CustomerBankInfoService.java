package com.bns.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.CustomerBankInfo;
import com.bns.repository.CustomerBankInfoRepository;

@Service
public class CustomerBankInfoService {
	@Autowired
	private CustomerBankInfoRepository customerBankInfoRepository;
	
	public List<CustomerBankInfo> getAllCustBankInfo(){
		return customerBankInfoRepository.findAll();
	}
	public String createCustBankInfo(CustomerBankInfo customerBankInfo) {
		try {
			customerBankInfoRepository.save(customerBankInfo);
			return "Success";
		}catch (Exception e) {
			return "Error";
		}
	}
	public Optional<CustomerBankInfo> getCustBankInfoById(Long custBankInfoId){
		return customerBankInfoRepository.findById(custBankInfoId);
	}
	public CustomerBankInfo updateCustBankInfo(Long custBankInfoId,CustomerBankInfo customerBankInfoDetails) throws ResourceNotFoundException{
		CustomerBankInfo customerBankInfo = customerBankInfoRepository.findById(custBankInfoId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
		customerBankInfo.setCustName(customerBankInfoDetails.getCustName());
		customerBankInfo.setCustSurName(customerBankInfoDetails.getCustSurName());
		customerBankInfo.setCustAccNo(customerBankInfoDetails.getCustAccNo());
		customerBankInfo.setCustSortCode(customerBankInfoDetails.getCustSortCode());
		customerBankInfo.setCustReference(customerBankInfoDetails.getCustReference());
		customerBankInfo.setCustBankName(customerBankInfoDetails.getCustBankName());
		customerBankInfo.setCustDate(customerBankInfoDetails.getCustDate());
		customerBankInfo.setBusinessInfoId(customerBankInfoDetails.getBusinessInfoId());
		final CustomerBankInfo updatedCustomerBankInfo = customerBankInfoRepository.save(customerBankInfo);
		return updatedCustomerBankInfo;
	}
	public Map<String, Boolean> deleteCustomerBankInfo(Long custBankInfoId) throws ResourceNotFoundException{
		CustomerBankInfo customerBankInfo = customerBankInfoRepository.findById(custBankInfoId)
				.orElseThrow(() -> new ResourceNotFoundException("Method Not Fount"));
		customerBankInfoRepository.delete(customerBankInfo);
		Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

}
