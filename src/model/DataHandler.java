package model;

import java.util.List;
import java.util.Set;

import model.bean.Cinema;
import model.bean.Movie;
import model.handlerinterface.CinemaHandlerInterface;
import model.handlerinterface.MovieHandlerInterface;

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
		CinemaHandlerInterface ch = new CinemaHandler();
		return ch.getAllCinemas();
	}

	public static List<Movie> getMovies(){
		MovieHandlerInterface mh = new MovieHandler();
		return mh.getAllMovies();
	}
	
	
	public static void addMovie() {

	}

	public static void addCinema() {

	}

}
