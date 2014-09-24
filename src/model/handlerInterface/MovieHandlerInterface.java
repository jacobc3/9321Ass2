package model.handlerInterface;

import java.util.List;

import model.bean.Genre;
import model.bean.Movie;
import model.bean.Session;

public interface MovieHandlerInterface {
	public List<Movie> getAllMovies();
	public void setReleaseDate(int movie_id);
	public void updateMovie(Movie movie);
	public int addSession(Session session);
	public int addMovie(Movie movie);
	
	public List<Movie> getShowingMovies();
	public List<Movie> getComingMovies();
	public List<Movie> searchByTitle(String title);
	public List<Movie> searchByGenre(String genre);	
	public List<Movie> searchByGenre(Genre genre);	
	
	public List<Genre> getGenresByMovieId(int movie_id);
	
	public Movie getMovie(int id);
	
	public Session getSessionByMovieId(int movie_id);
	public Session getSession(int session_id);
	
	//not listed in UML
	public Movie removeMovie(int id);
	public void removeMovie(Movie movie);
	public List<Genre> getAllGenres();
	
}
