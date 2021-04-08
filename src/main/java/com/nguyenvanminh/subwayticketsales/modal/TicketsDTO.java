package com.nguyenvanminh.subwayticketsales.modal;

public class TicketsDTO {

	private int id;
	
	private TripDTO tripDTO;
	
	private String code;
	
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TripDTO getTripDTO() {
		return tripDTO;
	}

	public void setTripDTO(TripDTO tripDTO) {
		this.tripDTO = tripDTO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	
	
}
