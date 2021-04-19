package com.nguyenvanminh.subwayticketsales.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.DayDAO;
import com.nguyenvanminh.subwayticketsales.dao.DepartureTimeDAO;
import com.nguyenvanminh.subwayticketsales.dao.RouteDAO;
import com.nguyenvanminh.subwayticketsales.dao.TicketsDAO;
import com.nguyenvanminh.subwayticketsales.dao.TicketsTourDAO;
import com.nguyenvanminh.subwayticketsales.dao.TicketsTourDetailDAO;
import com.nguyenvanminh.subwayticketsales.dao.TripDAO;
import com.nguyenvanminh.subwayticketsales.entity.Day;
import com.nguyenvanminh.subwayticketsales.entity.DepartureTime;
import com.nguyenvanminh.subwayticketsales.entity.Route;
import com.nguyenvanminh.subwayticketsales.entity.Tickets;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTour;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTourDetail;
import com.nguyenvanminh.subwayticketsales.entity.Trip;
import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.Slug;
import com.nguyenvanminh.subwayticketsales.service.DayService;

@Service
@Transactional
public class DayServiceImpl implements DayService{
	
	@Autowired
	DayDAO dayDAO;
	
	@Autowired
	RouteDAO routeDAO;
	
	@Autowired
	DepartureTimeDAO departureTimeDAO;
	
	@Autowired
	TripDAO tripDAO;
	
	@Autowired
	TicketsDAO ticketsDAO;
	
	@Autowired 
	TicketsTourDAO ticksTourDAO;

	@Autowired
	TicketsTourDetailDAO ticketsTourDetailDAO;
	
	@Override
	public void addDayDTO(DayDTO dayDTO,int quantity, int price) {
		// TODO Auto-generated method stub
		Day day = new Day();
		day.setDay(dayDTO.getDay());
		this.dayDAO.addDay(day);
		
		List<Day> listDays = this.dayDAO.listDays();
		
		List<Route> listRoutes = this.routeDAO.listRoute();
		
		List<DepartureTime> listDepartureTimes = this.departureTimeDAO.listDepartureTimes();
		
		Day dayLatest = listDays.get(listDays.size() - 1);
		
		for (Route route : listRoutes) {
			for (DepartureTime departureTime : listDepartureTimes) {
				Trip trip = new Trip();
				trip.setDepartureTime(departureTime);
				trip.setDay(dayLatest);
				trip.setRoute(route);
				trip.setQuantity(quantity);
				trip.setPrice(price);
				trip.setRemain(quantity);
				this.tripDAO.addTrip(trip);
				Trip tripLatest = this.tripDAO.getTripLatest();
				String code = Slug.makeSlug(route.getStopPointStart().getName()) + "_" +
						Slug.makeSlug(route.getStopPointEnd().getName() + "_" + 
								dayLatest.getDay() + "_" + departureTime.getTime() + "h_"
				);
				for (int i = 0; i < quantity; i++) {
					Tickets tickets = new Tickets();
					tickets.setStatus(true);
					tickets.setTrip(tripLatest);
					if(i < 10) {
						tickets.setCode(code.concat("0").concat(String.valueOf(i)));
					} else {
						tickets.setCode(code.concat(String.valueOf(i)));
					}
					this.ticketsDAO.addTickets(tickets);
				}
			}
	
		}
		
		for (Route route2 : listRoutes) {
			Trip tripLatest = this.tripDAO.getTripLatest();
			String code =  "tour_" + Slug.makeSlug(route2.getStopPointStart().getName()) + "_" +
					Slug.makeSlug(route2.getStopPointEnd().getName() + "_" + 
							dayLatest.getDay() + "_"
			);
			TicketsTour ticketsTour = new TicketsTour();
			ticketsTour.setDay(tripLatest.getDay());
			ticketsTour.setRoute(route2);
			ticketsTour.setPrice(price*5);
			ticketsTour.setQuantity(quantity*2);
			ticketsTour.setRemain(quantity*2);
			this.ticksTourDAO.addTicketsTour(ticketsTour);
			for (int i = 0; i < quantity*2; i++) {
				List<TicketsTour> ticketsTours = this.ticksTourDAO.listTicketsTours();
				TicketsTourDetail ticketsTourDetail = new TicketsTourDetail();
				ticketsTourDetail.setStatus(true);
				ticketsTourDetail.setTicketsTour(ticketsTours.get(ticketsTours.size() - 1));
				if(i < 10) {
					ticketsTourDetail.setCode(code.concat("0").concat(String.valueOf(i)));
				} else {
					ticketsTourDetail.setCode(code.concat(String.valueOf(i)));
				}
				this.ticketsTourDetailDAO.addTicketsTourDetail(ticketsTourDetail);
				
				
			}
		}
		
		
	}

	@Override
	public List<DayDTO> listDayDTOs() {
		// TODO Auto-generated method stub
		List<Day> listDays = this.dayDAO.listDays();
		List<DayDTO> listDayDTOs = new ArrayList<DayDTO>();
		for (Day day : listDays) {
			DayDTO dayDTO = new DayDTO();
			dayDTO.setDay(day.getDay());
			listDayDTOs.add(dayDTO);
		}
		return listDayDTOs;
	}

	@Override
	public DayDTO getDayDTOFirstDayActive() {
		if(listDayDTOs().size() == 0) {
			DayDTO dayDTO = new DayDTO();
			dayDTO.setDay(LocalDate.now().toString());
			return dayDTO; 
		}
		return this.listDayDTOs().get(listDayDTOs().size() - 1);
	}

	@Override
	public DayDTO getFirstDay() {
		List<Day> listDays = this.dayDAO.listDays();
		DayDTO dayDTO = new DayDTO();
		dayDTO.setId(listDays.get(0).getId());
		dayDTO.setDay(listDays.get(0).getDay());
		return dayDTO;
	}

	@Override
	public DayDTO getLastDay() {
		List<Day> listDays = this.dayDAO.listDays();
		DayDTO dayDTO = new DayDTO();
		dayDTO.setId(listDays.get(listDays.size() - 1).getId());
		dayDTO.setDay(listDays.get(listDays.size() - 1).getDay());
		return dayDTO;
	}

	@Override
	public DayDTO findDayDTOByDay(String day) {
		Day day2 = this.dayDAO.findDaybyDay(day);
		if(day2 != null) {
			DayDTO dayDTO = new DayDTO();
			dayDTO.setId(day2.getId());
			dayDTO.setDay(day2.getDay());
			return dayDTO;
		} else {
			return null;
		}
		
	}

	
	
	
}
