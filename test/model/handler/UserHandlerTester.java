package model.handler;

import static org.junit.Assert.*;

import java.util.List;

import model.bean.Movie;
import model.bean.User;
import model.handlerInterface.MovieHandlerInterface;
import model.handlerInterface.UserHandlerInterface;

import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.HibernateUtil;

public class UserHandlerTester {
	public static SessionFactory factory = HibernateUtil.getSessionFactory();
	public UserHandlerInterface mh =  new UserHandler();
	@BeforeClass
	public static void beforeClass() {
	}

//	@Test
	public void newUserTest(){
		User u = new User("abc","abc@abc.com");
		int id = mh.addUser(u);
		System.out.println("id is "+id);
	}
//	@Test
	public void updateUserTest(){
		User u = mh.getUserById(10);
		u.setEmailOk(true);
		mh.updateUser(u);
		User u2 = mh.getUserById(10);
		System.out.println("id is "+u2.getId()+" emaail? "+u2.isEmailOk());
	}
	
	@Test
	public void alltest() {
		List<User> ms = mh.getAllUsers();
		for(User m : ms){
			System.out.println(m.getEmail()+"\t"+m.getUsername()+"\t");
		}
	}
	
	@AfterClass
	public static void afterClass() {
		factory.close();
	}

}
