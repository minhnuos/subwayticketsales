package com.nguyenvanminh.subwayticketsales.dao;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.entity.TicketsTour;

public interface TicketsTourDAO {

	public void addTicketsTour(TicketsTour ticketsTour);
	
	public List<TicketsTour> listTicketsTours();
	
	public TicketsTour findTicketsTourById(int id);
	
	public void updateTicketsTour(TicketsTour ticketsTour);
}
