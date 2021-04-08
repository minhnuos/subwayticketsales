package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.TicketsTourDTO;

public interface TicketsTourService {

	public List<TicketsTourDTO> findListTicketsTourDTOsByDay(String day);
	
	public TicketsTourDTO findTicketsTourDTOById(int id);
}
