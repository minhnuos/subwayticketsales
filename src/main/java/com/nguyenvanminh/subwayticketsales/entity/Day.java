package com.nguyenvanminh.subwayticketsales.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="day")
public class Day implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String day;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="day_id")
	private List<Trip> listTrips;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="day_id")
	private List<TicketsTour> listTicketsTours;
	
	
	public List<TicketsTour> getListTicketsTours() {
		return listTicketsTours;
	}
	public void setListTicketsTours(List<TicketsTour> listTicketsTours) {
		this.listTicketsTours = listTicketsTours;
	}
	public List<Trip> getListTrips() {
		return listTrips;
	}
	public void setListTrips(List<Trip> listTrips) {
		this.listTrips = listTrips;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
	
	
}
