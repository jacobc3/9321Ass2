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

@Entity@Table(name="review")
public class Review {

	private int id;
	private String title;
	private User user;
	private Movie movie;
	private Date postDate;
	private String content;
	
	@Id
	@GeneratedValue
	@NotNull
	@Column(name="id")
	public int getId() {
		return id;
	}

	@Column(name="title")@NotNull
	public String getTitle() {
		return title;
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="movie_id")
	public Movie getMovie() {
		return movie;
	}

	@Column(name="post_date")
	public Date getPostDate() {
		return postDate;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}


	public void setContent(String content) {
		this.content = content;
	}


	
	
	public Review() {
	}

	public Review(String title) {
		this.title=title;
	}

}
