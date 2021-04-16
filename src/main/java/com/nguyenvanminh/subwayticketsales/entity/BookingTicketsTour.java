package com.nguyenvanminh.subwayticketsales.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking_ticketstour")
public class BookingTicketsTour implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_id")
	private Booking booking;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ticketstourdetail_id")
	private TicketsTourDetail ticketsTourDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public TicketsTourDetail getTicketsTourDetail() {
		return ticketsTourDetail;
	}

	public void setTicketsTourDetail(TicketsTourDetail ticketsTourDetail) {
		this.ticketsTourDetail = ticketsTourDetail;
	}
	
	
}
