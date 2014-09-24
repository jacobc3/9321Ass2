package model.handlerInterface;

import java.util.List;

import model.bean.Amenity;
import model.bean.Cinema;
import model.bean.Movie;
import model.bean.Owner;
import model.bean.Session;

public interface CinemaHandlerInterface {
	public int addCinema(Cinema cinema);
	public void updateCinema(Cinema cinema);
	
	//not listed
	
	public Cinema getCinema(int id);
	public void removeCinema(Cinema cinema);
	public Cinema removeCinema(int id);
	public boolean isExist(int cinema_id);
	public List<Cinema> getAllCinemas();
	public Amenity getAmenity(int amenity_id);
	
	
	//amenity-cinema relaed
	public List<Amenity> getAllAmenities();
	public List<Amenity> getAmenitiesByCinema(Cinema cinema);
	public List<Amenity> getAmenitiesByCinema(int cinema_id);
	public List<Cinema> getCinemasByAmenity(Amenity amenity);
	public List<Cinema> getCinemasByAmenity(int amenity_id);
	
	////owner-cinema related
	public Owner getOwnerByCinema(Owner owner);
	public Owner getOwnerByCinema(int owner_id);
	public List<Cinema> getCinemasByOwner(Owner owner);
	public List<Cinema> getCinemasByOwner(int owner_id);
	
	//session-cinema related
	public List<Session> getSessionsByCinema(Cinema cinema);
	public List<Session> getSessionsByCinema(int cinema_id);
	public Cinema getCinemaBySession(Session session);
	public Cinema getCinemaBySession(int session_id);
	
	//movie-cinema related
	public List<Movie> getMoviesByCinema(Cinema cinema);
	public List<Movie> getMoviesByCinema(int cinema_id);
	public List<Cinema> getCinemasByMovie (Movie movie);
	public List<Cinema> getCinemasByMovie (int movie_id);
	
}
