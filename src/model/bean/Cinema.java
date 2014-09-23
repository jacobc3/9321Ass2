package model.bean;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cinemas")
public class Cinema {
/**
 * id INT NOT NULL auto_increment,
	name VARCHAR(40) default NULL,
	location VARCHAR(100) default NULL,
	capacity INT default NULL,
 */
	
	private int id;	
	private String name;
	private String location;
	private int capacity;
	private Set<Amenity> amenities = new HashSet<Amenity>();
	
	public Cinema() {		
	}
	public Cinema(String name, String location, int capacity) {
		this.name = name;
		this.location = location;
		this.capacity = capacity;
	}
	
	@Id @GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "capacity")
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	 //TODO BUG here
	public Set<Amenity> getAmenities() {
		return amenities;
	}
	public void setAmenities(Set<Amenity> amenities) {
		this.amenities = amenities;
	}

}
