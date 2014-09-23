package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Cinema;
import model.bean.Genre;
import model.handlerinterface.GenreHandlerInterface;

public class GenreHandler implements GenreHandlerInterface {

	public GenreHandler() {
	}

	@Override
	public List<Genre> getAllGenres() {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		List<Genre> genres = session.createQuery("FROM Genre").list();
		session.getTransaction().commit();
		session.close();
		return genres;
	}

}
