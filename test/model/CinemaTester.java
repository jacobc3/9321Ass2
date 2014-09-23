package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Cinema;
import model.handlerinterface.CinemaHandlerInterface;

public class CinemaTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();

	@BeforeClass
	public static void beforeClass() {
	}

	@Test
	public void test() {
		//LOAD TEST, FAILED
		Session session = factory.openSession();
		CinemaHandlerInterface ch = new CinemaHandler();
//		List<Cinema> list = ch.getAllCinemas();
//		for(Cinema c: list){
//			System.out.println("id is "+c.getId()+" name is "+c.getName()+" Amenity "); //CANT GET AMENITY, WHY?
//			Amenity a0 = c.getAmenities().iterator().next();
//			System.out.println("???");
//			Amenity a1 = (Amenity) session.get(Amenity.class, a0);
//			System.out.println(">>>"+a1);
//		}
		Cinema c = ch.getCinema(2);
		for(Amenity a : c.getAmenities()){
			System.out.println("???"+a.getName());
		}
		
	}
	
//	@Test
	public void updateTest(){
		//PASSED
		CinemaHandlerInterface ch = new CinemaHandler();
		Cinema c = ch.getCinema(10);
		c.setCapacity(10000);
		ch.updateCinema(c);
	}
	@Test
	public void AmenityTest(){
		//SAVE TEST, PASSED
		CinemaHandlerInterface ch = new CinemaHandler();
		Cinema c = ch.getCinema(1);
		Set<Amenity> am = new HashSet<Amenity>();
		am.add(new Amenity("??FEFWE"));
		c.setAmenities(am);
		ch.updateCinema(c);
	}

	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
