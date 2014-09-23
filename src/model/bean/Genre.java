package model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name = "genre")
public class Genre {
	private int id;
	private String name;
	private Set<Movie> movies = new HashSet<Movie>();

	public Genre() {
		// TODO Auto-generated constructor stub
	}

	public Genre(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "name")
	@NotNull
	public String getName() {
		return name;
	}

	@ManyToMany(mappedBy = "genres",cascade=CascadeType.ALL)
	public Set<Movie> getMovies() {
		return movies;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

}
