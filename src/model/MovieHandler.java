package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Cinema;
import model.bean.Movie;
import model.handlerinterface.MovieHandlerInterface;

public class MovieHandler implements MovieHandlerInterface{

	public MovieHandler() {
	}

	@Override
	public int newMovie(Movie movie) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(movie);		
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public Movie removeMovie(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Movie m = (Movie)session.get(Movie.class, id);	
		session.delete(m);
		session.getTransaction().commit();
		session.close();
		return m;
	}

	@Override
	public List<Movie> getAllMovies() {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		List<Movie> movies = session.createQuery("FROM Movie").list();
		session.getTransaction().commit();
		session.close();
		return movies;
	}

	@Override
	public Movie getMovie(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Movie m = (Movie)session.get(Movie.class, id);		
		session.getTransaction().commit();
		session.close();
		return m;
	}

	@Override
	public void updateMovie(Movie movie) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(movie);		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void removeMovie(Movie movie) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(movie);		
		session.getTransaction().commit();
		session.close();	
	}

}
