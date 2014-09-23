package model.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;

public class Genre {
	private int id;
	private String name;
	
	public Genre() {
		// TODO Auto-generated constructor stub
	}
	public Genre(String name) {
		this.name = name;
	}
	
	@Id@GeneratedValue@Column(name="id")
	public int getId() {
		return id;
	}
	@Column(name="name")@NotNull
	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
