package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Session {
	private int id;
	private Movie movie;
	private Cinema cinema;
	private Date showDate;
	
	@Id
	public int getId() {
		return id;
	}

	@Column(name="movie_id")
	public Movie getMovie() {
		return movie;
	}

	@Column(name="cinema_id")
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


	public void setMovie_id(Movie movie) {
		this.movie = movie;
	}


	public void setCinema_id(Cinema cinema) {
		this.cinema = cinema;
	}


	public void setShowDate(Date show_date) {
		this.showDate = show_date;
	}


	public Session() {
		// TODO Auto-generated constructor stub
	}

}
