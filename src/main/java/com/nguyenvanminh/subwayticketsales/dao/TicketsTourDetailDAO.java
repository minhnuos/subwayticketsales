package com.nguyenvanminh.subwayticketsales.dao;

import com.nguyenvanminh.subwayticketsales.entity.TicketsTourDetail;

public interface TicketsTourDetailDAO {

	public void addTicketsTourDetail(TicketsTourDetail ticketsTourDetail);
	public void updateTicketsTourDetail(TicketsTourDetail ticketsTourDetail);
	public TicketsTourDetail findTicketsTourDetailById(int id);
}
