package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Cinema;
import model.bean.Movie;
import model.handlerinterface.AmenityHandlerInterface;

public class AmenityHandler implements AmenityHandlerInterface {

	public AmenityHandler() {
	}

	@Override
	public List<Amenity> getAllAmenities() {
		SessionFactory factory =  HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();		
		List<Amenity> amenities = session.createQuery("FROM Amenity").list();
		session.getTransaction().commit();
		session.close();
		return amenities;
	}

	@Override
	public List<Amenity> getAmenities(Cinema cinema) {
		//We can use Select ** from ** to retrive amenities's information
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		String sql = "select A.id,A.name from cinema_amenity CA join amenity A where CA.amenity_id = A.id and CA.cinema_id = "
				+ cinema.getId();
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();

		List<Amenity> results = new ArrayList<Amenity>();
		for (Object object : data) {
			Map row = (Map) object;
			System.out.println(row.get("name") + " " + row.get("id"));
			int id = Integer.parseInt(row.get("id").toString());
			System.out.println("A3.6 " + id);
			Amenity a = this.getAmenity(id);
			results.add(a);
		}
		session.getTransaction().commit();
		session.close();
		return results;
	}

	private Amenity getAmenity(int id) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Amenity a = (Amenity) session.get(Amenity.class, id);
		session.getTransaction().commit();
		session.close();
		return a;
	}

}
