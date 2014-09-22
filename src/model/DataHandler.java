package model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DataHandler {
	@SuppressWarnings("deprecation")
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public DataHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("rawtypes")
	public static List<Cinema> getCinemas(){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Cinema> cinemas = null ;
		try {
			tx = session.beginTransaction();
			cinemas = session.createQuery("FROM Cinema").list();
			tx.commit();
			System.out.println("Request all cinemas:"+cinemas);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}		
		return cinemas;
		
	}

}
