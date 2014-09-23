package model;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.bean.Amenity;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import controller.HibernateUtil;

public class CinemaHandlerNeat {
	

	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "deprecation" })
	public static void main(String[] args) {
		
		/*
		Configuration cfg = new Configuration();
		factory = cfg.configure().buildSessionFactory();
		*/
		//PERFECT  as below
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//operation
		Amenity amen = (Amenity) session.get(Amenity.class, new Integer(2));
		amen.setName("BLABLA");
		
		session.update(amen);
		
		//operation-finished
		System.out.println("updated");
		session.getTransaction().commit();
		System.out.println("commited");
		session.close();
		factory.close();
		
		//after this, can't do anything with factory.
		
	}

}