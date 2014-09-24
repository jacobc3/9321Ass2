package model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="amenity")
public class Amenity implements java.io.Serializable {
	
	private int id;
	private String name;
	private Set<Cinema> cinemas;
	
	public Amenity() {
	}

	public Amenity(String name) {
		this.name = name;
	}
	
	@Id @GeneratedValue
	@Column(name = "id",unique = true, nullable = false)
	public int getId() {
		return id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@ManyToMany(mappedBy="amenities",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	public Set<Cinema> getCinemas() {
		return cinemas;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}	

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		Amenity obj2 = (Amenity) obj;
		if ((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (id + name).hashCode();
		return tmp;
	}



	public void setCinemas(Set<Cinema> cinemas) {
		this.cinemas = cinemas;
	}
	

}
