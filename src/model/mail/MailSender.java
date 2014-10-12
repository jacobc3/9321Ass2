package model.mail;

import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.bean.Booking;
import model.bean.OrderStatus;
import model.bean.User;
 
public class MailSender{
	public void sendActivationMail(User user){		
		Properties props = new Properties();
		props.put("mail.smtp.host", "just67.justhost.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("admin@sensitiver.com","Jacobc3z");
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("admin@sensitiver.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(user.getEmail()));
			message.setSubject("Activiation mail on Movie Website");
			String content="Dear "+user.getUsername()+":<br>"
					+"    please use this to activate your account </br>"
					+"http://localhost:8080/9321Ass2/activate?user_id="+user.getId()+"</br>";
			message.setContent(content, "text/html");
			System.out.println("Sending mail to "+user.getEmail());
			System.out.println("content:"+content);			
			Transport.send(message); 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void sendBookingStatusMail(Booking b){
		Properties props = new Properties();
		props.put("mail.smtp.host", "just67.justhost.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("admin@sensitiver.com","Jacobc3z");
				}
			});
 
		try { 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("admin@sensitiver.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(b.getUser().getEmail()));
			
			
			message.setSubject("Your Booking status on Movie Website Has been changed");
			String content = "Dear user "+b.getUser().getUsername()+":<br>"
					+"Your booking with id "+b.getId()+" 's status has been changed to <b>"+b.getStatus()+"</b>.";
			message.setContent(content, "text/html");
			System.out.println("Sending mail to "+b.getUser().getEmail());
			System.out.println("content:"+content);	
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}