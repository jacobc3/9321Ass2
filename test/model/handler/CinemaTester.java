package model.handler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javassist.bytecode.Descriptor.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;
import model.bean.Amenity;
import model.bean.Cinema;
import model.handler.CinemaHandler;
import model.handlerInterface.CinemaHandlerInterface;

public class CinemaTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public CinemaHandlerInterface ch = new CinemaHandler();
	@BeforeClass
	public static void beforeClass() {
	}

	@Test
	public void addAmenityToCinemaTest(){
		Cinema c1 = ch.getCinema(1);
		Set<Amenity> as = c1.getAmenities();
		as.add(ch.getAmenity(9));
		c1.setAmenities(as);
		ch.updateCinema(c1);
	}
	
	
//	@Test
	public void allAmenitytester(){
		Cinema c1 = ch.getCinema(1);
		System.out.println("cinema title "+c1.getName());
		List<Amenity> a = ch.getAmenitiesByCinema(c1);
//		System.out.println("has amenities:");
//		for(Amenity am : a){
//			System.out.print("amenity name:\t"+am.getName()+"\ninclude Cinema:"+ch.getCinemasByAmenity(am)+"\n\n");			
//		}
		Amenity a1 =a.get(0);
		System.out.println("Amenity "+a1.getName()+"\t"+a1.getId());
		List<Cinema> clist = ch.getCinemasByAmenity(a1);
		for(Cinema c: clist){
			System.out.println("cinema:\t"+c.getName()+"\t"+c.getId());
			
		}
		
		
		
		
	}
	
	
//	@Test
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
//	@Test
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
