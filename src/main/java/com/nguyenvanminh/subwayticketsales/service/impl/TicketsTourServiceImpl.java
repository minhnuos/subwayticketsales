package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.DayDAO;
import com.nguyenvanminh.subwayticketsales.dao.TicketsTourDAO;
import com.nguyenvanminh.subwayticketsales.entity.Day;
import com.nguyenvanminh.subwayticketsales.entity.Tickets;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTour;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTourDetail;
import com.nguyenvanminh.subwayticketsales.entity.Trip;
import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.RouteDTO;
import com.nguyenvanminh.subwayticketsales.modal.StopPointDTO;
import com.nguyenvanminh.subwayticketsales.modal.TicketsDTO;
import com.nguyenvanminh.subwayticketsales.modal.TicketsTourDTO;
import com.nguyenvanminh.subwayticketsales.modal.TicketsTourDetailDTO;
import com.nguyenvanminh.subwayticketsales.modal.TripDTO;
import com.nguyenvanminh.subwayticketsales.service.DayService;
import com.nguyenvanminh.subwayticketsales.service.TicketsTourService;

@Service
@Transactional
public class TicketsTourServiceImpl implements TicketsTourService{

	@Autowired
	DayService dayService;

	@Autowired
	DayDAO dayDAO;
	
	@Autowired
	TicketsTourDAO ticketsTourDAO;
	
	@Override
	public List<TicketsTourDTO> findListTicketsTourDTOsByDay(String day) {
		Day findDay = this.dayDAO.findDaybyDay(day);
		if(findDay != null) {
			DayDTO dayDTO = this.dayService.findDayDTOByDay(day);
			List<TicketsTourDTO> listTicketsTourDTOs = new ArrayList<TicketsTourDTO>();
			for (TicketsTour ticketsTour : findDay.getListTicketsTours()) {
				TicketsTourDTO ticketsTourDTO = new TicketsTourDTO();
				ticketsTourDTO.setId(ticketsTour.getId());
				ticketsTourDTO.setRemain(ticketsTour.getRemain());
				ticketsTourDTO.setPrice(ticketsTour.getPrice());
				ticketsTourDTO.setQuantity(ticketsTour.getQuantity());
				ticketsTourDTO.setDayDTO(dayDTO);
				RouteDTO routeDTO = new RouteDTO();
				routeDTO.setId(ticketsTour.getRoute().getId());
				StopPointDTO stopPointDTOStart = new StopPointDTO();
				stopPointDTOStart.setId(ticketsTour.getRoute().getStopPointStart().getId());
				stopPointDTOStart.setName(ticketsTour.getRoute().getStopPointStart().getName());
				stopPointDTOStart.setAddress(ticketsTour.getRoute().getStopPointStart().getAddress());
				StopPointDTO stopPointDTOEnd = new StopPointDTO();
				stopPointDTOEnd.setId(ticketsTour.getRoute().getStopPointEnd().getId());
				stopPointDTOEnd.setName(ticketsTour.getRoute().getStopPointEnd().getName());
				stopPointDTOEnd.setAddress(ticketsTour.getRoute().getStopPointEnd().getAddress());
				routeDTO.setStopPointDTOStart(stopPointDTOStart);
				routeDTO.setStopPointDTOEnd(stopPointDTOEnd);
				
				ticketsTourDTO.setRouteDTO(routeDTO);
				
				listTicketsTourDTOs.add(ticketsTourDTO);
				
			}
			return listTicketsTourDTOs;
		}
		return null; 
	}


	@Override
	public TicketsTourDTO findTicketsTourDTOById(int id) {
		
			TicketsTour ticketsTour = this.ticketsTourDAO.findTicketsTourById(id);
			TicketsTourDTO ticketsTourDTO = new TicketsTourDTO();
			ticketsTourDTO.setId(ticketsTour.getId());
			List<TicketsTourDetailDTO> ticketsTourDetailDTOs = new ArrayList<TicketsTourDetailDTO>();
			for (TicketsTourDetail ticketsTourDetail : ticketsTour.getTicketsTourDetails()) {
				TicketsTourDetailDTO ticketsTourDetailDTO = new TicketsTourDetailDTO();
				ticketsTourDetailDTO.setStatus(ticketsTourDetail.isStatus());
				ticketsTourDetailDTO.setCode(ticketsTourDetail.getCode());
				ticketsTourDetailDTOs.add(ticketsTourDetailDTO);
			}
			ticketsTourDTO.setTicketsTourDetailDTOs(ticketsTourDetailDTOs);
		

		return ticketsTourDTO;
	}

}
