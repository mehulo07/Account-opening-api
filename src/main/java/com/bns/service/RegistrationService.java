package com.bns.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bns.model.EmailInfo;
import com.bns.model.Registration;
import com.bns.model.VerificationToken;
import com.bns.repository.EmailInfoRepository;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.VerificationTokenRepository;
import com.bns.utility.VerificationMailSendingCls;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository accOpeningRegRepository;

	@Autowired
	private VerificationMailSendingCls verificationMailSendingCls;

	@Autowired
	private EmailInfoRepository accOpeningEmailInfoRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	public Registration createAccount(Registration accOpeningReg, String url) throws Exception {
		System.out.println("inside createAccount sequence is:" + accOpeningReg.getAccountOpeningRegInfoId());
		boolean isMailSend = false;
		String returnVal = "";
		// save Registration Details
		// AccOpeningReg returnObj = accOpeningRegRepository.save(accOpeningReg);
		Registration returnObj = null;
		EmailInfo teampAccOpeningEmailInfo = null;
		EmailInfo accOpeningEmailInfo = new EmailInfo();

		accOpeningEmailInfo.setEmailVerified(false);
		accOpeningEmailInfo.setAccOpeningReg(accOpeningReg);
		teampAccOpeningEmailInfo = accOpeningEmailInfoRepository.save(accOpeningEmailInfo);
		returnObj = teampAccOpeningEmailInfo.getAccOpeningReg();

		Supplier<String> tokenSupplier = () -> {

			StringBuilder token = new StringBuilder();
			long currentTimeInMilisecond = Instant.now().toEpochMilli();
			return token.append(currentTimeInMilisecond).append("-").append(UUID.randomUUID().toString()).toString();
		};

		
		VerificationToken vt = new VerificationToken();
		vt.setAccOpeningReg(accOpeningReg);
		vt.setTempToken(tokenSupplier.get());
		vt.setCreateToken(LocalDateTime.now());
		LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
		vt.setExpToken(tomorrow);
		System.out.println(tomorrow);
		verificationTokenRepository.save(vt);
		System.out.println("Create Temp Token " + vt.getTempToken());
		

		// accOpeningReg.setAccOpeningEmailInfo(accOpeningEmailInfo);
		// returnObj = accOpeningRegRepository.save(accOpeningReg);

		// Send Mail
		isMailSend = verificationMailSendingCls.sendMailFuncNewOne(returnObj.getRegEmailAddress(),
				returnObj.getAccountOpeningRegInfoId(), false, url, vt.getTempToken());
		
		if (isMailSend) {
			returnVal = "Email verification mail is send to your email id please verify it :"
					+ returnObj.getAccountOpeningRegInfoId();
		} else {
			returnVal = "Exception while email sending please try again";
		}

		return accOpeningReg;
	}

}

//GenerateOracleSequence
