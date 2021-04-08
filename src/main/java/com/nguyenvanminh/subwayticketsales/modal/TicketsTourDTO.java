package com.nguyenvanminh.subwayticketsales.modal;

import java.util.List;

public class TicketsTourDTO {

	private int id;
	
	private RouteDTO routeDTO;
	
	private DayDTO dayDTO;
	
	private int quantity;
	
	private int price;

	
	private List<TicketsTourDetailDTO> ticketsTourDetailDTOs;
	
	private int remain;
	
	public int getRemain() {
		return remain;
	}

	public void setRemain(int remain) {
		this.remain = remain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RouteDTO getRouteDTO() {
		return routeDTO;
	}

	public void setRouteDTO(RouteDTO routeDTO) {
		this.routeDTO = routeDTO;
	}

	public DayDTO getDayDTO() {
		return dayDTO;
	}

	public void setDayDTO(DayDTO dayDTO) {
		this.dayDTO = dayDTO;
	}

	

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<TicketsTourDetailDTO> getTicketsTourDetailDTOs() {
		return ticketsTourDetailDTOs;
	}

	public void setTicketsTourDetailDTOs(List<TicketsTourDetailDTO> ticketsTourDetailDTOs) {
		this.ticketsTourDetailDTOs = ticketsTourDetailDTOs;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
