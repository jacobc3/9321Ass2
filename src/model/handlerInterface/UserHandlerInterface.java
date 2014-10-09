package model.handlerInterface;

import java.util.List;

import model.bean.Booking;
import model.bean.Owner;
import model.bean.Review;
import model.bean.User;

public interface UserHandlerInterface {
	public int addUser(User user);	
	public void confirmRegistration(int user_id);
	public User getUserById(int user_id);
	public void updateUser(User user);
	
	public List<User> getAllUsers();
	public boolean isExist(int id);
	public boolean isExist(String username);
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
	public void sendConfirmMail(User u);
	
	
}
