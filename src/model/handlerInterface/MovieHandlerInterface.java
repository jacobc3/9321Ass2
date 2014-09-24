package model.handlerInterface;

import java.util.List;

import model.bean.Cinema;
import model.bean.Genre;
import model.bean.Movie;
import model.bean.Review;
import model.bean.Session;

public interface MovieHandlerInterface {
	public List<Movie> getAllMovies();
	public void updateMovie(Movie movie);
	public int addMovie(Movie movie);
	
	public List<Movie> getShowingMovies();
	public List<Movie> getComingMovies();
	public List<Movie> searchByTitle(String title);
	
	
	
	
	public Movie getMovie(int id);
	
	
	
	//not listed in UML
	public Movie removeMovie(int id);
	public void removeMovie(Movie movie);
	public List<Genre> getAllGenres();
	
	
	//movie-genre related
	public List<Movie> getMoviesByGenre(String genre);	
	public List<Movie> getMoviesByGenre(Genre genre);	
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
	
	//movie-cinema related
	public List<Movie> getMoviesByCinema(Cinema cinema);
	public List<Movie> getMoviesByCinema(int cinema_id);
	public List<Cinema> getCinemasByMovie (Movie movie);
	public List<Cinema> getCinemasByMovie (int movie_id);

	
}
