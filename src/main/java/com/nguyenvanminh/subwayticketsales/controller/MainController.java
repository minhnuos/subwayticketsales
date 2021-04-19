package com.nguyenvanminh.subwayticketsales.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
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
		return "pages/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "pages/login";
	}
	
}
