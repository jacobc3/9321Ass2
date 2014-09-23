package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name="ticket_order")
public class TicketOrder {
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
	@Column(name="session_id")
	public Session getSession() {
		return session;
	}
	@Column(name="user_id")
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

	public TicketOrder() {
		// TODO Auto-generated constructor stub
	}

}
