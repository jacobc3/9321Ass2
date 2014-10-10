package model.handlerInterface;

import java.util.List;

import model.bean.Booking;
import model.bean.Owner;
import model.bean.Review;
import model.bean.User;

public interface UserHandlerInterface {
	/**
	 * 
	 * @param user this password should not be md5'ed
	 * @return
	 */
	public int addUser(User user);
	/**
	 * Confirm user's registration by setting user's status into Approved.<br>
	 * User can not be unconfirmed after confirm.
	 * @param user_id
	 */
	public void confirmRegistration(int user_id);
	public User getUserById(int user_id);
	public User getUserByUsername(String username);
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	public boolean isExist(int id);
	public boolean isExist(String username);
	/**
	 * 
	 * @param username
	 * @param password not md5'ed one
	 * @return
	 */
	public boolean isMatch(String username, String password);
	
	
	//user-review related
	public List<Review> getReviewsByUser(User user);
	public List<Review> getReviewsByUser(int user_id);
	public User getUserByReview(Review review);
	public User getUserByReview(int review_id);
	
	
	//user-booking related
	public List<Booking> getBookingsByUser(User user);
	public List<Booking> getBookingsByUser(int user_id);
	public User getUserByBooking(Booking booking);
	public User getUserByBooking(int booking_id);
	
	/**
	 * Haven't fully implemented yet.
	 * @deprecated
	 * @param u
	 */
	public void sendConfirmMail(User u);
	
	
}
