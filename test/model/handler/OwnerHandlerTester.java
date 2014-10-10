package model.handler;

import java.util.List;

import model.bean.Booking;
import model.bean.Review;
import model.bean.User;
import model.handlerInterface.MovieHandlerInterface;
import model.handlerInterface.OwnerHandlerInterface;
import model.handlerInterface.ReviewHandlerInterface;
import model.handlerInterface.UserHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class OwnerHandlerTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public ReviewHandlerInterface rh =  new ReviewHandler();
	public OwnerHandlerInterface oh =  new OwnerHandler();
	public MovieHandlerInterface mh =  new MovieHandler();
	
	@BeforeClass
	public static void beforeClass() {
	}
	
	
	@Test
	public void getBookingsByOwnerTest(){
//		List<Booking> bs = oh.getBookingsByOwner(1);
//		for(Booking b: bs){
//			System.out.println(b.getId()+"\tcinema:"+b.getSession().getCinema().getId());
//		}
	}

//	@Test
	public void isOwnerExistTest() {
		String o = "owner1";
		System.out.println(o+"\t "+oh.isExist(o));
		
		o = "owner";
		System.out.println(o+"\t "+oh.isExist(o));
		
		String o2 = "owner3";
		String password = "pass";
		System.out.println(o2+"\t "+password+"\t"+oh.isMatch(o2, password));
		
		o2 = "owner2";
		System.out.println(o2+"\t "+password+"\t"+oh.isMatch(o2, password));
	}
	
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}


}
