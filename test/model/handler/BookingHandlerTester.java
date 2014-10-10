package model.handler;

import static org.junit.Assert.*;

import java.util.List;

import model.bean.Booking;
import model.bean.OrderStatus;
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
	public void getALlBooking(){
		List<Booking> bs = bh.getAllBookings();
		for(Booking b : bs){
			System.out.println(b.getId());
		}
		
		bs = bh.getBookingsByStatus(OrderStatus.Processing);
		for(Booking b : bs){
			System.out.println(b.getId()+" "+b.getStatus());
		}
		
		
		
	}
//	@Test
	public void approveBooking() {
		bh.approveBooking(3);
		bh.declineBooking(4);
	}

	
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
