package model.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Cinema;
import model.bean.Genre;
import model.bean.Movie;
import model.bean.Review;
import model.bean.User;
import model.handlerInterface.MovieHandlerInterface;

/**
 * 
 * @author SephyZhou
 *
 */
public class MovieHandler implements MovieHandlerInterface{

	public MovieHandler() {
	}

	@Override
	public int addMovie(Movie movie) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(movie);		
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public Movie removeMovie(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Movie m = (Movie)session.get(Movie.class, id);	
		session.delete(m);
		session.getTransaction().commit();
		session.close();
		return m;
	}

	@Override
	public List<Movie> getAllMovies() {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		List<Movie> movies = session.createQuery("FROM Movie").list();
		session.getTransaction().commit();
		session.close();
		return movies;
	}

	@Override
	public Movie getMovie(int id) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Movie m = (Movie)session.get(Movie.class, id);		
		session.getTransaction().commit();
		session.close();
		return m;
	}

	@Override
	public void updateMovie(Movie movie) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(movie);		
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void removeMovie(Movie movie) {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(movie);		
		session.getTransaction().commit();
		session.close();	
	}
	

	@Override
	public List<Movie> getShowingMovies() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select id FROM movie where release_date <= cast(now() as date)";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Movie> results = new ArrayList<Movie>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			Movie m = this.getMovie(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	@Override
	public List<Movie> getComingMovies() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select id FROM movie where release_date > cast(now() as date)";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Movie> results = new ArrayList<Movie>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			Movie m = this.getMovie(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	@Override
	public List<Movie> searchByTitle(String title) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT id from movie where title like title
		String sql = "select id FROM movie where title like '%"+title+"%'";
		//System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Movie> results = new ArrayList<Movie>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			Movie m = this.getMovie(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}


	
	@Override
	public List<Genre> getAllGenres() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		List<Genre> genres = session.createQuery("FROM Genre").list();
		session.getTransaction().commit();
		session.close();
		return genres;
	}


	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select M.id from movie_genre MG join Movie M join Genre G where MG.movie_id = M.id and MG.genre_id=G.id and G.name like '%"+genre+"%'";
		System.out.println(sql);
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Movie> results = new ArrayList<Movie>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			Movie m = this.getMovie(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	@Override
	public List<Movie> getMoviesByGenre(Genre genre) {
		return this.getMoviesByGenre(genre.getId());
	}

	@Override
	public List<Movie> getMoviesByGenre(int genre_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select M.id,M.title from movie_genre MG join Movie M where MG.movie_id = M.id and MG.genre_id = "
				+ genre_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Movie> results = new ArrayList<Movie>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			Movie m = this.getMovie(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	@Override
	public List<Genre> getGenresByMovie(int movie_id) {
		List<Genre> results = new ArrayList<Genre>();
		Movie m = this.getMovie(movie_id);
		Set<Genre> genres = m.getGenres();
		for(Genre g: genres){
			results.add(g);
		}
		return results;
	}

	@Override
	public List<Genre> getGenresByMovie(Movie movie) {
		return this.getGenresByMovie(movie.getId());
	}

	@Override
	public List<model.bean.Session> getSessionsByMovie(int movie_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<model.bean.Session> getSessionsByMovie(Movie movie) {
		return this.getSessionsByMovie(movie.getId());
	}

	@Override
	public Movie getMovieBySession(model.bean.Session session) {
		return this.getMovieBySession(session.getId());
	}

	@Override
	public Movie getMovieBySession(int session_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByMovie(Movie movie) {
		return this.getReviewsByMovie(movie.getId());
	}

	@Override
	public List<Review> getReviewsByMovie(int movie_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select id FROM review where movie_id="+movie_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Review> results = new ArrayList<Review>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			Review m = new ReviewHandler().getReviewsById(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	@Override
	public Movie getMovieByReview(Review review) {
		return this.getMovieByReview(review.getId());
	}

	@Override
	public Movie getMovieByReview(int review_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//SELECT FROM movie Where release_date is not null && release_date < today
		String sql = "select movie_id FROM review where id="+review_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		Movie u = null;
		Map row = (Map) data.get(0);
		int id = Integer.parseInt(row.get("movie_id").toString());
		u = this.getMovie(id);
		session.getTransaction().commit();
		session.close();
		return u;
	}

	@Override
	public List<Movie> getMoviesByCinema(Cinema cinema) {
		return new CinemaHandler().getMoviesByCinema(cinema);
	}

	@Override
	public List<Movie> getMoviesByCinema(int cinema_id) {
		return new CinemaHandler().getMoviesByCinema(cinema_id);
	}

	@Override
	public List<Cinema> getCinemasByMovie(Movie movie) {
		return new CinemaHandler().getCinemasByMovie(movie);
	}

	@Override
	public List<Cinema> getCinemasByMovie(int movie_id) {
		return new CinemaHandler().getCinemasByMovie(movie_id);
	}

	
}
