package com.bns.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bns.model.Registration;
import com.bns.model.VerificationToken;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.VerificationTokenRepository;
import com.bns.utility.VerificationMailSendingCls;

import net.sf.json.JSONObject;

@Service
public class EmailService {

	@Autowired
	private RegistrationRepository accOpeningRegRepository;

	@Autowired
	private VerificationMailSendingCls verificationMailSendingCls;
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	public ResponseEntity<?> resendEmailService(Integer regId, String url, String mailadd) {
		Boolean returnVal = false;
		Registration accOpeningRegObject = accOpeningRegRepository.findById(regId).get();
		System.out.println("Resend Email Address is :" + accOpeningRegObject.getRegEmailAddress());

		Supplier<String> tokenSupplier = () -> {

			StringBuilder token = new StringBuilder();
			long currentTimeInMilisecond = Instant.now().toEpochMilli();
			return token.append(currentTimeInMilisecond).append("-").append(UUID.randomUUID().toString()).toString();
		};

		System.out.println("Create Temp Token" + tokenSupplier.get());

		VerificationToken verificationToken = verificationTokenRepository.findByaccRegId(regId);

		if (verificationToken.equals(null)) {

			VerificationToken vt = new VerificationToken();
			vt.setAccOpeningReg(accOpeningRegObject);
			vt.setTempToken(tokenSupplier.get());
			vt.setCreateToken(LocalDateTime.now());
			LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
			vt.setExpToken(tomorrow);
			System.out.println(tomorrow);
			verificationTokenRepository.save(vt);

		} else {
			VerificationToken vtupdate = new VerificationToken();
			vtupdate.setVerificationTokenTabId(verificationToken.getVerificationTokenTabId());
			vtupdate.setAccOpeningReg(verificationToken.getAccOpeningReg());
			vtupdate.setTempToken(tokenSupplier.get());
			vtupdate.setTempToken(tokenSupplier.get());
			vtupdate.setCreateToken(LocalDateTime.now());
			LocalDateTime tomorrow = LocalDateTime.now().plusDays(1);
			vtupdate.setExpToken(tomorrow);

			verificationTokenRepository.save(vtupdate);

		}

		returnVal = verificationMailSendingCls.sendMailFuncNewOne(accOpeningRegObject.getRegEmailAddress(), regId, true,
				url,tokenSupplier.get());
		String t = "Email sent";

		if (returnVal) {
			JSONObject json = new JSONObject();
			json.put("status", 200);
			json.put("Message", "Email sent successfully.");

			return ResponseEntity.ok().body(json);
		} else {
			JSONObject json = new JSONObject();
			json.put("status", 500);
			json.put("Message", HttpStatus.INTERNAL_SERVER_ERROR);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
		}
	}

}
