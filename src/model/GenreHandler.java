package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Cinema;
import model.bean.Genre;
import model.bean.Movie;
import model.handlerinterface.GenreHandlerInterface;

public class GenreHandler implements GenreHandlerInterface {

	public GenreHandler() {
	}

	@Override
	public List<Genre> getAllGenres() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		List<Genre> genres = session.createQuery("FROM Genre").list();
		session.getTransaction().commit();
		session.close();
		return genres;
	}

	

}
