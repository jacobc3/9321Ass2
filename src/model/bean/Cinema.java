package model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "cinema")
public class Cinema {
	/**
	 * id INT NOT NULL auto_increment, name VARCHAR(40) default NULL, location
	 * VARCHAR(100) default NULL, capacity INT default NULL,
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

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "location")
	public String getLocation() {
		return location;
	}
	
	@ManyToMany(targetEntity=Amenity.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="cinema_amenity",
				joinColumns={@JoinColumn(name="cinema_id")},
				inverseJoinColumns={@JoinColumn(name="amenity_id")})
	public Set<Amenity> getAmenities() {
		return amenities;
	}
	
	@Column(name = "capacity")
	public int getCapacity() {
		return capacity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setAmenities(Set<Amenity> amenities) {
		this.amenities = amenities;
	}


}
