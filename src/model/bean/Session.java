package model.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;

@Entity
@Table(name="session")
public class Session {
	private int id;
	private Movie movie;
	private Cinema cinema;
	private Date showDate;
	
	@Id
	@GeneratedValue
	@NotNull
	@Column(name="id")
	public int getId() {
		return id;
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="movie_id")
	public Movie getMovie() {
		return movie;
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="cinema_id")
	public Cinema getCinema() {
		return cinema;
	}

	@Column(name="show_date")
	public Date getShowDate() {
		return showDate;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}


	public void setShowDate(Date show_date) {
		this.showDate = show_date;
	}


	public Session() {
	}
	
	public Session(Movie movie, Cinema cinema){
		this.movie = movie;
		this.cinema = cinema;
	}

}
