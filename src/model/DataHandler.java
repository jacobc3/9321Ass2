package model;

import java.util.List;
import java.util.Set;

import model.bean.Cinema;
import model.bean.Movie;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import controller.HibernateUtil;

public class DataHandler {
	public DataHandler() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Cinema> getCinemas() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Cinema> cinemas = null;
		tx = session.beginTransaction();
		cinemas = session.createQuery("FROM Cinema").list();
		tx.commit();
		System.out.println("Request all cinemas:" + cinemas);
		session.close();
		//TODO: do we need this line?
		//HibernateUtil.getSessionFactory().close();
		return cinemas;

	}

	public static List<Movie> getMovies(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<Movie> movies = null;
		tx = session.beginTransaction();
		movies = session.createQuery("FROM Movie").list(); //this 'Movie' is java class
		tx.commit();
		System.out.println("Request all movies:" + movies);
		session.close();
		//TODO: do we need this line?
		//HibernateUtil.getSessionFactory().close();
		return movies;
	}
	
	
	public static void addMovie() {

	}

	public static void addCinema() {

	}

}
