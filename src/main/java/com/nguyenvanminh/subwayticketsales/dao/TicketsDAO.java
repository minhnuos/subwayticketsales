package com.nguyenvanminh.subwayticketsales.dao;

import com.nguyenvanminh.subwayticketsales.entity.Tickets;

public interface TicketsDAO {

	public void addTickets(Tickets tickets);
	public void update(Tickets tickets);
	public Tickets findTicketsById(int id);
}
