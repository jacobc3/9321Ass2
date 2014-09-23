package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

public class User {

	private int id;
	private String username;
	private String email;
	
	private boolean emailOk;
	private String password;
	private String firstname;
	private String lastname;
	private Date registryDate;
	
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

	@Column(name="email_ok")
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
		// TODO Auto-generated constructor stub
	}

}
