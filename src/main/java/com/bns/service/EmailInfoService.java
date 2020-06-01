package com.bns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bns.model.EmailInfo;
import com.bns.repository.EmailInfoRepository;

@Service
public class EmailInfoService {

	@Autowired
	private EmailInfoRepository accOpeningEmailInfoRepository;
	
	public String verifyAccEmailAddress(String accRegId) {
		String retrunVal="Not validate";
		try {
			
			/*AccOpeningEmailInfo accOpeningEmailInfo =  accOpeningEmailInfoRepository.findById(Long.valueOf(accRegId))
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + accRegId));
			*/
			
			System.out.println("accRegId is :"+accRegId);
			EmailInfo accOpeningEmailInfo = accOpeningEmailInfoRepository.findByReferanceId(Long.valueOf(accRegId));
			
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
