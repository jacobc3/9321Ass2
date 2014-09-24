package model.handlerInterface;

import java.util.List;

import model.bean.Booking;
import model.bean.Owner;
import model.bean.Review;
import model.bean.User;

public interface UserHandlerInterface {
	public int addUser(User user);
	public boolean isMatch(String username, String password);
	public void confirmRegistration(int user_id);
	public User getUserById(int user_id);
	public List<Review> getReviewByUserId(int user_id);
	public void updateUser(User user);
	public List<Booking> getBookingByUserId(int user_id);
	
	// not listed in UML
	public List<User> getAllUsers();
	public boolean isExist(int id);
	public boolean isExist(String username);
}
