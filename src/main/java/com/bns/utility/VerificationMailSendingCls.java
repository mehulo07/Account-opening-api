package com.bns.utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({@PropertySource(value = "classpath:cipher.properties" , ignoreResourceNotFound = true),
	@PropertySource(value = "classpath:mailConfig.properties" , ignoreResourceNotFound = true)})
public class VerificationMailSendingCls {
	
	@Autowired
	private static Environment env;
	
	
	static public boolean sendMailFunc(String reciverMail, int uniqueId) {
		boolean returnVal = false;
		String mailKey = "";
		final String mailValidationURL = "http://localhost:8080/verifyEmail?key=";
		String preparedMailValidationURL = "";
		System.out.println("reciverMail is :" + reciverMail);

		Properties props = new Properties();
		props.put("mail.smtp.auth",env.getProperty("mail.auth"));
		props.put("mail.smtp.starttls.enable", env.getProperty("mail.starttls"));
		props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
		props.put("mail.smtp.port", env.getProperty("mail.port"));

		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(env.getProperty("mail.from"), env.getProperty("mail.from.password"));
				}
			});

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("mehulmakwana339@gmail.com", false));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciverMail));
			msg.setSubject("Account Creation with BNS Distribution");
			msg.setContent("Please verify your email id via click link Below Unique id is :" + uniqueId, "text/html");
			msg.setSentDate(new Date());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			mailKey = EncryptionDecryptionUtility.encrypt(String.valueOf(uniqueId), env.getProperty("cipherkey"));
			preparedMailValidationURL = mailValidationURL + mailKey;

			String sendMessage = "<a \"target=\"_blank\" href=" + preparedMailValidationURL
					+ ">Validate Email Address</a>";
			messageBodyPart.setContent(sendMessage, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachPart = new MimeBodyPart();

			/*
			 * attachPart.attachFile("images/DEMO.PNG"); multipart.addBodyPart(attachPart);
			 */
			msg.setContent(multipart);
			Transport.send(msg);
			returnVal = true;
			System.out.println("Email sent");

		} catch (Exception e) {
			returnVal = false;
			e.printStackTrace();
			System.out.println("Exception while sending mail");
		}

		return returnVal;
	}

}
