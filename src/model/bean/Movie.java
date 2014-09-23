package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class Movie {
	private int id;
	private String title;
	private Date release_date;
	private String actors;
	private String synopsis;
	
	public Movie() {
		// TODO Auto-generated constructor stub
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

	

}
