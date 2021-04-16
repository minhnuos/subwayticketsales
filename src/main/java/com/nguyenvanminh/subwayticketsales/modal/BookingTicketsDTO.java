package com.nguyenvanminh.subwayticketsales.modal;

public class BookingTicketsDTO {

	private int id;
	
	private BookingDTO bookingDTO;
	
	private TicketsDTO ticketsDTO;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BookingDTO getBookingDTO() {
		return bookingDTO;
	}

	public void setBookingDTO(BookingDTO bookingDTO) {
		this.bookingDTO = bookingDTO;
	}

	public TicketsDTO getTicketsDTO() {
		return ticketsDTO;
	}

	public void setTicketsDTO(TicketsDTO ticketsDTO) {
		this.ticketsDTO = ticketsDTO;
	}
	
	
}
