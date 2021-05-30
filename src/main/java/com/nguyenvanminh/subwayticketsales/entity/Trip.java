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
@Table(name="trip")
public class Trip implements Serializable{

	
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="departuretime_id")
	private DepartureTime departureTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="route_id")
	private Route route;
	
	
	
	
	private int quantity;

	private int price;
	
	public int getPrice() {
		return price;
	}

	private int remain;
	
	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	@OneToMany(cascade =  CascadeType.ALL)
	@JoinColumn(name="trip_id")
	private List<Tickets> tickets;
	
	public List<Tickets> getTickets() {
		return tickets;
	}

	public void setTickets(List<Tickets> tickets) {
		this.tickets = tickets;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public DepartureTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(DepartureTime departureTime) {
		this.departureTime = departureTime;
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
	
	
	
}
