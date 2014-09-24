package model.handlerInterface;

import java.util.List;

import model.bean.Review;

public interface ReviewHandlerInterface {
	public int addReview(Review review);
	public List<Review> getReviewByUserId(int user_id);
	public void updateReview(Review review);
	public List<Review> getReviewByMovieId(int movie_id);
}
