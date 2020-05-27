package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.exception.ResourceNotFoundException;
import com.bns.model.AccOpeningEmailInfo;
import com.bns.model.AccOpeningReg;
import com.bns.repository.AccOpeningEmailInfoRepository;
import com.bns.repository.AccOpeningRegRepository;
import com.bns.utility.VerificationMailSendingCls;

@Service
public class AccOpeningRegService {

	@Autowired
	private AccOpeningRegRepository accOpeningRegRepository;
	
	@Autowired
	private VerificationMailSendingCls verificationMailSendingCls;
	
	@Autowired
	private AccOpeningEmailInfoRepository accOpeningEmailInfoRepository;	
	
	public String createAccount(AccOpeningReg accOpeningReg) throws Exception {
		System.out.println("inside createAccount sequence is:"+accOpeningReg.getAccountOpeningRegInfoId());
		boolean isMailSend = false;
		String returnVal ="";
		//save Registration Details
		//AccOpeningReg returnObj = accOpeningRegRepository.save(accOpeningReg);
		AccOpeningReg returnObj = null;
		
		AccOpeningEmailInfo accOpeningEmailInfo = new AccOpeningEmailInfo();
			
			accOpeningEmailInfo.setAccOpeningReg(accOpeningReg);
			accOpeningEmailInfoRepository.save(accOpeningEmailInfo);
			
			/*accOpeningEmailInfo.setEmailVerified(false);
			accOpeningReg.setAccOpeningEmailInfo(accOpeningEmailInfo);
			*/
			returnObj = accOpeningRegRepository.save(accOpeningReg);
			
		//Send Mail
		isMailSend = verificationMailSendingCls.sendMailFunc(returnObj.getRegEmailAddress(), returnObj.getAccountOpeningRegInfoId());
		if(isMailSend) {
			returnVal ="Email verification mail is send to your email id please verify it :"+returnObj.getAccountOpeningRegInfoId();
		}else {
			returnVal ="Exception while email sending please try again";
		}
		
		return returnVal;
	}
}

//GenerateOracleSequence
