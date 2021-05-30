package com.nguyenvanminh.subwayticketsales.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.nguyenvanminh.subwayticketsales.dao.RouteDAO;
import com.nguyenvanminh.subwayticketsales.entity.Route;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTour;
import com.nguyenvanminh.subwayticketsales.entity.Trip;
import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.ResponseRevenue;
import com.nguyenvanminh.subwayticketsales.modal.RevenueMonth;
import com.nguyenvanminh.subwayticketsales.modal.Slug;
import com.nguyenvanminh.subwayticketsales.modal.TripDTO;
import com.nguyenvanminh.subwayticketsales.service.BookingService;
import com.nguyenvanminh.subwayticketsales.service.DayService;
import com.nguyenvanminh.subwayticketsales.service.TripService;

@Controller
public class MainController {

	@Autowired
	DayService dayService;
	
	@Autowired 
	BookingService bookingService;
	
	@Autowired
	TripService tripService;
	
	@Autowired
	RouteDAO routeDAO;
	
	@GetMapping("/")
	public String home(ModelMap map) {
//		System.out.println(Slug.makeSlug("Cầu Giấy"));
//		System.out.println(java.time.LocalDate.now().plusDays(1));
		
		DayDTO dayDTO = this.dayService.getDayDTOFirstDayActive();
		map.addAttribute("dayDTO", dayDTO);
		TripDTO tripDTO = this.tripService.getTripDTOLatest();
		map.addAttribute("tripDTO", tripDTO);
		Month date = LocalDate.now().getMonth();
		int year = LocalDate.now().getYear();
		RevenueMonth revenueMonth = this.bookingService.getRevenueMonth(date.getValue(), year);
		map.addAttribute("revenueMonth", revenueMonth);
		
		List<Route> routes = this.routeDAO.listRoute();
		ResponseRevenue responseRevenueMax = new ResponseRevenue();
		ResponseRevenue responseRevenueMin = new ResponseRevenue();
		for (Route route : routes) {
			int revenue = 0;
			for (Trip trip : route.getTrips()) {
				if(Integer.parseInt(trip.getDay().getDay().substring(5, 7)) == date.getValue()) {
					revenue += (trip.getQuantity()-trip.getRemain())*trip.getPrice();
				}
			}
			for (TicketsTour ticketsTour : route.getTicketsTours()) {
				if(Integer.parseInt(ticketsTour.getDay().getDay().substring(5, 7)) == date.getValue()) {
					revenue += (ticketsTour.getQuantity()-ticketsTour.getRemain())*ticketsTour.getPrice();
				}
			}
			
			if(responseRevenueMax.getRevenue() < revenue) {
				responseRevenueMax.setName("Từ " + route.getStopPointStart().getName() + " đến " + route.getStopPointEnd().getName());
				responseRevenueMax.setRevenue(revenue);
			} 
			if(responseRevenueMin.getRevenue() >= revenue) {
				responseRevenueMin.setName("Từ " + route.getStopPointStart().getName() + " đến " + route.getStopPointEnd().getName());
				responseRevenueMin.setRevenue(revenue);
			} 
		}
		
		map.addAttribute("responseRevenueMax", responseRevenueMax);
		map.addAttribute("responseRevenueMin", responseRevenueMin);
		return "pages/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "pages/login";
	}
	
}
