package model.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Cinema;
import model.bean.Movie;
import model.bean.Owner;
import model.handlerInterface.CinemaHandlerInterface;

/**
 * 
 * @author SephyZhou
 *
 */
public class CinemaHandler implements CinemaHandlerInterface {

	public CinemaHandler() {
	}

	@Override
	public int addCinema(Cinema cinema) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Integer id = (Integer) session.save(cinema);
		session.getTransaction().commit();
		session.close();
		return id;

	}

	@Override
	public Cinema getCinema(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Cinema c = (Cinema) session.get(Cinema.class, id);
		session.getTransaction().commit();
		session.close();
		return c;
	}

	@Override
	public Cinema removeCinema(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Cinema c = (Cinema) session.get(Cinema.class, id);
		session.delete(c);
		session.getTransaction().commit();
		session.close();
		return c;
	}

	@Override
	public boolean isExist(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Cinema c = (Cinema) session.get(Cinema.class, id);
		session.getTransaction().commit();
		session.close();
		if (c != null) {
			return true;
		}
		return false;
	}

	@Override
	public void updateCinema(Cinema cinema) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.update(cinema);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public void removeCinema(Cinema cinema) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.delete(cinema);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Cinema> getAllCinemas() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		List<Cinema> cinemas = session.createQuery("FROM Cinema").list();
		session.getTransaction().commit();
		session.close();
		return cinemas;
	}

	@Override
	public List<Amenity> getAllAmenities() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		List<Amenity> amenities = session.createQuery("FROM Amenity").list();
		session.getTransaction().commit();
		session.close();
		return amenities;
	}

	@Override
	public Amenity getAmenity(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Amenity a = (Amenity) session.get(Amenity.class, id);
		session.getTransaction().commit();
		session.close();
		return a;
	}

	@Override
	public List<Amenity> getAmenitiesByCinema(Cinema cinema) {
		return this.getAmenitiesByCinema(cinema.getId());
	}

	@Override
	public List<Amenity> getAmenitiesByCinema(int cinema_id) {
		// We can use Select ** from ** to retrive amenities's information

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select A.id,A.name from cinema_amenity CA join amenity A where CA.amenity_id = A.id and CA.cinema_id = "
				+ cinema_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Amenity> results = new ArrayList<Amenity>();
		for (Object object : data) {
			Map row = (Map) object;
			// System.out.println(row.get("name") + " " + row.get("id"));
			int id = Integer.parseInt(row.get("id").toString());
			// System.out.println("A3.6 " + id);
			Amenity a = this.getAmenity(id);
			results.add(a);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	@Override
	public List<Cinema> getCinemasByAmenity(Amenity amenity) {
		return this.getCinemasByAmenity(amenity.getId());
	}

	@Override
	public List<Cinema> getCinemasByAmenity(int amenity_id) {
		// select A.name from cinema_amenity CA join Amenity A where CA.amenity
		// = A.id
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select C.id,C.name from cinema_amenity CA join Cinema C where CA.cinema_id = C.id and CA.amenity_id = "
				+ amenity_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Cinema> results = new ArrayList<Cinema>();
		for (Object object : data) {
			Map row = (Map) object;
			// System.out.println(row.get("name") + " " + row.get("id"));
			int id = Integer.parseInt(row.get("id").toString());
			Cinema c = this.getCinema(id);
			results.add(c);
		}
		session.getTransaction().commit();
		session.close();

		return results;
	}

	@Override
	public Owner getOwnerByCinema(Cinema cinema) {
		return this.getOwnerByCinema(cinema.getId());
	}

	@Override
	public Owner getOwnerByCinema(int cinema_id) {
		// select A.name from cinema_amenity CA join Amenity A where CA.amenity
		// = A.id
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "SELECT owner_id from owner_cinema WHere cinema_id="
				+ cinema_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		Map row = (Map) data.get(0);
		int id = Integer.parseInt(row.get("id").toString());
		Owner o = new OwnerHandler().getOwnerById(id);
		session.getTransaction().commit();
		session.close();
		return o;

	}

	@Override
	public List<Cinema> getCinemasByOwner(Owner owner) {
		return this.getCinemasByOwner(owner.getId());
	}

	@Override
	public List<Cinema> getCinemasByOwner(int owner_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "SELECT cinema_id from owner_cinema WHERE owner_id="
				+ owner_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Cinema> results = new ArrayList<Cinema>();
		for (Object object : data) {
			Map row = (Map) object;
			// System.out.println(row.get("name") + " " + row.get("id"));
			int id = Integer.parseInt(row.get("id").toString());
			Cinema c = this.getCinema(id);
			results.add(c);
		}
		session.getTransaction().commit();
		session.close();

		return results;
	}

	@Override
	public List<model.bean.Session> getSessionsByCinema(Cinema cinema) {
		return this.getSessionsByCinema(cinema.getId());
	}

	@Override
	public List<model.bean.Session> getSessionsByCinema(int cinema_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "SELECT id from session WHERE cinema_id=" + cinema_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<model.bean.Session> results = new ArrayList<model.bean.Session>();
		for (Object object : data) {
			Map row = (Map) object;
			// System.out.println(row.get("name") + " " + row.get("id"));
			int id = Integer.parseInt(row.get("id").toString());
			model.bean.Session c = new SessionHandler().getSession(id);
			results.add(c);
		}
		session.getTransaction().commit();
		session.close();

		return results;
	}

	@Override
	public Cinema getCinemaBySession(model.bean.Session session) {
		return this.getCinemaBySession(session.getId());
	}

	@Override
	public Cinema getCinemaBySession(int session_id) {
		// select A.name from cinema_amenity CA join Amenity A where CA.amenity
		// = A.id
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "SELECT cinema_id from session WHere id=" + session_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		Map row = (Map) data.get(0);
		int id = Integer.parseInt(row.get("id").toString());
		Cinema c = this.getCinema(id);
		session.getTransaction().commit();
		session.close();
		return c;
	}

	@Override
	public List<Movie> getMoviesByCinema(Cinema cinema) {
		return this.getMoviesByCinema(cinema.getId());
	}

	@Override
	public List<Movie> getMoviesByCinema(int cinema_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "SELECT movie_id from session WHERE cinema_id=" + cinema_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Movie> results = new ArrayList<Movie>();
		for (Object object : data) {
			Map row = (Map) object;
			// System.out.println(row.get("name") + " " + row.get("id"));
			int id = Integer.parseInt(row.get("movie_id").toString());
			Movie m = new MovieHandler().getMovie(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();

		return results;
	}

	@Override
	public List<Cinema> getCinemasByMovie(Movie movie) {
		return this.getCinemasByMovie(movie.getId());
	}

	@Override
	public List<Cinema> getCinemasByMovie(int movie_id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "SELECT cinema_id from session WHERE movie_id=" + movie_id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Cinema> results = new ArrayList<Cinema>();
		for (Object object : data) {
			Map row = (Map) object;
			// System.out.println(row.get("name") + " " + row.get("id"));
			int id = Integer.parseInt(row.get("cinema_id").toString());
			Cinema m = this.getCinema(id);
			results.add(m);
		}
		session.getTransaction().commit();
		session.close();

		return results;
	}

}
