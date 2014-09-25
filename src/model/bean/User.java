package model.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="user")
public class User {

	private int id;
	private String username;
	private String email;
	
	private boolean emailOk;
	private String password;
	private String firstname;
	private String lastname;
	private String nickname;
	private Date registryDate;
	
//	private Set<Review> review = new HashSet<Review>();
	
	@Id@GeneratedValue@Column(name="id")@NotNull
	public int getId() {
		return id;
	}

	@Column(name="username")@NotNull
	public String getUsername() {
		return username;
	}

	@Column(name="email")@NotNull
	public String getEmail() {
		return email;
	}

	@Column(name="email_ok")@Type(type="yes_no")
	public boolean isEmailOk() {
		return emailOk;
	}

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	@Column(name="firstname")
	public String getFirstname() {
		return firstname;
	}

	@Column(name="lastname")
	public String getLastname() {
		return lastname;
	}

	@Column(name="registry_date")
	public Date getregistryDate() {
		return registryDate;
	}
	
	@Column(name="nickname")
	public String getNickname() {
		return nickname;
	}

//	public Set<Review> getReview() {
//		return review;
//	}
	

	public void setId(int id) {
		this.id = id;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setEmailOk(boolean emailOk) {
		this.emailOk = emailOk;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}

	public User() {
	}
	
	public User(String username,String email){
		this.username = username;
		this.email = email;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	

//	public void setReview(Set<Review> review) {
//		this.review = review;
//	}

}
