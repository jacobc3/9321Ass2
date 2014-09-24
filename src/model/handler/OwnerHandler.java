package model.handler;

import java.util.ArrayList;
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
	

	@Override
	public int addOwner(Owner owner) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(owner);		
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public Owner getOwnerById(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Owner o = (Owner)session.get(Owner.class, id);		
		session.getTransaction().commit();
		session.close();
		return o;
	}

	@Override
	public List<Owner> getAllOwners() {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		List<Owner> owners = session.createQuery("FROM Owner").list();
		session.getTransaction().commit();
		session.close();
		return owners;
	}

	@Override
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

	@Override
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

	@Override
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


	@Override
	public void updateOwner(Owner owner) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(owner);		
		session.getTransaction().commit();
		session.close();
	}


	@Override
	public Owner getOwnerByCinema(Owner owner) {
		return new CinemaHandler().getOwnerByCinema(owner);
	}


	@Override
	public Owner getOwnerByCinema(int owner_id) {
		return new CinemaHandler().getOwnerByCinema(owner_id);
	}


	@Override
	public List<Cinema> getCinemasByOwner(Owner owner) {
		return new CinemaHandler().getCinemasByOwner(owner);
	}


	@Override
	public List<Cinema> getCinemasByOwner(int owner_id) {
		return new CinemaHandler().getCinemasByOwner(owner_id);
	}


	@Override
	public List<Booking> getBookingsByOwner(Owner owner) {
		// TODO Auto-generated method stub
		return this.getBookingsByOwner(owner.getId());
	}


	@Override
	public List<Booking> getBookingsByOwner(int owner_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
