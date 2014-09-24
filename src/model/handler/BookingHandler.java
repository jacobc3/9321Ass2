package model.handler;

import java.util.List;

import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Booking;
import model.bean.OrderStatus;
import model.bean.Owner;
import model.bean.Session;
import model.bean.User;
import model.handlerInterface.BookingHandlerInterface;
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
		b.setStatus(OrderStatus.Denied);
		this.updateBooking(b);
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
	public List<Booking> getBookingsByOwner(Owner owner) {
		return new OwnerHandler().getBookingsByOwner(owner);
	}

	@Override
	public List<Booking> getBookingsByOwner(int owner_id) {
		return new OwnerHandler().getBookingsByOwner(owner_id);
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

}
