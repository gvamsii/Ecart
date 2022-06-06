package com.ecart.miracle.Services;



import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;


@Service
public class MailService {

	
	//This method is for sending mail to verify the mail for user registration, forgot password, and send confirmation message. 
	public boolean sendingMail(String mail, String content) {
		// smtp means simple mail transfer protocol

		Properties prop = new Properties(); 
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");// mapi.miraclesoft.com//smtp.gmail.com -----
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.starttls.enable", "true");
		// after writing the code error will clears
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {  
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ekartmss@gmail.com", "lauxvrkcrgtrazcr");//pending hide
			}
		});
		 
		try {
			Message msg = new MimeMessage(session);
			// here false for normal mails like
			// internetAdderss("ppolisetti@miracle.com",false);
			msg.setFrom(new InternetAddress("ekartmss@gmail.com", false));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			msg.addRecipient(RecipientType.CC,new InternetAddress(null, null));
			msg.setSubject("Verification mail");
			msg.setHeader("To test the code", "text/html");
			msg.setSentDate(new Date());
			MimeBodyPart messageBody = new MimeBodyPart();
			messageBody.setContent(content, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBody);
			MimeBodyPart attachedpart = new MimeBodyPart();
			attachedpart.attachFile("C:\\Users\\vguntamukkala\\Desktop\\logo.jpg");
			multipart.addBodyPart(attachedpart);
			msg.setContent(multipart);
			Transport.send(msg);
//		    	    Transport tr = session.getTransport("smtp");
//		          tr.connect("mapi.miraclesoft.com", "plaadi@miraclesoft.com", "Praveen303@");
//		          msg.saveChanges();
//		          tr.sendMessage(msg, msg.getAllRecipients());
//		          tr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	

	
	

}
