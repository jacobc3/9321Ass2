package model.handler;

import static org.junit.Assert.*;

import java.util.List;

import model.bean.Movie;
import model.bean.Review;
import model.bean.User;
import model.handlerInterface.MovieHandlerInterface;
import model.handlerInterface.ReviewHandlerInterface;
import model.handlerInterface.UserHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class ReviewHandlerTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public ReviewHandlerInterface rh =  new ReviewHandler();
	public UserHandlerInterface uh =  new UserHandler();
	public MovieHandlerInterface mh =  new MovieHandler();
	
	@BeforeClass
	public static void beforeClass() {
	}
	
	
//	@Test
	public void newtest(){
		Review review = new Review("MY title");
		User user = uh.getUserById(2);
		review.setUser(user);
		rh.addReview(review);
	}
	
	
//	@Test
	public void getMovieReviewTest(){
		List<Review> rs = rh.getReviewsByMovie(2);
		System.out.println("Reviews");
		for(Review r : rs){
			System.out.println(r.getTitle()+"\t");
		}
		Movie u = rh.getMovieByReview(12);
		System.out.println(u.getId()+"\t"+u.getTitle());
	}
	
//	@Test
	public void getUserReviewtest() {
		List<Review> rs = rh.getReviewsByUser(1);
		for(Review r : rs){
			System.out.println(r.getTitle()+"\t");
		}
		User u = rh.getUserByReview(3);
		System.out.println(u.getId()+"\t"+u.getUsername());
	}
	
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
