package model.handlerInterface;

import java.util.List;

import model.bean.Booking;
import model.bean.Cinema;
import model.bean.Movie;
import model.bean.Session;

public interface SessionHandlerInterface {
	public Session getSession(int session_id);
	public void updateSession(Session mySession);
	public int addSession(Session session);
	
	//booking related
	public int getRemainingSeatsCount(int session_id);
	public int getBookedSeatsCount(int session_id);
	/** 
	 * See if a session is able to book a request amount of ticket
	 * @param session_id
	 * @param requestCount
	 * @return
	 */
	public boolean okToBook(int session_id, int requestCount);
	
	//movie-session related
	public List<Session> getSessionsByMovie(int movie_id);
	public List<Session> getSessionsByMovie(Movie movie);
	public Movie getMovieBySession(Session session);
	public Movie getMovieBySession(int session_id);


	//session-booking related
	public Session getSessionByBooking(Booking booking);
	public Session getSessionByBooking(int booking_id);
	public List<Booking> getBookingsBySession(Session session);
	public List<Booking> getBookingsBySession(int session_id);

	//session-cinema related
	public List<Session> getSessionsByCinema(Cinema cinema);
	public List<Session> getSessionsByCinema(int cinema_id);
	public Cinema getCinemaBySession(Session session);
	public Cinema getCinemaBySession(int session_id);
		
}
