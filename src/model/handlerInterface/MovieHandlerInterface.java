package model.handlerInterface;

import java.util.Date;
import java.util.List;

import model.bean.Cinema;
import model.bean.Genre;
import model.bean.Movie;
import model.bean.Review;
import model.bean.Session;

public interface MovieHandlerInterface {
	/**
	 * 
	 * @return a List of all Movie in database
	 */
	public List<Movie> getAllMovies();
	
	/**
	 * Update details of movie in Object Movie first, then use this method to update it's detail in database
	 * @param movie
	 */
	public void updateMovie(Movie movie);
	
	/**
	 * Create a Movie Object first, then use this method to save it into database
	 * @param movie
	 * @return
	 */
	public int addMovie(Movie movie);
	
	/**
	 * 
	 * @param id movie's id
	 * @return
	 */
	public Movie getMovie(int id);
	
	//search function
	/**
	 * Comparing movie's release time to current time
	 * @return a List of Current Showing movie
	 */
	public List<Movie> getShowingMovies();
	public List<Movie> getComingMovies();
	/**
	 * Comparing movies in database of similar keyword (not whole title)
	 * @param title
	 * @return
	 */
	public List<Movie> searchByTitle(String title);		
	/**
	 * equals to get Movies By Genre
	 * @param genre_id
	 * @return
	 */
	public List<Movie> searchByGenre(int genre_id);
	
	//not listed in UML
	
	/**
	 * Remove a movie. Haven't test
	 * @deprecated
	 * @param id
	 * @return
	 */
	public Movie removeMovie(int id);
	
	/**
	 * Remove a movie. Not sure result. Haven't test.
	 * @deprecated
	 * @param movie
	 */
	public void removeMovie(Movie movie);
	
/**
 * 
 * @return a List of Genre in database
 */
	public List<Genre> getAllGenres();
	
	
	//movie-genre related
	public List<Movie> getMoviesByGenre(String genre);	
	public List<Movie> getMoviesByGenre(Genre genre);
	/**
	 * 
	 * @param genre_id
	 * @return return a List of Movie
	 */
	public List<Movie> getMoviesByGenre(int genre_id);	
	public List<Genre> getGenresByMovie(int movie_id);
	public List<Genre> getGenresByMovie(Movie movie);
	
	//movie-session related
	public List<Session> getSessionsByMovie(int movie_id);
	public List<Session> getSessionsByMovie(Movie movie);
	public Movie getMovieBySession(Session session);
	public Movie getMovieBySession(int session_id);
	
	//movie-review related
	public List<Review> getReviewsByMovie(Movie movie);
	public List<Review> getReviewsByMovie(int movie_id);
	public Movie getMovieByReview(Review review);
	public Movie getMovieByReview(int review_id);
	public double getAveRatingByMovie(int movie_id);
	public boolean isMovieReviewable(int movie_id);
	
	//movie-cinema related
	public List<Movie> getMoviesByCinema(Cinema cinema);
	public List<Movie> getMoviesByCinema(int cinema_id);
	public List<Cinema> getCinemasByMovie (Movie movie);
	public List<Cinema> getCinemasByMovie (int movie_id);

	//owner related
	/**
	 * Didn't test if made change by owner. Must be insured is changed by owner in controller.<br>
	 * Set a release date for a movie
	 * @param movieId
	 * @param date
	 */
	public void setReleaseDate(int movieId, Date date);
	public Genre getGenreById(int genre_id);
	
}
