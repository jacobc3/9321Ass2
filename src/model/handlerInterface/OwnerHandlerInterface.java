package model.handlerInterface;

import java.util.List;

import model.bean.Booking;
import model.bean.Cinema;
import model.bean.Owner;

public interface OwnerHandlerInterface {
	public int addOwner(Owner owner);
	public boolean isMatch(String username, String password);
	public void updateOwner(Owner owner);

	// not listed
	public Owner getOwnerById(int id);
	public List<Owner> getAllOwners();
	public boolean isExist(int id);
	public boolean isExist(String username);

	// owner-cinema related
	public Owner getOwnerByCinema(Cinema cinema);
	public Owner getOwnerByCinema(int cinema_id);
	public List<Cinema> getCinemasByOwner(Owner owner);
	public List<Cinema> getCinemasByOwner(int owner_id);
	
	// owner-booking related
	public List<Booking> getBookingsByOwner(Owner owner);
	public List<Booking> getBookingsByOwner(int owner_id);
	

}
