package model.handlerinterface;

import java.util.List;

import model.bean.Amenity;
import model.bean.Cinema;

public interface AmenityHandlerInterface {
	public List<Amenity> getAllAmenities();
	public List<Amenity> getAmenities(Cinema cinema);
	
}
