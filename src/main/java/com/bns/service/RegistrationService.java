package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.EmailInfo;
import com.bns.model.Registration;
import com.bns.repository.EmailInfoRepository;
import com.bns.repository.RegistrationRepository;
import com.bns.utility.VerificationMailSendingCls;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository accOpeningRegRepository;
	
	@Autowired
	private VerificationMailSendingCls verificationMailSendingCls;
	
	@Autowired
	private EmailInfoRepository accOpeningEmailInfoRepository;	
	
	public Registration createAccount(Registration accOpeningReg) throws Exception {
		System.out.println("inside createAccount sequence is:"+accOpeningReg.getAccountOpeningRegInfoId());
		boolean isMailSend = false;
		String returnVal ="";
		//save Registration Details
		//AccOpeningReg returnObj = accOpeningRegRepository.save(accOpeningReg);
		Registration returnObj = null;
		EmailInfo teampAccOpeningEmailInfo = null; 
		EmailInfo accOpeningEmailInfo = new EmailInfo();
			
		accOpeningEmailInfo.setEmailVerified(false);
			accOpeningEmailInfo.setAccOpeningReg(accOpeningReg);
			teampAccOpeningEmailInfo = accOpeningEmailInfoRepository.save(accOpeningEmailInfo);
			returnObj = teampAccOpeningEmailInfo.getAccOpeningReg();
			//accOpeningReg.setAccOpeningEmailInfo(accOpeningEmailInfo);
			//returnObj = accOpeningRegRepository.save(accOpeningReg);
			
		//Send Mail
		isMailSend = verificationMailSendingCls.sendMailFunc(returnObj.getRegEmailAddress(), returnObj.getAccountOpeningRegInfoId(),false);
		if(isMailSend) {
			returnVal ="Email verification mail is send to your email id please verify it :"+returnObj.getAccountOpeningRegInfoId();
		}else {
			returnVal ="Exception while email sending please try again";
		}
		
		return accOpeningReg;
	}
}

//GenerateOracleSequence
