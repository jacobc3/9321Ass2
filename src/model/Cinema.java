package model;
import java.util.HashSet;
import java.util.Set;


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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Set<Amenity> getAmenities() {
		return amenities;
	}
	public void setAmenities(Set<Amenity> amenities) {
		this.amenities = amenities;
	}

}
