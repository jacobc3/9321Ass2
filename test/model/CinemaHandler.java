package model;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.*;
import model.bean.Amenity;
import model.bean.Cinema;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class CinemaHandler {
	private static SessionFactory factory;

	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "deprecation" })
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Amenity amen = (Amenity) session.get(Amenity.class, 1);
			amen.setName("BLABLA");
			System.out.println(amen.getName());
			session.update(amen);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	public Set getAmenities(Integer cinemaID){
		Session session = factory.openSession();
		Transaction tx = null;
		Set amenities = null;

		try {
			tx = session.beginTransaction();
			/*
			 * Cinema employee = (Cinema) session.get(Cinema.class,
					EmployeeID);
			employee.setCapacity(capacity);
			session.update(employee);
			 */
			Cinema cinema= (Cinema) session.get(Cinema.class, cinemaID);
			amenities = cinema.getAmenities();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return amenities;
	}
	/* Method to add an employee record in the database */
	public Integer addCinema(String name, String location, int capacity, Set amenities) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer cinemaID = null;

		try {
			tx = session.beginTransaction();
			Cinema cinema= new Cinema(name, location, capacity);
			cinema.setAmenities(amenities);
			cinemaID = (Integer) session.save(cinema);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cinemaID;
	}

	/* Method to list all the employees detail */
	public void listEmployees() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Cinema").list();
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Cinema employee = (Cinema) iterator1.next();
				System.out.println("Name: " + employee.getName());
				Set certificates = employee.getAmenities();
				for (Iterator iterator2 = certificates.iterator(); iterator2
						.hasNext();) {
					Amenity certName = (Amenity) iterator2.next();
					System.out.println("Certificate: " + certName.getName());
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to update salary for an employee */
	public void updateEmployee(Integer EmployeeID, int capacity) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cinema employee = (Cinema) session.get(Cinema.class,
					EmployeeID);
			employee.setCapacity(capacity);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to delete an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Cinema employee =

			(Cinema) session.get(Cinema.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}