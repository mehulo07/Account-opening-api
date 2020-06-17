package com.bns.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

import javax.mail.MessagingException;
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
import com.bns.model.AccountAddress;
import com.bns.model.BusinessInfo;
import com.bns.model.BusinessBuyingGroupMaster;
import com.bns.model.BusinessOrderSystemMaster;
import com.bns.model.BusinessPmrMaster;
import com.bns.model.BusinessSupplierMaster;
import com.bns.model.TradingInformationDetails;
import com.bns.model.TradingInformationSubBuying;
import com.bns.model.TradingInformationSubOrder;
import com.bns.model.TradingInformationSubPmr;
import com.bns.model.TradingInformationSubSupplier;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.BusinessBuyingGroupRepository;
import com.bns.repository.BusinessOrderSystemMasterRepository;
import com.bns.repository.BusinessPmrMasterRepository;
import com.bns.repository.BusinessSupplierMasterRepository;
import com.bns.repository.TradingInformationDetailsRepository;
import com.bns.repository.TradingInformationSubBuyingRepository;
import com.bns.repository.TradingInformationSubOrderRepository;
import com.bns.repository.TradingInformationSubPmrRepository;
import com.bns.repository.TradingInformationSubSupplierRepository;
import com.bns.service.TradingInformationDetailsService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class TradingInformationDetailsController {

	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private TradingInformationDetailsRepository tradingInformationDetailsRepository;
	@Autowired
	private TradingInformationDetailsService tradingInformationDetailsService;
	@Autowired
	private BusinessSupplierMasterRepository businessSupplierRepository;
	@Autowired
	private BusinessPmrMasterRepository businessPmrRepository;
	@Autowired
	private BusinessOrderSystemMasterRepository businessOrderSystemRepository;

	@Autowired
	private BusinessBuyingGroupRepository businessBuyingGroupRepository;

	@Autowired
	private TradingInformationSubSupplierRepository tradingInformationSubSupplierRepository;

	@Autowired
	private TradingInformationSubPmrRepository tradingInformationSubPmrRepository;

	@Autowired
	private TradingInformationSubBuyingRepository tradingInformationSubBuyingRepository;

	@Autowired
	private TradingInformationSubOrderRepository tradingInformationSubOrderRepository;

//	@PostMapping("/tradingInformationDetails")
//	public TradingInformationDetails tradingInformationDetailsSave(
//			@Valid @RequestBody TradingInformationDetails tradingInformationDetails) throws Exception {
//
//		long businessinfoid = tradingInformationDetails.getAccountOpeningBusinessInfo()
//				.getAccountOpeningBusinessInfoId();
//		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
//				.findById(businessinfoid).get();
//		tradingInformationDetails.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
//
//		long suppierid = tradingInformationDetails.getBusinessSupplier().getBusinessSupplierId();
//		BusinessSupplierMaster businessSupplier = businessSupplierRepository.findById(suppierid).get();
//		tradingInformationDetails.setBusinessSupplier(businessSupplier);
//
//		long businessPmrid = tradingInformationDetails.getBusinessPmr().getBusinessPmrId();
//		BusinessPmrMaster businessPmr = businessPmrRepository.findById(businessPmrid).get();
//		tradingInformationDetails.setBusinessPmr(businessPmr);
//
//		long businessSystemId = tradingInformationDetails.getBusinessOrderSystem().getBusinessOrderSystemId();
//		BusinessOrderSystemMaster businessOrderSystem = businessOrderSystemRepository.findById(businessSystemId).get();
//		tradingInformationDetails.setBusinessOrderSystem(businessOrderSystem);
//
//		long businessGpId = tradingInformationDetails.getBusinessBuyingGroup().getBusinessBuyingGroupId();
//		BusinessBuyingGroupMaster businessBuyingGroup = businessBuyingGroupRepository.findById(businessGpId).get();
//		tradingInformationDetails.setBusinessBuyingGroup(businessBuyingGroup);
//
//		return tradingInformationDetailsService.createTradingInformationDetails(tradingInformationDetails);
//
//	}

	@GetMapping("/tradingInformationDetails/{id}")
	public ResponseEntity<TradingInformationDetails> getTradingInformationDetailsById(
			@PathVariable(value = "id") Long tradingInformationDetailsId) throws ResourceNotFoundException {
		TradingInformationDetails tradingInformationDetails = tradingInformationDetailsService
				.getTradingInformationDetailsId(tradingInformationDetailsId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"TradingInformationDetails not found for this id :: " + tradingInformationDetailsId));
		return ResponseEntity.ok().body(tradingInformationDetails);
	}

	@GetMapping("/tradingInformationDetailsByBusinessinfoId/{id}")
	public List<TradingInformationDetails> getTradingInformationDetailsBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return tradingInformationDetailsRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/tradingInformationDetails/{id}")
	public ResponseEntity<TradingInformationDetails> updateTradingInformationDetails(
			@PathVariable(value = "id") Long tradingInformationDetailsId,
			@Valid @RequestBody TradingInformationDetails tradingInformationDetails) throws ResourceNotFoundException {

		TradingInformationDetails tradingInformationDetails1 = tradingInformationDetailsService
				.updateTradingInformationDetails(tradingInformationDetailsId, tradingInformationDetails);
		return ResponseEntity.ok(tradingInformationDetails1);
	}

	@PostMapping("/tradingInformationDetails")
	public TradingInformationDetails tradingInformationDetailsSave(@Valid @RequestBody JSONObject tradingInformationDetails)
			throws IOException, ParseException, MessagingException,InvocationTargetException ,Exception{
		TradingInformationDetails tradingInformationDetails1 = new TradingInformationDetails();

		JSONObject jsonObj = new JSONObject();
		jsonObj = tradingInformationDetails;

		String accountOpeningBusinessInfoId = jsonObj.optString("accountOpeningBusinessInfoId");
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(Long.valueOf(accountOpeningBusinessInfoId)).get();

		tradingInformationDetails1.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

//		Started BusinessBuyingGroupMaster
		JSONArray ja_data = jsonObj.getJSONArray("data");
		int length = ja_data.size();
		for (int i = 0; i < length; i++) {
			JSONObject jObj = ja_data.getJSONObject(i);
			String id = jObj.optString("businessBuyingGroupId");
//			  BusinessBuyingGroupMaster "Data" Extract
			BusinessBuyingGroupMaster businessBuyingGroup = businessBuyingGroupRepository.findById(Long.valueOf(id))
					.get();

			TradingInformationSubBuying tradingInformationSubBuying = new TradingInformationSubBuying();
			tradingInformationSubBuying.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			tradingInformationSubBuying.setBusinessBuyingGroup(businessBuyingGroup);
			tradingInformationSubBuyingRepository.save(tradingInformationSubBuying);

		}

//		End  BusinessBuyingGroupMaster

//		Started BusinessOrderSystem
		JSONArray ja_data1 = jsonObj.getJSONArray("data1");
		int length1 = ja_data1.size();
		for (int i = 0; i < length1; i++) {
			JSONObject jObj1 = ja_data1.getJSONObject(i);
			String id = jObj1.optString("businessOrderSystemId");
//			  BusinessOrderSystem "Data" Extract
			BusinessOrderSystemMaster businessOrderSystem = businessOrderSystemRepository.findById(Long.valueOf(id))
					.get();

			TradingInformationSubOrder tradingInformationSubOrder = new TradingInformationSubOrder();
			tradingInformationSubOrder.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			tradingInformationSubOrder.setBusinessOrderSystem(businessOrderSystem);
			tradingInformationSubOrderRepository.save(tradingInformationSubOrder);

		}

//		End  BusinessOrderSystem

//		Started businessPmr
		JSONArray ja_data2 = jsonObj.getJSONArray("data2");
		int length2 = ja_data2.size();
		for (int i = 0; i < length2; i++) {
			JSONObject jObj2 = ja_data2.getJSONObject(i);
			String id = jObj2.optString("businessPmrId");
//			  businessPmrId "Data" Extract
			BusinessPmrMaster businessPmr = businessPmrRepository.findById(Long.valueOf(id)).get();

			TradingInformationSubPmr tradingInformationSubPmr = new TradingInformationSubPmr();
			tradingInformationSubPmr.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			tradingInformationSubPmr.setBusinessPmr(businessPmr);
			tradingInformationSubPmrRepository.save(tradingInformationSubPmr);

		}

//		End  businessPmr

//		Started businessSupplier
		JSONArray ja_data3 = jsonObj.getJSONArray("data3");
		int length3 = ja_data3.size();
		for (int i = 0; i < length3; i++) {
			JSONObject jObj3 = ja_data3.getJSONObject(i);
			String id = jObj3.optString("businessSupplierId");
//			  businessSupplier "Data" Extract
			BusinessSupplierMaster businessSupplier = businessSupplierRepository.findById(Long.valueOf(id)).get();
			TradingInformationSubSupplier tradingInformationSubSupplier = new TradingInformationSubSupplier();
			tradingInformationSubSupplier.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);
			tradingInformationSubSupplier.setBusinessSupplier(businessSupplier);
			tradingInformationSubSupplierRepository.save(tradingInformationSubSupplier);

		}

//		End  businessSupplier

		// TradingInfo Model

		String buyerName = jsonObj.optString("buyerName");
		tradingInformationDetails1.setBuyerName(buyerName);
		String emailAdd = jsonObj.optString("emailAdd");
		tradingInformationDetails1.setEmailAdd(emailAdd);
		String faxNumber = jsonObj.optString("faxNumber");
		tradingInformationDetails1.setFaxNumber(faxNumber);
		String moblieNo = jsonObj.optString("moblieNo");
		tradingInformationDetails1.setMoblieNo(moblieNo);
		String otherContactName = jsonObj.optString("otherContactName");
		tradingInformationDetails1.setOtherContactName(otherContactName);
		String telephoneNumber = jsonObj.optString("telephoneNumber");
		tradingInformationDetails1.setTelephoneNumber(telephoneNumber);
		String websiteurl = jsonObj.optString("websiteurl");
		tradingInformationDetails1.setWebsiteurl(websiteurl);

//		 TradingInformationDetails  tradingInformationDetails2=tradingInformationDetailsService.createTradingInformationDetails(tradingInformationDetails1);
		
		return tradingInformationDetailsService.createTradingInformationDetails(tradingInformationDetails1);
//		return json;

	}

}
