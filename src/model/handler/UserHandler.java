package model.handler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Booking;
import model.bean.Owner;
import model.bean.Review;
import model.bean.User;
import model.handlerInterface.UserHandlerInterface;

public class UserHandler implements UserHandlerInterface {

	public UserHandler() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
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
	public List<Review> getReviewByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Booking> getBookingByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
