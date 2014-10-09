package model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
/**
 * create table owners (
	id INT NOT NULL auto_increment,
	username VARCHAR(40) NOT NULL,
	password VARCHAR(40) default NULL,
	PRIMARY KEY (id)
);
 */
	
	private int id;
	private String username;
	private String password;
	
	@Id
	@GeneratedValue@Column(name="id")
	public int getId() {
		return id;
	}
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Owner() {
	}
	
	public Owner(String username) {
		this.username = username;
	}
	

}
