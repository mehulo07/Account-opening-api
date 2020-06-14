package com.bns.controller;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bns.config.JwtTokenUtil;
import com.bns.model.EmailInfo;
import com.bns.model.JwtResponse;
import com.bns.model.Registration;
import com.bns.model.RegistrationUserDetails;
import com.bns.model.VerificationToken;
import com.bns.repository.EmailInfoRepository;
import com.bns.repository.RegistrationRepository;
import com.bns.repository.VerificationTokenRepository;
import com.bns.service.EmailInfoService;
import com.bns.service.EmailService;
import com.bns.utility.EncryptionDecryptionUtility;

import net.sf.json.JSONObject;

@RestController
@CrossOrigin
@PropertySource(value = "classpath:cipher.properties", ignoreResourceNotFound = true)
@RequestMapping("/v1/openAccount")
public class EmailController {

	@Autowired
	private EmailInfoService accOpeningEmailInfoService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private Environment env;

	@Autowired
	private EmailInfoRepository accOpeningEmailInfoRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	
	@Autowired
	private RegistrationRepository accOpeningRegRepository;

	@Autowired
	private JwtAuthenticationController jwtAuthenticationController;

	@GetMapping("/verifyEmail")
	public String validateAccountMail(@RequestParam(name = "key") String key) {
		String accRegId;
		System.out.println("Key is :" + key);
		accRegId = EncryptionDecryptionUtility.decrypt(String.valueOf(key), env.getProperty("cipherkey"));

		return accOpeningEmailInfoService.verifyAccEmailAddress(accRegId);
	}

	@GetMapping("/resendEmail")
	public ResponseEntity<?> resendVerificationLink(@RequestParam(name = "id") Integer id,
			@RequestParam(name = "url") String url,@RequestParam(name = "mailadd") String mailadd) {

		return emailService.resendEmailService(id, url,mailadd);
	}

	@GetMapping("/checkEmailVerify/{id}")
	public Response checkEmailVerify(@PathVariable(value = "id") String accRegId) throws Exception {
		EmailInfo accOpeningEmailInfo = accOpeningEmailInfoRepository
				.findByReferanceIdCheckVerify(Long.valueOf(accRegId));
		JSONObject json = new JSONObject();

		if (accOpeningEmailInfo == null) {

			json.put("EmailInfo", accOpeningEmailInfo);
			json.put("Message", "Your Email address is not verified.");
			return Response.status(Status.NOT_FOUND).entity(json).build();
		} else {

			json.put("EmailInfo", accOpeningEmailInfo);
			json.put("Message", "Your Email address is verified.");
			return Response.status(Status.OK).entity(json).build();
		}

	}

	@GetMapping("/checkVerficationEmail")
	public ResponseEntity<?> checkVerficationEmail(@RequestParam(value = "id") Integer accRegId,
			@RequestParam(value = "key") String key, @RequestParam(value = "email") String email,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Registration accOpeningReg = accOpeningRegRepository.findById(accRegId).get();
		VerificationToken verificationToken = verificationTokenRepository.findByaccRegId(accRegId);

		if (LocalDateTime.now().isAfter(verificationToken.getExpToken())) {
			JSONObject json = new JSONObject();
			json.put("Status", 409);
			json.put("Message", "Your Token is Expired");
			return ResponseEntity.status(409).body(json);

		} else {

			if (verificationToken.getTempToken().equals(key)) {
				try {

					JSONObject json = new JSONObject();

					System.out.println("accRegId is :" + accRegId);
					EmailInfo accOpeningEmailInfo = accOpeningEmailInfoRepository
							.findByReferanceId(Long.valueOf(accRegId));

					if (!accOpeningEmailInfo.isEmailVerified()) {
						accOpeningEmailInfo.setEmailVerified(true);
						if (accOpeningEmailInfo != null) {
							accOpeningEmailInfoRepository.save(accOpeningEmailInfo);
						}
						json.put("Status", 200);
						json.put("Message", "Your Email address is verified");

						return jwtAuthenticationController.generateAuthenticationToken(
								accOpeningReg.getRegEmailAddress(), accOpeningReg.getRegPassword());

					} else {
						json.put("Status", 200);
						json.put("Message", "Your email address is already verified");
						return ResponseEntity.status(200).body(json);

					}
				} catch (Exception e) {
					e.printStackTrace();
					JSONObject json = new JSONObject();
					System.out.println("No registration found on this email.");
					json.put("Status", 401);
					json.put("Message", "No registration found on this email.");

					return ResponseEntity.status(401).body(json);

				}

			} else {

				JSONObject json = new JSONObject();
				json.put("Status", 409);
				json.put("Message", "Your Token is Expired");
				return ResponseEntity.status(409).body(json);

			}

		}

	}

}
