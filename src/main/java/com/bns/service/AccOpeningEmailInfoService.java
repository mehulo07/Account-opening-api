package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.AccOpeningEmailInfo;
import com.bns.repository.AccOpeningEmailInfoRepository;

@Service
public class AccOpeningEmailInfoService {

	@Autowired
	private AccOpeningEmailInfoRepository accOpeningEmailInfoRepository;
	
	public String verifyAccEmailAddress(String accRegId) {
		String retrunVal="Not validate";
		try {
			
			/*AccOpeningEmailInfo accOpeningEmailInfo =  accOpeningEmailInfoRepository.findById(Long.valueOf(accRegId))
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + accRegId));
			*/
			
			System.out.println("accRegId is :"+accRegId);
			AccOpeningEmailInfo accOpeningEmailInfo = accOpeningEmailInfoRepository.findAllByReferanceId(Long.valueOf(accRegId));
			
			System.out.println("accOpeningEmailInfo is :"+accOpeningEmailInfo);
			
			if(!accOpeningEmailInfo.isEmailVerified()) {
				accOpeningEmailInfo.setEmailVerified(true);
				if(accOpeningEmailInfo != null) {
					accOpeningEmailInfoRepository.save(accOpeningEmailInfo);
				}
				retrunVal ="Your Email address is verified.";
			}else {
				retrunVal ="Your email address is already verified.";
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("No registration found on this email.");
		}
		
		return retrunVal;
	}
}
