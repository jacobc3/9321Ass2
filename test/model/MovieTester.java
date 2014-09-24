package model;

import java.util.*;

import model.bean.*;
import model.handler.MovieHandler;
import model.handlerInterface.MovieHandlerInterface;

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
		System.out.println("movie title "+m.getTitle()+"\t");
		Set<Genre> gs = m.getGenres();
		System.out.println(gs);
		Genre g = gs.iterator().next();
		System.out.println("genre is "+g.getName());
		List<Movie> movies = mh.getMoviesByGenre(g);
		Iterator<Movie> it = movies.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getTitle());
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
