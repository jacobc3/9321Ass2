package model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.bean.Amenity;
import model.bean.Cinema;
import model.handlerinterface.AmenityHandlerInterface;

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
public class AmenityTest {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	@BeforeClass
	public static void beforeClass(){
	}
	
	@Test
	public void test() {
		AmenityHandlerInterface ah = new AmenityHandler();
		//ah.getAllAmenities();
		List<Amenity> list = ah.getAllAmenities();
		for(Amenity c: list){
			System.out.println("id is "+c.getId()+" name is "+c.getName());
		}
		
	}

	@AfterClass
	public static void afterClass(){
		factory.close();
	}
	
}
