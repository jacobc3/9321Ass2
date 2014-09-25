package model.bean;

import java.util.Date;
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

@Entity
@Table(name="movie")
public class Movie {
	private int id;
	private String title;
	private Date release_date;
	private String actors;
	private String synopsis;
	private Set<Genre> genres = new HashSet<Genre>();
	
	public Movie() {
	}
	public Movie(String title) {
		this.title = title;
	}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	
	@Column(name="title")
	@NotNull
	public String getTitle() {
		return title;
	}
	@Column(name="release_date")
	public Date getRelease_date() {
		return release_date;
	}
	@Column(name="actors")
	public String getActors() {
		return actors;
	}
	@Column(name="synopsis")
	public String getSynopsis() {
		return synopsis;
	}
	
	@ManyToMany(targetEntity=Genre.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="movie_genre",
				joinColumns={@JoinColumn(name="movie_id")},
				inverseJoinColumns={@JoinColumn(name="genre_id")})
	public Set<Genre> getGenres() {
		return genres;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	

}
