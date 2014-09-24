package model;

import java.util.List;
import java.util.*;

import model.bean.Genre;
import model.bean.*;
import model.handlerinterface.MovieHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class MovieTester {

	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	MovieHandlerInterface mh = new MovieHandler();
	@BeforeClass
	public static void beforeClass() {
	}
	@Test
	public void SingleMovieTest(){
		Movie m = mh.getMovie(1);
		System.out.println(m.getTitle()+"\t");
		Set<Genre> gs = m.getGenres();
		for(Genre g: gs){
			System.out.println(g.getName()+"\t");
			mh.getMovies(g);
		}
		
		
		
	}
	
	
	
//	@Test
	public void AllMoviesTest(){		
		List<Movie> l = mh.getAllMovies();
		for(Movie m : l){
			System.out.println(m.getTitle()+"\t");
		}
	}
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}
	
	
	

}
