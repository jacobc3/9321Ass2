package model.handler;

import static org.junit.Assert.*;
import model.handlerInterface.BookingHandlerInterface;
import model.handlerInterface.MovieHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class BookingHandlerTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public BookingHandlerInterface bh =  new BookingHandler();
	@BeforeClass
	public static void beforeClass() {
	}
	
	
	@Test
	public void approveBooking() {
		bh.approveBooking(3);
		bh.declineBooking(4);
	}

	
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
