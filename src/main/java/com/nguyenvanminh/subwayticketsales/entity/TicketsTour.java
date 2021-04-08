package com.nguyenvanminh.subwayticketsales.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ticketstour")
public class TicketsTour implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="day_id")
	private Day day;
	
	@JoinColumn(name="route_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Route route;
	
	private int quantity;
	
	private int price;

	private int remain;
	
	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ticketstour_id")
	private List<TicketsTourDetail> ticketsTourDetails;
	
	

	public List<TicketsTourDetail> getTicketsTourDetails() {
		return ticketsTourDetails;
	}

	public void setTicketsTourDetails(List<TicketsTourDetail> ticketsTourDetails) {
		this.ticketsTourDetails = ticketsTourDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
