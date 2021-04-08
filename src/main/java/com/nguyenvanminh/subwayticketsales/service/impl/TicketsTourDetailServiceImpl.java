package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.TicketsTourDetailDAO;

import com.nguyenvanminh.subwayticketsales.modal.TicketsTourDetailDTO;
import com.nguyenvanminh.subwayticketsales.service.TicketsTourDetailService;
@Service
@Transactional
public class TicketsTourDetailServiceImpl implements TicketsTourDetailService{

	@Autowired
	TicketsTourDetailDAO ticketsTourDetailDAO;

	@Override
	public void addTicketsTourDetailDTO(TicketsTourDetailDTO ticketsTourDetailDTO) {
		
		
	}

	
}
