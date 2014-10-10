package model.handlerInterface;

import java.util.List;

import model.bean.Movie;
import model.bean.Review;
import model.bean.User;

public interface ReviewHandlerInterface {
	public int addReview(Review review);
	public void updateReview(Review review);
	public Review getReviewsById(int id);
	
	//movie-review related
	public List<Review> getReviewsByMovie(Movie movie);
	public List<Review> getReviewsByMovie(int movie_id);
	public Movie getMovieByReview(Review review);
	public Movie getMovieByReview(int review_id);
	public boolean isMovieReviewable(int movie_id);

	//user-review related
	public List<Review> getReviewsByUser(User user);
	public List<Review> getReviewsByUser(int user_id);
	public User getUserByReview(Review review);
	public User getUserByReview(int review_id);
	

}
