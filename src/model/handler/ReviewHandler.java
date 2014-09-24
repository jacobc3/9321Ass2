package model.handler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Review;
import model.handlerInterface.ReviewHandlerInterface;

public class ReviewHandler implements ReviewHandlerInterface {

	public ReviewHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Review> getReviewByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReview(Review review) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addReview(Review review) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(review);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public List<Review> getReviewByMovieId(int movie_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
