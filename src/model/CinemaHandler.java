package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Cinema;
import model.handlerinterface.CinemaHandlerInterface;

public class CinemaHandler implements CinemaHandlerInterface{

	public CinemaHandler() {
	}

	@Override
	public int newCinema(Cinema cinema){
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(cinema);		
		session.getTransaction().commit();
		session.close();
		return id;
		
	}

	@Override
	public Cinema getCinema(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Cinema c = (Cinema)session.get(Cinema.class, id);		
		session.getTransaction().commit();
		session.close();
		return c;
	}

	@Override
	public Cinema removeCinema(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Cinema c = (Cinema)session.get(Cinema.class, id);	
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		return c;
	}

	@Override
	public boolean isExist(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Cinema c = (Cinema)session.get(Cinema.class, id);	
		session.getTransaction().commit();
		session.close();
		if(c!=null){
			return true;
		} 
		return false;
	}

	@Override
	public void updateCinema(Cinema cinema) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(cinema);		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void removeCinema(Cinema cinema) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(cinema);		
		session.getTransaction().commit();
		session.close();		
	}

	@Override
	public List<Cinema> getAllCinemas() {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		List<Cinema> cinemas = session.createQuery("FROM Cinema").list();
		session.getTransaction().commit();
		session.close();
		return cinemas;
	}

}
