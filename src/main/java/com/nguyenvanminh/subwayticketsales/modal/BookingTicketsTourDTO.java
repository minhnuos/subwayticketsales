package com.nguyenvanminh.subwayticketsales.modal;

public class BookingTicketsTourDTO {

	private int id;
	
	private BookingDTO bookingDTO;
	
	private TicketsTourDetailDTO ticketsTourDetailDTO;

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

	public TicketsTourDetailDTO getTicketsTourDetailDTO() {
		return ticketsTourDetailDTO;
	}

	public void setTicketsTourDetailDTO(TicketsTourDetailDTO ticketsTourDetailDTO) {
		this.ticketsTourDetailDTO = ticketsTourDetailDTO;
	}
	
	
}
