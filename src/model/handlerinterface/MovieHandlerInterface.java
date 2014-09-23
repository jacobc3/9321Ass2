package model.handlerinterface;

import java.util.List;

import model.bean.Movie;

public interface MovieHandlerInterface {
	public int newMovie(Movie movie);
	public Movie removeMovie(int id);
	public void removeMovie(Movie movie);
	public List<Movie> getAllMovies();
	public Movie getMovie(int id);
	public void updateMovie(Movie movie);
}
