package model.handler;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import model.bean.Genre;
import model.bean.Movie;
import model.handlerInterface.MovieHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class MovieHandlertester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public MovieHandlerInterface mh =  new MovieHandler();
	@BeforeClass
	public static void beforeClass() {
	}

	@Test
	public void getShowingMovieTest(){
		System.out.println("showing");
		List<Movie> ms = mh.getShowingMovies();
		for(Movie m : ms){
			System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getRelease_date());
		}
		System.out.println("\nincoming");
		ms = mh.getComingMovies();
		for(Movie m : ms){
			System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getRelease_date());
		}
		
		String title = "big";
		System.out.println("\ntitle like "+title);
		ms = mh.searchByTitle(title);
		for(Movie m : ms){
			System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getRelease_date());
		}
		
		String genre = "Action";
		System.out.println("\ngenre like "+genre);
		ms = mh.getMoviesByGenre(genre);
		for(Movie m : ms){
			System.out.println(m.getId()+"\t"+m.getTitle()+"\t"+m.getRelease_date());
		}
		
		
	}
	
	
	
//	@Test
	public void AllMovieTtest() {
		List<Movie> ms = mh.getAllMovies();
		for(Movie m : ms){
			System.out.println(m.getTitle()+"\t");
		}
	}
	
//	@Test
	public void getMovieTest(){
		Movie m = mh.getMovie(3);
		System.out.println(m.getTitle()+"\t");
	}
	
//	@Test
	public void getMovieGenreTest(){
		Movie m = mh.getMovie(1);
		System.out.println(m.getTitle()+"\t");
		System.out.println("\nSet Format");
		Set<Genre> genres = (Set<Genre>) m.getGenres();
		for(Genre g: genres){
			System.out.println(g.getName()+"\t");
		}
		System.out.println("\nList Format");
		List<Genre> list = mh.getGenresByMovie(m.getId());
		for(Genre g: list){
			System.out.println(g.getName()+"\t");
		}
	}
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
