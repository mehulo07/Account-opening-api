package com.bns.utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySources({@PropertySource(value = "classpath:cipher.properties"),
	@PropertySource(value = "classpath:mailConfig.properties")})
public class VerificationMailSendingCls {
	
	@Autowired
	private Environment env;
	
	 public boolean sendMailFunc(String reciverMail, int uniqueId , boolean resendFlag) {
		boolean returnVal = false;
		String mailKey = "";
		final String mailValidationURL = "http://localhost:8080/verifyEmail?key=";
		final String resendMailValidationURL ="http://localhost:8080/resendEmail?key=";
		System.out.println("Application COntext path is TEMPDIR :"+ApplicationContext.TEMPDIR);
		String preparedMailValidationURL = "";
		String preparedResendMailValidationURL = "";
		
		System.out.println("reciverMail is :" + reciverMail);
		Properties props = new Properties();
		System.out.println("mail address is :"+props.getProperty("mail.auth"));
		System.out.println();
		
		if(env == null) {
			System.out.println("Environment is null");
		}else {
			System.out.println("ENV is not null");
		}
		
		System.out.println("email address is :"+env.getProperty("mail.auth"));
		
		try {
			props.put("mail.smtp.auth",env.getProperty("mail.auth"));
			props.put("mail.smtp.starttls.enable", env.getProperty("mail.starttls"));
			props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
			props.put("mail.smtp.port", env.getProperty("mail.port"));

		}catch(Exception e) {
			System.out.println("Exception while getData");
			e.printStackTrace();
		}


		System.out.println("Stage 1 is done");
		
		try {
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					
					System.out.println("Address  :"+env.getProperty("mail.from.id") + " password is :"+env.getProperty("mail.from.password"));
					return new PasswordAuthentication(env.getProperty("mail.from.id"), env.getProperty("mail.from.password"));
				}
			});

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(env.getProperty("mail.from"), false));

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciverMail));
			if(resendFlag) {
				msg.setSubject("Resend : Account Creation with BNS Distribution ");
			}else {
				msg.setSubject("Account Creation with BNS Distribution");
			}

			msg.setContent("Please verify your email id via click link Below Unique id is :" + uniqueId, "text/html");
			msg.setSentDate(new Date());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			BodyPart bodyPart1=new MimeBodyPart();
			mailKey = EncryptionDecryptionUtility.encrypt(String.valueOf(uniqueId), env.getProperty("cipherkey"));
			preparedMailValidationURL = mailValidationURL + mailKey;
			preparedResendMailValidationURL = resendMailValidationURL + mailKey;
			
			String msgcontent="Hello,"
					+ " We’re almost done! click on the link below to verify your Email address,Expires in 24 hours";

			String sendMessage = "<a \"target=\"_blank\" href=" + preparedMailValidationURL
					+ "> Request a new verification email.</a>";
			
			
			String resendLink = "<br/> <a \"target=\"_blank\" href=" + preparedResendMailValidationURL 
					+ ">Click for Resend.</a>";
			
//			sendMessage += msgcontent;
			
			sendMessage += resendLink;
			
			bodyPart1.setText(msgcontent);
//			messageBodyPart.setContent(, "text/html");
			messageBodyPart.setContent(sendMessage, "text/html");
			
			

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(bodyPart1);
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
	 
	 public boolean sendMailFuncNew(String reciverMail, int uniqueId, boolean resendFlag, String url,String token) {
			boolean returnVal = false;
			String mailKey = "";
			final String mailValidationURL = url+"key="+token+"&id="+uniqueId+"&email="+reciverMail;
			final String resendMailValidationURL = url;
			System.out.println("Application COntext path is TEMPDIR :" + ApplicationContext.TEMPDIR);
			String preparedMailValidationURL = "";
			String preparedResendMailValidationURL = "";

			System.out.println("reciverMail is :" + reciverMail);
			Properties props = new Properties();
			System.out.println("mail address is :" + props.getProperty("mail.auth"));
			System.out.println();

			if (env == null) {
				System.out.println("Environment is null");
			} else {
				System.out.println("ENV is not null");
			}

			System.out.println("email address is :" + env.getProperty("mail.auth"));

			try {
				props.put("mail.smtp.auth", env.getProperty("mail.auth"));
				props.put("mail.smtp.starttls.enable", env.getProperty("mail.starttls"));
				props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
				props.put("mail.smtp.port", env.getProperty("mail.port"));

			} catch (Exception e) {
				System.out.println("Exception while getData");
				e.printStackTrace();
			}

			System.out.println("Stage 1 is done");

			try {
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {

						System.out.println("Address  :" + env.getProperty("mail.from.id") + " password is :"
								+ env.getProperty("mail.from.password"));
						return new PasswordAuthentication(env.getProperty("mail.from.id"),
								env.getProperty("mail.from.password"));
					}
				});

				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(env.getProperty("mail.from"), false));

				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciverMail));
				if (resendFlag) {
					msg.setSubject("Resend : Account Creation with BNS Distribution ");
				} else {
					msg.setSubject("Account Creation with BNS Distribution");
				}

				msg.setContent("Please verify your email id via click link Below Unique id is :" + uniqueId, "text/html");
				msg.setSentDate(new Date());

				MimeBodyPart messageBodyPart = new MimeBodyPart();
				BodyPart bodyPart1 = new MimeBodyPart();
				mailKey = EncryptionDecryptionUtility.encrypt(String.valueOf(uniqueId), env.getProperty("cipherkey"));
				preparedMailValidationURL = mailValidationURL;
				preparedResendMailValidationURL = resendMailValidationURL;

				String msgcontent = "Hello,"
						+ " We’re almost done! click on the link below to verify your Email address,Expires in 24 hours";

				String sendMessage = "<a \"target=\"_blank\" href=" + preparedMailValidationURL
						+ "> Request a new verification email.</a>";

				String resendLink = "<br/> <a \"target=\"_blank\" href=" + preparedResendMailValidationURL
						+ ">Click for Resend.</a>";

