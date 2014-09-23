package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Cinema;
import model.bean.Movie;
import model.bean.Owner;
import model.handlerinterface.OwnerHandlerInterface;

public class OwnerHandler implements OwnerHandlerInterface{

	public OwnerHandler() {
	}
	

	@Override
	public int newOwner(Owner owner) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(owner);		
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public Owner getOwner(int id) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(String username, String password) {
		// TODO Auto-generated method stub
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

}
