package model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import model.bean.Amenity;
import model.bean.Cinema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;


/**
 * @author SephyZhou
 *
 */
public class DataHandlerTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@BeforeClass
	public static void beforeClass(){
	}
	
	@Test
	public void test() {
		
		//Session session = factory.openSession();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		//operation
		Cinema cinema = new Cinema("THE GRETA","ARA",300);
		Set<Amenity> amens = new HashSet<Amenity>();
		Amenity amen = (Amenity) session.get(Amenity.class, new Integer(2));
		amen.setName("BLABLA");
		amens.add(amen);
		amens.add((Amenity) session.get(Amenity.class, new Integer(1)));
		cinema.setAmenities(amens);
		
		//save to memory
		session.update(amen);	
		session.save(cinema);
		
		//operation-finished
		System.out.println("updated");
		session.getTransaction().commit();
		System.out.println("commited");
		session.close();
	}

	@AfterClass
	public static void afterClass(){
		factory.close();
	}
	
}
