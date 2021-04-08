package com.nguyenvanminh.subwayticketsales.modal;

public class TicketsTourDetailDTO {
	
	private int id;
	private boolean status;
	private TicketsTourDTO ticketsTourDTO;
	private String code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public TicketsTourDTO getTicketsTourDTO() {
		return ticketsTourDTO;
	}
	public void setTicketsTourDTO(TicketsTourDTO ticketsTourDTO) {
		this.ticketsTourDTO = ticketsTourDTO;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