//				sendMessage += msgcontent;

				sendMessage += resendLink;

				bodyPart1.setText(msgcontent);
//				messageBodyPart.setContent(, "text/html");
				messageBodyPart.setContent(sendMessage, "text/html");

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(bodyPart1);
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

	 
	 public boolean sendMailFuncNewOne(String reciverMail, int uniqueId, boolean resendFlag, String url,String token) {
			boolean returnVal = false;
			String mailKey = "";
			
//			System.out.print("mail:"+token);
			final String mailValidationURL = url+"key="+token+"&id="+uniqueId+"&email="+reciverMail;
			final String resendMailValidationURL = url;
			System.out.println("Application COntext path is TEMPDIR :" + ApplicationContext.TEMPDIR);
			String preparedMailValidationURL = "";
			String preparedResendMailValidationURL = "";

			System.out.println("reciverMail is :" + reciverMail);
			Properties props = new Properties();
			System.out.println("mail address is :" + props.getProperty("mail.auth"));
			System.out.println();

			if (env == null) {
				System.out.println("Environment is null");
			} else {
				System.out.println("ENV is not null");
			}

			System.out.println("email address is :" + env.getProperty("mail.auth"));

			try {
				props.put("mail.smtp.auth", env.getProperty("mail.auth"));
				props.put("mail.smtp.starttls.enable", env.getProperty("mail.starttls"));
				props.put("mail.smtp.host", env.getProperty("mail.smtp.host"));
				props.put("mail.smtp.port", env.getProperty("mail.port"));

			} catch (Exception e) {
				System.out.println("Exception while getData");
				e.printStackTrace();
			}

			System.out.println("Stage 1 is done");

			try {
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {

						System.out.println("Address  :" + env.getProperty("mail.from.id") + " password is :"
								+ env.getProperty("mail.from.password"));
						return new PasswordAuthentication(env.getProperty("mail.from.id"),
								env.getProperty("mail.from.password"));
					}
				});

				Message msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(env.getProperty("mail.from"), false));

				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciverMail));
				if (resendFlag) {
					msg.setSubject("Resend : Account Creation with BNS Distribution ");
				} else {
					msg.setSubject("Account Creation with BNS Distribution");
				}

				msg.setContent("Please verify your email id via click link Below Unique id is :" + uniqueId, "text/html");
				msg.setSentDate(new Date());

				MimeBodyPart messageBodyPart = new MimeBodyPart();
				BodyPart bodyPart1 = new MimeBodyPart();
				mailKey = EncryptionDecryptionUtility.encrypt(String.valueOf(uniqueId), env.getProperty("cipherkey"));
				preparedMailValidationURL = mailValidationURL;
				preparedResendMailValidationURL = resendMailValidationURL;

				String msgcontent = "Hello,"
						+ " We’re almost done! click on the link below to verify your Email address,Expires in 24 hours";

				String sendMessage = "<a \"target=\"_blank\" href=" + preparedMailValidationURL
						+ "> Request a new verification email.</a>";

				String resendLink = "<br/> <a \"target=\"_blank\" href=" + preparedResendMailValidationURL
						+ ">Click for Resend.</a>";

//				sendMessage += msgcontent;

				sendMessage += resendLink;

				bodyPart1.setText(msgcontent);
//				messageBodyPart.setContent(, "text/html");
				messageBodyPart.setContent(sendMessage, "text/html");

				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(bodyPart1);
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
