package model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import model.bean.Amenity;
import model.bean.Cinema;
import model.bean.Owner;

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
public class CinemaTest {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@BeforeClass
	public static void beforeClass(){
	}
	
	@Test
	public void Amenitytest() {
		
		Session session = factory.openSession();
		session.beginTransaction();
		//operation
		//Cinema cinema = new Cinema("THE GRETA","ARA",300);
		
		Cinema c = (Cinema) session.get(Cinema.class,1);
		System.out.println("cinema name is "+c.getName());
		System.out.println("cinema amenity"+c.getAmenities());
		Set amens = c.getAmenities();
		Amenity newa = new Amenity("asdasd");
		amens.add(newa);
		c.setAmenities(amens);
		
		//NOT TEST REMOVE YET
		session.save(newa);
		session.update(c);
		
		//operation-finished
		System.out.println("updated");
		session.getTransaction().commit();
		System.out.println("commited");
		session.close();
	}
//	@Test
	public void CinemaOwnerTest(){
		System.out.println("CinemaOwnerTest");
		Session session = factory.openSession();
		session.beginTransaction();
		//operation
		Integer cinemaID = (Integer) session.save(new Cinema("bbbbb","ST",30));
		System.out.println("!!!!!!!Cinema id "+cinemaID);
		Cinema cinema = (Cinema) session.get(Cinema.class, cinemaID);
		System.out.println("!!!!!!!Cinema name "+cinema.getName());
		
//		Owner owner =(Owner) session.get(Owner.class, new Integer(1));
//		System.out.println("!!!!!!owner name "+owner.getUsername());
//		cinema.setOwner(owner);
		
		Owner owne2 = new Owner("awawefwe");
		Set<Cinema> c = new HashSet<Cinema>();
		c.add(cinema);
		owne2.setCinemas(c);		
//		cinema.setOwner(owne2);		
		session.save(owne2); //<<
//		session.save(cinema);		
		
		
		Owner o1 = (Owner)session.get(Owner.class, 1);
		System.out.println("o1 "+o1.getUsername()+"'s cinemas"+o1.getCinemas());
//		Iterator it = (Iterator) o1.getCinemas();
//		while(it.hasNext()){
//			Cinema c1 = (Cinema) it.next();
//			System.out.println(c1+" name is\t"+c1.getName());
//		}
		
//		cinema.setAmenities(amens);	
		//save to memory
//		session.save(cinema);
		
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
