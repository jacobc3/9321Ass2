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
import model.handlerInterface.MovieHandlerInterface;

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
	public List<Movie> searchByGenre(Genre genre) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select M.id,M.title from movie_genre MG join Movie M where MG.movie_id = M.id and MG.genre_id = "
				+ genre.getId();
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//		System.out.println("A1");
		List data = query.list();

		List<Movie> results = new ArrayList<Movie>();
		for (Object object : data) {
//			System.out.println("A3" + object);
			Map row = (Map) object;
//			System.out.println(row.get("title") + " " + row.get("id"));
//			System.out.println("A3.5");
			int id = Integer.parseInt(row.get("id").toString());
//			System.out.println("A3.6 " + id);
			Movie m = this.getMovie(id);
			results.add(m);
//			System.out.println("A3.7");
		}
//		System.out.println("A4");
		session.getTransaction().commit();
		session.close();

//		System.out.println("A5" + results);
		return results;
	}

	@Override
	public void setReleaseDate(int movie_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addSession(model.bean.Session session) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<Movie> getShowingMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getComingMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> searchByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> searchByGenre(String genre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public model.bean.Session getSessionByMovieId(int movie_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public model.bean.Session getSession(int session_id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Genre> getGenresByMovieId(int movie_id) {
		List<Genre> results = new ArrayList<Genre>();
		Movie m = this.getMovie(movie_id);
		Set<Genre> genres = m.getGenres();
		for(Genre g: genres){
//			System.out.print("g is"+g.getName()+"\t");
			results.add(g);
		}
//		System.out.println();
		return results;
	}

	
}
