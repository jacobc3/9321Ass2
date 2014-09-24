package model.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.EnumType;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name="booking")
public class Booking {
	private int id;
	private Session session;
	private User user;
	private String cardNumber;
	private Date orderTime;
	private int count;
	private OrderStatus status;
	
	@Id@GeneratedValue@Column(name="id")@NotNull
	public int getId() {
		return id;
	}
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="session_id")
	public Session getSession() {
		return session;
	}
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	
	@Column(name="card_number")
	public String getCardNumber() {
		return cardNumber;
	}

	@Column(name="order_time")
	public Date getOrderTime() {
		return orderTime;
	}

	@Column(name="count")
	public int getCount() {
		return count;
	}

	@Column(name="status")
	@Enumerated(javax.persistence.EnumType.STRING)
	public OrderStatus getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Booking() {
	}

}
