package model.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Booking;
import model.bean.Cinema;
import model.bean.Genre;
import model.bean.Movie;
import model.bean.OrderStatus;
import model.bean.Owner;
import model.bean.Review;
import model.bean.User;
import model.handlerInterface.MovieHandlerInterface;

/**
 * 
 * @author SephyZhou
 *
 */
public class MovieHandler implements MovieHandlerInterface {

	public MovieHandler() {
	}

	@Override
	public int addMovie(Movie movie) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(movie);
		session.getTransaction().commit();
		session.close();
		return id;
	}

	@Override
	public Movie removeMovie(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Movie m = (Movie) session.get(Movie.class, id);
		session.delete(m);
		session.getTransaction().commit();
		session.close();
		return m;
	}

	@Override
	public List<Movie> getAllMovies() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		List<Movie> movies = session.createQuery("FROM Movie").list();
		session.getTransaction().commit();
		session.close();
		return movies;
	}

	@Override
	public Movie getMovie(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Movie m = (Movie) session.get(Movie.class, id);
		session.getTransaction().commit();
		session.close();
		return m;
	}

	@Override
	public void updateMovie(Movie movie) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(movie);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void removeMovie(Movie movie) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
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
		// SELECT FROM movie Where release_date is not null && release_date <
		// today
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
		// SELECT FROM movie Where release_date is not null && release_date <
		// today
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
		// SELECT id from movie where title like title
		String sql = "select id FROM movie where title like '%" + title + "%'";
		// System.out.println(sql);
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
		String sql = "select M.id from movie_genre MG join Movie M join Genre G where MG.movie_id = M.id and MG.genre_id=G.id and G.name like '%"
				+ genre + "%'";
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
		for (Genre g : genres) {
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
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select id from session where movie_id=" + movie_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<model.bean.Session> results = new ArrayList<model.bean.Session>();
		for (Object object : data) {
			Map row = (Map) object;
			int id = Integer.parseInt(row.get("id").toString());
			model.bean.Session s = new SessionHandler().getSession(id);
			results.add(s);
		}
		session.getTransaction().commit();
		session.close();
		return results;
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
		// select A.name from cinema_amenity CA join Amenity A where CA.amenity
		// = A.id
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "SELECT movie_id from session WHere id=" + session_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		Map row = (Map) data.get(0);
		int id = Integer.parseInt(row.get("movie_id").toString());
		Movie m = this.getMovie(id);
		session.getTransaction().commit();
		session.close();
		return m;
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
		// SELECT FROM movie Where release_date is not null && release_date <
		// today
		String sql = "select id FROM review where movie_id=" + movie_id;
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
		// SELECT FROM movie Where release_date is not null && release_date <
		// today
		String sql = "select movie_id FROM review where id=" + review_id;
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

	@Override
	public List<Movie> searchByGenre(int genre_id) {
		return this.getMoviesByGenre(genre_id);
	}

	@Override
	public void setReleaseDate(int movieId, Date date) {
		Movie m = this.getMovie(movieId);
		m.setRelease_date(date);
		this.updateMovie(m);
	}

	@Override
	public double getAveRatingByMovie(int movie_id) {
		double result = 0;

		List<Review> rs = this.getReviewsByMovie(movie_id);
		if (rs.size() == 0) {
			result = 0;
		} else {
			int total = 0;
			int count = 0;
			for (java.util.Iterator<Review> iterator = rs.iterator(); iterator
					.hasNext();) {
				Review b = (Review) iterator.next();
				if (b.getRating() > 0) {
					total += b.getRating();
					count++;
				}
			}
			result = 1.0 * total / count;
		}
		return result;
	}

	@Override
	public boolean isMovieReviewable(int movie_id) {
		return new ReviewHandler().isMovieReviewable(movie_id);
	}

	@Override
	public Genre getGenreById(int genre_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Genre m = (Genre) session.get(Genre.class, genre_id);
		session.getTransaction().commit();
		session.close();
		return m;
	}

	public List<Movie> getNoDateMovies() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select * from movie where release_date IS NULL";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Movie.class);
		List<Movie> data = query.list();
		session.getTransaction().commit();
		session.close();
		return data;
	}

	@Override
	public List<Movie> searchByGenre(String genre_name) {
		List<Genre> gs = this.getGenresByName(genre_name);
		if (gs != null && gs.size() > 0) {
			List<Movie> ms = new ArrayList<Movie>();
			for (Genre g : gs) {
				List<Movie> msEachGenre = this.searchByGenre(g.getId());
				for(Movie m : msEachGenre){
					ms.add(m);
				}
			}			
			return ms;
		}
		return null;
	}

	@Override
	public List<Genre> getGenresByName(String genre_name) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		// SELECT id from movie where title like title
		String sql = "select * FROM genre where name like '%" + genre_name + "%'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Genre.class);
		List<Genre> data = query.list();
		return data;
	}

}
