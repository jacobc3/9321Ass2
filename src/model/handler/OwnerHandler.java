package model.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Booking;
import model.bean.Cinema;
import model.bean.Movie;
import model.bean.Owner;
import model.bean.User;
import model.handlerInterface.OwnerHandlerInterface;

public class OwnerHandler implements OwnerHandlerInterface{

	public OwnerHandler() {
	}

	
	public boolean isExist(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Owner c = (Owner)session.get(Owner.class, id);	
		session.getTransaction().commit();
		session.close();
		if(c!=null){
			return true;
		} 
		return false;
	}

	
	public boolean isExist(String username) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		String sql = "select id from owner where username LIKE '"+username+"'";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		if(data.size()>0){
			return true;
		}
		return false;
	}

	
	public boolean isMatch(String username, String password) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		String sql = "select id from owner where username LIKE '"+username+"'"+"and password LIKE '"+password+"'";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		if(data.size()>0){
			return true;
		}
		return false;
	}


	
	public void approveBooking(int bookingId) {
		new BookingHandler().approveBooking(bookingId);
	}


	
	public void declineBooking(int bookingId) {
		new BookingHandler().declineBooking(bookingId);
	}


	
	public int addCinema(Cinema cinema) {
		return new CinemaHandler().addCinema(cinema);
	}


	
	public void updateCinema(Cinema cinema) {
		new CinemaHandler().updateCinema(cinema);
	}


	
	public void setReleaseDate(int movieId, Date date) {
		new MovieHandler().setReleaseDate(movieId, date);
	}

	
	public Owner getOwnerByUsername(String username) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select * FROM owner where username=\""+username+"\"";
//		System.out.println("username is "+username);
		System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql).addEntity(Owner.class);
		List<Owner> list = query.list();
//		System.out.println(list.size());
		return list.get(0);
	}

	
	public Owner getOwnerById(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Owner u = (Owner)session.get(Owner.class, id);		
		session.getTransaction().commit();
		session.close();
		return u;
	}

}
