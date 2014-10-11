package model.handler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
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
import model.mail.MailSender;

public class UserHandler implements UserHandlerInterface {

	public UserHandler() {
	}

	@Override
	public int addUser(User user) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String password = user.getPassword();
		String passmd5 = md5(password);
		user.setPassword(passmd5);
		user.setRegistryDate(new Date());
		Integer id = (Integer) session.save(user);	
//		this.sendConfirmMail(user);
		session.getTransaction().commit();
		session.close();
		return id;
	}
	
	public String md5(String s){
		String md5 = null;
		if(s == null) return null;
		try{
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	        digest.update(s.getBytes(), 0, s.length());
	        md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (Exception e){
			e.printStackTrace();
		}		
		return md5;		
	}
	
	
	public void sendConfirmMail(User user){
		//TODO  send email-confirmation
		//TODO should be private. Only in public for testing
		MailSender sender = null;
		try{
			sender = MailSender.getMailSender();
			String fromAddress = "confirmation@sensitiver.com";
			String toAddress = user.getEmail();
			String subject = "Registration confirmation from Movie-Review";
			String mailBody ="Hello there, please click on following link to confirm your registration";
			sender.sendMessage(fromAddress, toAddress, subject, mailBody);
		}catch (Exception e){
			System.out.println("Oopsies, could not send message "+e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public boolean isMatch(String username, String password) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();	
		password = md5(password);
//		System.out.println("@isMatch: password is"+password);
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
		user.setPassword(md5(user.getPassword()));
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
		if(user!=null){
			return this.getReviewsByUser(user.getId());
		}
		return null;
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
		User u = new ReviewHandler().getReviewsById(review_id).getUser();
		return u;
	}

	@Override
	public List<Booking> getBookingsByUser(User user) {
		if(user !=null){
		return this.getBookingsByUser(user.getId());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getBookingsByUser(int user_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select * FROM booking where user_id="+user_id;
		SQLQuery query = session.createSQLQuery(sql).addEntity(Booking.class);
		List<Booking> data = query.list();
		return data;
	}

	@Override
	public User getUserByBooking(Booking booking) {
		return this.getUserByBooking(booking.getId());
	}

	@Override
	public User getUserByBooking(int booking_id) {
		Booking b = new BookingHandler().getBooking(booking_id);
		return b.getUser();
	}

	@Override
	public User getUserByUsername(String username) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select * FROM user where username=\""+username+"\"";
//		System.out.println("username is "+username);
		SQLQuery query = session.createSQLQuery(sql).addEntity(User.class);
		List<User> list = query.list();
//		System.out.println(list.size());
		if(list !=null && list.size() > 0 ){
			return list.get(0);
		}
		return null;
	}

}
