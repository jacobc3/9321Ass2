package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Cinema;
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

}
