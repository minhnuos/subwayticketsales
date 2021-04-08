package com.nguyenvanminh.subwayticketsales.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.TripDTO;
import com.nguyenvanminh.subwayticketsales.service.DayService;
import com.nguyenvanminh.subwayticketsales.service.TripService;

@Controller
@RequestMapping("/trip")
public class TripController {

	@Autowired
	DayService dayService;
	
	@Autowired
	TripService tripService;
	
	@GetMapping
	public String index(ModelMap map) {
		DayDTO firstDayDTO = this.dayService.getFirstDay();
		DayDTO lastDayDTO = this.dayService.getLastDay();
		map.addAttribute("firstDayDTO", firstDayDTO);
		map.addAttribute("lastDayDTO", lastDayDTO);
		String dayNow = LocalDate.now().toString();
		map.addAttribute("dayNow", dayNow);
		
		DayDTO dayDTO = this.dayService.findDayDTOByDay(dayNow);
		
		List<TripDTO> listTripDTOs = this.tripService.findTripDTOByDayDTO(dayDTO);
		map.addAttribute("listTripDTOs",listTripDTOs);
		
		return "pages/trip/index";
	}
	
	@GetMapping("/{day}/{id}")
	public String tripDetail(ModelMap map,@PathVariable int id) {
		
		
		TripDTO tripDTO = this.tripService.findTripDTOById(id);
		map.addAttribute("tripDTO", tripDTO);
		
		return "pages/trip/detail";
	}
	
	@GetMapping("/day")
	public String listTripByDay(ModelMap map,@RequestParam String day) {
		DayDTO firstDayDTO = this.dayService.getFirstDay();
		DayDTO lastDayDTO = this.dayService.getLastDay();
		map.addAttribute("firstDayDTO", firstDayDTO);
		map.addAttribute("lastDayDTO", lastDayDTO);
		map.addAttribute("dayNow", day);
		
		DayDTO dayDTO = this.dayService.findDayDTOByDay(day);
		
		List<TripDTO> listTripDTOs = this.tripService.findTripDTOByDayDTO(dayDTO);
		map.addAttribute("listTripDTOs",listTripDTOs);
		
		return "pages/trip/index";
	}
}
