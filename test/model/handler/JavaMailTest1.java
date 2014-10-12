package model.handler;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import model.bean.User;

public class JavaMailTest1 {
	public static void main(String[] args) {
		send4();
	}

	public void send1() throws MessagingException {
		Properties props = new Properties();
		// 开启debug调试
		props.setProperty("mail.debug", "true");
		// 发送服务器需要身份验证
		props.setProperty("mail.smtp.auth", "true");
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "smtp.163.com");
		// 发送邮件协议名称
		props.setProperty("mail.transport.protocol", "smtp");

		// 设置环境信息
		Session session = Session.getInstance(props);

		// 创建邮件对象
		Message msg = new MimeMessage(session);
		msg.setSubject("JavaMail测试");
		// 设置邮件内容
		msg.setText("这是一封由JavaMail发送的邮件！");
		// 设置发件人
		msg.setFrom(new InternetAddress("java_mail_001@163.com"));

		Transport transport = session.getTransport();
		// 连接邮件服务器
		transport.connect("java_mail_001", "javamail");
		// 发送邮件
		transport.sendMessage(msg, new Address[] { new InternetAddress(
				"jacobc3@gmail.com") });
		// 关闭连接
		transport.close();
	}

	public static void send2() {
		// Recipient's email ID needs to be mentioned.
		String to = "abcd@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "web@gmail.com";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void mail3(){
		final String username = "jacobc3@gmail.com";
		final String password = "jacobc3!!";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("jacobc3@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("jacobc3@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void send4(){
		
		User u = new User();
		u.setUsername("testing_user");
		u.setEmail("jacobc3@gmail.com");
		u.setId(20);
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
					InternetAddress.parse("jacobc3@Gmail.com"));
			message.setSubject("Activiation mail on Movie Website");
			
			
			String content="Dear user "+u.getUsername()+":<br>"
					+"    please use to activate your account</br>"
					+"http://localhost:8080/9321Ass2/activate?user_id="+u.getId();
			
			
			message.setContent(content, "text/html");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}