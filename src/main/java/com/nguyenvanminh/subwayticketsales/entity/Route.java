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
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="route")
public class Route implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="start_id")
	private StopPoint stopPointStart;
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="end_id")
	private StopPoint stopPointEnd;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="route_id")
	private List<Trip> trips;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="route_id")
	private List<TicketsTour> ticketsTours;
	
	
	public List<Trip> getTrips() {
		return trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public List<TicketsTour> getTicketsTours() {
		return ticketsTours;
	}

	public void setTicketsTours(List<TicketsTour> ticketsTours) {
		this.ticketsTours = ticketsTours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StopPoint getStopPointStart() {
		return stopPointStart;
	}

	public void setStopPointStart(StopPoint stopPointStart) {
		this.stopPointStart = stopPointStart;
	}

	public StopPoint getStopPointEnd() {
		return stopPointEnd;
	}

	public void setStopPointEnd(StopPoint stopPointEnd) {
		this.stopPointEnd = stopPointEnd;
	}
	
	
}
