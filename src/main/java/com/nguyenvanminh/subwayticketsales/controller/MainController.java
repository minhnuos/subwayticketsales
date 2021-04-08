package com.nguyenvanminh.subwayticketsales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.Slug;
import com.nguyenvanminh.subwayticketsales.modal.TripDTO;
import com.nguyenvanminh.subwayticketsales.service.DayService;
import com.nguyenvanminh.subwayticketsales.service.TripService;

@Controller
public class MainController {

	@Autowired
	DayService dayService;
	
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
		return "pages/home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "pages/login";
	}
	
}
