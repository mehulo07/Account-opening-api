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
import com.bns.model.AccountAddressTab;
import com.bns.model.BusinessInfo;
import com.bns.model.DirectorInfo;
import com.bns.repository.BusinessInfoRepository;
import com.bns.repository.DirectorInfoRepository;
import com.bns.service.DirectorInfoService;

@RestController
@CrossOrigin
@RequestMapping("/v1/openAccount")
public class DirectorInfoController {
	@Autowired
	private BusinessInfoRepository accountOpeningBusinessInfoRepository;

	@Autowired
	private DirectorInfoRepository accountOpeningDirectorInfoRepository;

	@Autowired
	private DirectorInfoService accountOpeningDirectorInfoService;

	@PostMapping("/accountOpeningDirectorInfo")
	public DirectorInfo accountOpeningDirectorInfoSave(
			@Valid @RequestBody DirectorInfo accountOpeningDirectorInfo) throws Exception {

		long businessinfoid = accountOpeningDirectorInfo.getAccountOpeningBusinessInfo()
				.getAccountOpeningBusinessInfoId();
		BusinessInfo accountOpeningBusinessInfo = accountOpeningBusinessInfoRepository
				.findById(businessinfoid).get();
		accountOpeningDirectorInfo.setAccountOpeningBusinessInfo(accountOpeningBusinessInfo);

		return accountOpeningDirectorInfoService.createAccountOpeningDirectorInfo(accountOpeningDirectorInfo);

	}

	@GetMapping("/accountOpeningDirectorInfo/{id}")
	public ResponseEntity<DirectorInfo> getAccountOpeningDirectorInfoById(
			@PathVariable(value = "id") Long accountOpeningDirectorInfoId) throws ResourceNotFoundException {
		DirectorInfo accountOpeningDirectorInfo = accountOpeningDirectorInfoService
				.getAccountOpeningDirectorInfoId(accountOpeningDirectorInfoId)
				.orElseThrow(() -> new ResourceNotFoundException(
						"AccountOpeningDirectorInfo not found for this id :: " + accountOpeningDirectorInfoId));
		return ResponseEntity.ok().body(accountOpeningDirectorInfo);
	}

	// reg id getAll List
	@GetMapping("/accountOpeningDirectorInfoByBusinessinfoId/{id}")
	public List<DirectorInfo> getAccountOpeningDirectorInfoBusinessID(
			@PathVariable(value = "id") Long businessinfoId) {
		return accountOpeningDirectorInfoRepository.findByBusinessInfoId(businessinfoId);
	}

	@PutMapping("/accountOpeningDirectorInfo/{id}")
	public ResponseEntity<DirectorInfo> updateAccountOpeningDirectorInfo(
			@PathVariable(value = "id") Long accountOpeningDirectorInfoId,
			@Valid @RequestBody DirectorInfo accountOpeningDirectorInfo)
			throws ResourceNotFoundException {

		DirectorInfo accountOpeningDirectorInfo1 = accountOpeningDirectorInfoService
				.updateAccountOpeningDirectorInfo(accountOpeningDirectorInfoId, accountOpeningDirectorInfo);
		return ResponseEntity.ok(accountOpeningDirectorInfo1);
	}

}
