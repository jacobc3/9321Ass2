package model.handler;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import model.bean.Booking;
import model.bean.Movie;
import model.bean.User;
import model.handlerInterface.MovieHandlerInterface;
import model.handlerInterface.UserHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class UserHandlerTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public UserHandlerInterface mh = new UserHandler();

	@BeforeClass
	public static void beforeClass() {
	}
	
	@Test
	public void senConfirmMailTester(){
		User u = mh.getUserById(13);
		System.out.println("id is " + u.getId()+"\nemail is "+u.getEmail());
		mh.sendConfirmMail(u);
	}

	// @Test
	public void newUserTest() {
		User u = new User("abc", "abc@abc.com");
		int id = mh.addUser(u);
		System.out.println("id is " + id);
	}

//	@Test
	public void getBookingsByUserTester() {
		List<Booking> bs = mh.getBookingsByUser(1);
		for (Iterator iterator = bs.iterator(); iterator.hasNext();) {
			Booking b = (Booking) iterator.next();
			System.out.println("id " + b.getId());
		}
	}
//	@Test
	public void getUserByBooking(){
		User u = mh.getUserByBooking(37);
		System.out.println("id " + u.getId());
		u = mh.getUserByBooking(2);
		System.out.println("id " + u.getId());
		
	}
	
//	@Test
	public void getUserByReview(){
		User u = mh.getUserByReview(3);
		System.out.println("id " + u.getId());
		u = mh.getUserByReview(5);
		System.out.println("id " + u.getId());
	}

	// @Test
	public void isExist() {
		String o = "user9";
		System.out.println(o + "\t " + mh.isExist(o));

		o = "user";
		System.out.println(o + "\t " + mh.isExist(o));

		String o2 = "user10";
		String password = "pass";
		System.out.println(o2 + "\t " + password + "\t"
				+ mh.isMatch(o2, password));

		o2 = "user9";
		System.out.println(o2 + "\t " + password + "\t"
				+ mh.isMatch(o2, password));

		int i = 9;
		System.out.println(i + "\t " + mh.isExist(i));

	}

	// @Test
	public void updateUserTest() {
		User u = mh.getUserById(10);
		u.setEmailOk(true);
		mh.updateUser(u);
		User u2 = mh.getUserById(10);
		System.out
				.println("id is " + u2.getId() + " emaail? " + u2.isEmailOk());
	}

	// @Test
	public void alltest() {
		List<User> ms = mh.getAllUsers();
		for (User m : ms) {
			System.out.println(m.getEmail() + "\t" + m.getUsername() + "\t");
		}
	}

	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
