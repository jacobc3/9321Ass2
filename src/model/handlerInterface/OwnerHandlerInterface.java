package model.handlerInterface;

import java.util.Date;
import java.util.List;

import model.bean.Booking;
import model.bean.Cinema;
import model.bean.Owner;

public interface OwnerHandlerInterface {
	public boolean isExist(int id);
	public boolean isExist(String username);
	public boolean isMatch(String username,String password);

	//booking related
	public void approveBooking(int bookingId);
	public void declineBooking(int bookingId);
	
	//cinema related
	public int addCinema(Cinema cinema);
	public void updateCinema(Cinema cinema);
	
	//movie related
	public void setReleaseDate(int movieId, Date date);
	
	
}
