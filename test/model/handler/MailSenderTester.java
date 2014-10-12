package model.handler;

import static org.junit.Assert.*;
import model.mail.MailSender;
import model.bean.Booking;
import model.bean.OrderStatus;
import model.bean.User;

import org.junit.Test;

public class MailSenderTester {

	@Test
	public void test() {
		MailSender ms = new MailSender();
		User u = new User();
		u.setUsername("testing_user");
		u.setEmail("jacobc3@gmail.com");
		u.setId(20);
//		ms.sendActivationMail(u);
//		
		
		Booking b = new Booking();
		b.setUser(u);
		b.setStatus(OrderStatus.Approved);
		b.setId(20);
		ms.sendBookingStatusMail(b);
	}

}
