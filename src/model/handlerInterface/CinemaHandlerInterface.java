package model.handlerInterface;

import java.util.List;

import model.bean.Amenity;
import model.bean.Cinema;

public interface CinemaHandlerInterface {
	public int addCinema(Cinema cinema);
	public void updateCinema(Cinema cinema);
	
	//not listed
	
	public Cinema getCinema(int id);
	public void removeCinema(Cinema cinema);
	public Cinema removeCinema(int id);
	public boolean isExist(int id);
	public List<Cinema> getAllCinemas();
	public List<Cinema> getCinemas(Amenity amenity);
	
	//amenity
	public List<Amenity> getAllAmenities();
	public List<Amenity> getAmenities(Cinema cinema);
}
