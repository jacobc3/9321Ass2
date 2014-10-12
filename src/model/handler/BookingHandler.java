package model.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Booking;
import model.bean.Movie;
import model.bean.OrderStatus;
import model.bean.Owner;
import model.bean.Review;
import model.bean.Session;
import model.bean.User;
import model.handlerInterface.BookingHandlerInterface;
import model.mail.MailSender;
/**
 * finished
 * @author SephyZhou
 *
 */
public class BookingHandler implements BookingHandlerInterface {

	public BookingHandler() {
	}

	@Override
	public int addBooking(Booking booking) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(booking);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public Booking getBooking(int id){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		Booking b = (Booking) session.get(Booking.class, id);
		session.getTransaction().commit();
		session.close();
		return b;
	}
	@Override
	public void approveBooking(int id) {
		Booking b = this.getBooking(id);
		b.setStatus(OrderStatus.Approved);		
		this.updateBooking(b);
		sendStatusEmail(id);
	}
	
	private void sendStatusEmail(int booking_id){
		new MailSender().sendBookingStatusMail(this.getBooking(booking_id));
	}
	
	@Override
	public void updateBooking(Booking booking){
		SessionFactory factory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		session.update(booking);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void declineBooking(int id) {		
		Booking b = this.getBooking(id);
		b.setStatus(OrderStatus.Declined);		
		this.updateBooking(b);
		sendStatusEmail(id);
	}

	@Override
	public List<Booking> getBookingsByUser(User user) {
		return new UserHandler().getBookingsByUser(user);
	}

	@Override
	public List<Booking> getBookingsByUser(int user_id) {
		return new UserHandler().getBookingsByUser(user_id);
	}

	@Override
	public User getUserByBooking(Booking booking) {
		return new UserHandler().getUserByBooking(booking);
	}

	@Override
	public User getUserByBooking(int booking_id) {
		return new UserHandler().getUserByBooking(booking_id);
	}

	@Override
	public Session getSessionByBooking(Booking booking) {
		return new SessionHandler().getSessionByBooking(booking);
	}

	@Override
	public Session getSessionByBooking(int booking_id) {
		return new SessionHandler().getSessionByBooking(booking_id);
	}

	@Override
	public List<Booking> getBookingsBySession(Session session) {
		return new SessionHandler().getBookingsBySession(session);
	}

	@Override
	public List<Booking> getBookingsBySession(int session_id) {
		return new SessionHandler().getBookingsBySession(session_id);
	}

	@Override
	public boolean okToBook(int session_id, int requestCount) {
		return new SessionHandler().okToBook(session_id, requestCount);
	}

	@Override
	public List<Booking> getAllBookings() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		List<Booking> bs = session.createQuery("FROM Booking").list();
		session.getTransaction().commit();
		session.close();
		return bs;
	}

	@Override
	public List<Booking> getBookingsByStatus(OrderStatus s) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		org.hibernate.Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select * FROM booking where status=\""+s+"\"";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Booking.class);
		List<Booking> data = query.list();
		return data;
	}

}
