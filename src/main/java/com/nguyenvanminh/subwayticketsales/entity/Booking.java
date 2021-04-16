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
@Table(name="booking")
public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int total;
	
	private String time;
	
	private boolean status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private List<BookingTickets> bookingTickets;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private List<BookingTicketsTour> bookingTicketsTours;
	
	public List<BookingTickets> getBookingTickets() {
		return bookingTickets;
	}

	public void setBookingTickets(List<BookingTickets> bookingTickets) {
		this.bookingTickets = bookingTickets;
	}

	public List<BookingTicketsTour> getBookingTicketsTours() {
		return bookingTicketsTours;
	}

	public void setBookingTicketsTours(List<BookingTicketsTour> bookingTicketsTours) {
		this.bookingTicketsTours = bookingTicketsTours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
