package com.nguyenvanminh.subwayticketsales.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ticketstourdetail")
public class TicketsTourDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name="ticketstour_id")
	@ManyToOne
	private TicketsTour ticketsTour;
	
	private String code;
	
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TicketsTour getTicketsTour() {
		return ticketsTour;
	}

	public void setTicketsTour(TicketsTour ticketsTour) {
		this.ticketsTour = ticketsTour;
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
