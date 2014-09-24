package model;

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
import model.handlerinterface.CinemaHandlerInterface;

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
	public List<Cinema> getCinemas(Amenity amenity) {
		// select A.name from cinema_amenity CA join Amenity A where CA.amenity
		// = A.id
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select C.id,C.name from cinema_amenity CA join Cinema C where CA.cinema_id = C.id and CA.amenity_id = "
				+ amenity.getId();
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		System.out.println("A1");
		List data = query.list();
		System.out.println("A2");
		
		List<Cinema> results = new ArrayList<Cinema>();
		for (Object object : data) {
			System.out.println("A3" + object);
			Map row = (Map) object;
			System.out.println(row.get("name") + " " + row.get("id"));
			System.out.println("A3.5");
			int id = Integer.parseInt(row.get("id").toString());
			System.out.println("A3.6 "+id);
			Cinema c = this.getCinema(id);
			results.add(c);
			System.out.println("A3.7");
		}
		System.out.println("A4");
		session.getTransaction().commit();
		session.close();
		
		System.out.println("A5" + results);
		
		return results;
	}

}
