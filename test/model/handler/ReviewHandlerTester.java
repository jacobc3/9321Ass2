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
	
	@Test
	public void isMovieReviewable(){
		System.out.println("id 1 reviewable "+rh.isMovieReviewable(1));
		System.out.println("id 3 reviewable "+rh.isMovieReviewable(3));
		System.out.println("id 4 reviewable "+rh.isMovieReviewable(4));
		System.out.println("id 5 reviewable "+rh.isMovieReviewable(5));
		System.out.println("id 7 reviewable "+rh.isMovieReviewable(7));
		System.out.println("id 13 reviewable "+rh.isMovieReviewable(13));
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
