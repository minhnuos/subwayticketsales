package com.nguyenvanminh.subwayticketsales.modal;

import java.util.List;

public class TripDTO {

	private int id;
	
	private DayDTO dayDTO;
	
	private DepartureTimeDTO departureTimeDTO;
	
	private RouteDTO routeDTO;
	
	private int quantity;

	private int price;
	
	private int remain;
	
	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}
	
	private List<TicketsDTO> ticketsDTOs;
	
	public List<TicketsDTO> getTicketsDTOs() {
		return ticketsDTOs;
	}

	public void setTicketsDTOs(List<TicketsDTO> ticketsDTOs) {
		this.ticketsDTOs = ticketsDTOs;
	}

	public int getPrice() {
		return price;
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

	public DayDTO getDayDTO() {
		return dayDTO;
	}

	public void setDayDTO(DayDTO dayDTO) {
		this.dayDTO = dayDTO;
	}

	public DepartureTimeDTO getDepartureTimeDTO() {
		return departureTimeDTO;
	}

	public void setDepartureTimeDTO(DepartureTimeDTO departureTimeDTO) {
		this.departureTimeDTO = departureTimeDTO;
	}

	public RouteDTO getRouteDTO() {
		return routeDTO;
	}

	public void setRouteDTO(RouteDTO routeDTO) {
		this.routeDTO = routeDTO;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
