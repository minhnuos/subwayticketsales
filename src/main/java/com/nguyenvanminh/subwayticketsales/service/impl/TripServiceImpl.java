package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.DayDAO;
import com.nguyenvanminh.subwayticketsales.dao.TripDAO;
import com.nguyenvanminh.subwayticketsales.entity.Day;
import com.nguyenvanminh.subwayticketsales.entity.Tickets;
import com.nguyenvanminh.subwayticketsales.entity.Trip;
import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.DepartureTimeDTO;
import com.nguyenvanminh.subwayticketsales.modal.RouteDTO;
import com.nguyenvanminh.subwayticketsales.modal.StopPointDTO;
import com.nguyenvanminh.subwayticketsales.modal.TicketsDTO;
import com.nguyenvanminh.subwayticketsales.modal.TripDTO;
import com.nguyenvanminh.subwayticketsales.service.DayService;
import com.nguyenvanminh.subwayticketsales.service.TripService;

@Service
@Transactional
public class TripServiceImpl implements TripService{

	@Autowired
	TripDAO tripDAO;
	@Autowired 
	DayDAO dayDAO;
	@Autowired
	DayService dayService;
	
	@Override
	public TripDTO getTripDTOLatest() {
		Trip trip = this.tripDAO.getTripLatest();
		TripDTO tripDTO = new TripDTO();
		if(trip != null) {
			tripDTO.setQuantity(trip.getQuantity());
			tripDTO.setPrice(trip.getPrice());
		} else {
			tripDTO.setQuantity(0);
			tripDTO.setPrice(0);
		}
		return tripDTO;
	}

	@Override
	public List<TripDTO> findTripDTOByDayDTO(DayDTO dayDTO) {
		if(dayDTO != null) {
			Day day = this.dayDAO.findDaybyDay(dayDTO.getDay());
			
			if(day != null) {
				List<Trip> listTrips = day.getListTrips();
				List<TripDTO> listTripDTOs = new ArrayList<TripDTO>();
				for (Trip trip : listTrips) {
					TripDTO tripDTO = new TripDTO();
					tripDTO.setId(trip.getId());
					tripDTO.setQuantity(trip.getQuantity());
					tripDTO.setPrice(trip.getPrice());
					tripDTO.setDayDTO(dayDTO);
					tripDTO.setRemain(trip.getRemain());
					DepartureTimeDTO departureTimeDTO = new DepartureTimeDTO();
					departureTimeDTO.setId(trip.getDepartureTime().getId());
					departureTimeDTO.setTime(trip.getDepartureTime().getTime());
					
					RouteDTO routeDTO = new RouteDTO();
					routeDTO.setId(trip.getRoute().getId());
					StopPointDTO stopPointDTOStart = new StopPointDTO();
					stopPointDTOStart.setName(trip.getRoute().getStopPointStart().getName());
					routeDTO.setStopPointDTOStart(stopPointDTOStart);
					StopPointDTO stopPointDTOEnd = new StopPointDTO();
					stopPointDTOEnd.setName(trip.getRoute().getStopPointEnd().getName());
					routeDTO.setStopPointDTOEnd(stopPointDTOEnd);
					
					tripDTO.setDepartureTimeDTO(departureTimeDTO);
					tripDTO.setRouteDTO(routeDTO);
					listTripDTOs.add(tripDTO);
				}
				return listTripDTOs;
			} else {
				return null;
			}
		} else {
			return null;
		}
		
		
		
	}

	@Override
	public TripDTO findTripDTOById(int id) {
		Trip trip = this.tripDAO.findTripById(id);
		TripDTO tripDTO = new TripDTO();
		tripDTO.setId(trip.getId());
		List<TicketsDTO> ticketsDTOs = new ArrayList<TicketsDTO>();
		for (Tickets tickets : trip.getTickets()) {
			TicketsDTO ticketsDTO = new TicketsDTO();
			ticketsDTO.setId(tickets.getId());
			ticketsDTO.setCode(tickets.getCode());
			ticketsDTO.setStatus(tickets.isStatus());
			ticketsDTOs.add(ticketsDTO);
		}
		tripDTO.setTicketsDTOs(ticketsDTOs);
		return tripDTO;
	}

	

}
