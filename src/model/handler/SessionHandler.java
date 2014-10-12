package model.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Booking;
import model.bean.Cinema;
import model.bean.Movie;
import model.bean.OrderStatus;
import model.bean.Review;
import model.bean.Session;
import model.handlerInterface.SessionHandlerInterface;

public class SessionHandler implements SessionHandlerInterface {

	public SessionHandler() {
	}


	
	public Session getSession(int session_id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		Session m = (Session)session.get(Session.class, session_id);		
		session.getTransaction().commit();
		session.close();
		return m;
	}

	
	public void updateSession(Session mySession) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		session.update(mySession);;		
		session.getTransaction().commit();
		session.close();
	}

	
	public int addSession(Session mySession) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(mySession);		
		session.getTransaction().commit();
		session.close();
		return id;
	}

	
	public List<Session> getSessionsByMovie(int movie_id) {
		return new MovieHandler().getSessionsByMovie(movie_id);
	}

	
	public List<Session> getSessionsByMovie(Movie movie) {
		return new MovieHandler().getSessionsByMovie(movie);
	}

	
	public Movie getMovieBySession(Session session) {
		return new MovieHandler().getMovieBySession(session);
	}

	
	public Movie getMovieBySession(int session_id) {
		return new MovieHandler().getMovieBySession(session_id);
	}

	
	public Session getSessionByBooking(Booking booking) {
		return this.getSessionByBooking(booking.getId());
	}

	
	public Session getSessionByBooking(int booking_id) {
		Booking b = new BookingHandler().getBooking(booking_id);
		return b.getSession();
	}

	
	public List<Booking> getBookingsBySession(Session session) {
		return this.getBookingsBySession(session.getId());
	}

	
	public List<Booking> getBookingsBySession(int session_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select * FROM booking where session_id="+session_id;
		SQLQuery query = session.createSQLQuery(sql).addEntity(Booking.class);
		List<Booking> data = query.list();
		return data;
	}

	
	public List<Session> getSessionsByCinema(Cinema cinema) {
		return new CinemaHandler().getSessionsByCinema(cinema);
	}

	
	public List<Session> getSessionsByCinema(int cinema_id) {
		return new CinemaHandler().getSessionsByCinema(cinema_id);
	}

	
	public Cinema getCinemaBySession(Session session) {
		return new CinemaHandler().getCinemaBySession(session);
	}

	
	public Cinema getCinemaBySession(int session_id) {
		return new CinemaHandler().getCinemaBySession(session_id);
	}
	
	
	public int getRemainingSeatsCount(int session_id) {
		int booked = this.getBookedSeatsCount(session_id);
		Cinema c = this.getCinemaBySession(session_id);
		int total = c.getCapacity();
		return (total-booked);
	}

	/**
	 * only count by approved+processing, not counting declined
	 */
	
	public int getBookedSeatsCount(int session_id) {
		List<Booking> bs = new SessionHandler().getBookingsBySession(session_id);
		int total = 0;
		for (java.util.Iterator<Booking> iterator = bs.iterator(); iterator.hasNext();) {
			Booking b = (Booking) iterator.next();
			if(b.getStatus()!=OrderStatus.Declined){
				total += b.getCount();
			}
		}
		return total;
	}


	/**
	 * must be run before add Booking
	 * @param session_id session's id
	 */
	
	public boolean okToBook(int session_id, int requestCount) {
		if(this.getRemainingSeatsCount(session_id) >= requestCount){
			return true;
		}
		return false;
	}

}
