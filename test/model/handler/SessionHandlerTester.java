package model.handler;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import model.bean.Booking;
import model.bean.Movie;
import model.bean.Review;
import model.bean.Session;
import model.bean.User;
import model.handlerInterface.CinemaHandlerInterface;
import model.handlerInterface.MovieHandlerInterface;
import model.handlerInterface.ReviewHandlerInterface;
import model.handlerInterface.SessionHandlerInterface;
import model.handlerInterface.UserHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class SessionHandlerTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public ReviewHandlerInterface rh =  new ReviewHandler();
	public UserHandlerInterface uh =  new UserHandler();
	public MovieHandlerInterface mh =  new MovieHandler();
	public SessionHandlerInterface sh =  new SessionHandler();
	public CinemaHandlerInterface ch =  new CinemaHandler();
	
	@BeforeClass
	public static void beforeClass() {
	}
	
	
	@Test
	public void getBookingsBySessionTester(){
		List<Booking> bs = sh.getBookingsBySession(3);
		for (Iterator iterator = bs.iterator(); iterator.hasNext();) {
			Booking b = (Booking) iterator.next();
			System.out.println("b id " + b.getId());
		}
		
		
		Session s = sh.getSessionByBooking(12);
		System.out.println("s id " + s.getId());

	}
	
//	@Test
	public void getMoviebySession(){
		Movie movie = sh.getMovieBySession(3);
			System.out.println(movie.getId());
	}
//	@Test
	public void getSessionsbyMovieTest(){
		List<Session> ss = sh.getSessionsByMovie(1);
		for(Session s: ss){
			System.out.println(s.getId());
		}
	}
	
//	@Test
	public void updateTest(){
		Session ns = sh.getSession(1);
		System.out.println(ns.getId()+"c "+ns.getCinema().getId()+"\tm "+ns.getMovie().getId());
		ns.setCinema(ch.getCinema(9));
		System.out.println(ns.getId()+"c "+ns.getCinema().getId()+"\tm "+ns.getMovie().getId());
		sh.updateSession(ns);
	}
	
//	@Test
	public void newtest(){
		Session s = new Session(mh.getMovie(1),ch.getCinema(1));
		int id  = sh.addSession(s);
		System.out.println("id is "+ id);
		
		Session ns = sh.getSession(id);
		ns.setCinema(ch.getCinema(9));
		sh.updateSession(s);
	}
	
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
