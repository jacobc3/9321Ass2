package model.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Booking;
import model.bean.Movie;
import model.bean.Owner;
import model.bean.Review;
import model.bean.User;
import model.handlerInterface.UserHandlerInterface;

public class UserHandler implements UserHandlerInterface {

	public UserHandler() {
	}

	@Override
	public int addUser(User user) {
		//TODO  send email-confirmation
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(user);		
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public boolean isMatch(String username, String password) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		String sql = "select id from user where username LIKE '"+username+"'"+"and password LIKE '"+password+"'";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		if(data.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public void confirmRegistration(int id) {
		User u = this.getUserById(id);
		u.setEmailOk(true);
		
		this.updateUser(u);
	}

	@Override
	public User getUserById(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		User u = (User)session.get(User.class, id);		
		session.getTransaction().commit();
		session.close();
		return u;
	}


	@Override
	public void updateUser(User user) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(user);		
		session.getTransaction().commit();
		session.close();
	}


	@Override
	public List<User> getAllUsers() {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		List<User> users = session.createQuery("FROM User").list();
		session.getTransaction().commit();
		session.close();
		return users;
	}

	@Override
	public boolean isExist(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		User c = (User)session.get(User.class, id);	
		session.getTransaction().commit();
		session.close();
		if(c!=null){
			return true;
		} 
		return false;
	}

	@Override
	public boolean isExist(String username) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		String sql = "select id from user where username LIKE '"+username+"'";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		if(data.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Review> getReviewsByUser(User user) {
		return this.getReviewsByUser(user.getId());
	}

	@Override
	public List<Review> getReviewsByUser(int user_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select id FROM review where user_id="+user_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Review> results = new ArrayList<Review>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			Review m = new ReviewHandler().getReviewsById(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	@Override
	public User getUserByReview(Review review) {
		return this.getUserByReview(review.getId());
	}

	@Override
	public User getUserByReview(int review_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select user_id FROM review where id="+review_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		User u = null;
		Map row = (Map) data.get(0);
		int id = Integer.parseInt(row.get("user_id").toString());
		u = this.getUserById(id);
		session.getTransaction().commit();
		session.close();
		return u;
	}

	@Override
	public List<Booking> getBookingsByUser(User user) {
		return this.getBookingsByUser(user.getId());
	}

	@Override
	public List<Booking> getBookingsByUser(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByBooking(Booking booking) {
		return this.getUserByBooking(booking.getId());
	}

	@Override
	public User getUserByBooking(int booking_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
