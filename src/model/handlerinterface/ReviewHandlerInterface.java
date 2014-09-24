package model.handlerinterface;

import model.bean.Review;

public interface ReviewHandlerInterface {
	public Review getReviewByUserId(int user_id);
	public int addReviewToMovie(Review review);
	public int addReviewToUser(Review review);
	public void updateReview(Review review);
}
