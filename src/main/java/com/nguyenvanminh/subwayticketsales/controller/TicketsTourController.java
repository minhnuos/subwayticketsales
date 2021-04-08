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
import com.nguyenvanminh.subwayticketsales.modal.TicketsTourDTO;
import com.nguyenvanminh.subwayticketsales.modal.TripDTO;
import com.nguyenvanminh.subwayticketsales.service.DayService;
import com.nguyenvanminh.subwayticketsales.service.TicketsTourService;

@Controller
@RequestMapping("/ticketstour")
public class TicketsTourController {

	@Autowired
	TicketsTourService ticketsTourService;
	
	@Autowired
	DayService dayService;
	
	@GetMapping
	public String index(ModelMap map) {
		
		DayDTO firstDayDTO = this.dayService.getFirstDay();
		DayDTO lastDayDTO = this.dayService.getLastDay();
		map.addAttribute("firstDayDTO", firstDayDTO);
		map.addAttribute("lastDayDTO", lastDayDTO);
		String dayNow = LocalDate.now().toString();
		map.addAttribute("dayNow", dayNow);
		
		List<TicketsTourDTO> listTicketsTourDTOs = this.ticketsTourService.findListTicketsTourDTOsByDay(dayNow);
		map.addAttribute("listTicketsTourDTOs",listTicketsTourDTOs);
		return "pages/ticketstour/index";
	}
	
	@GetMapping("day")
	public String listTicketsTourByDay(ModelMap map, @RequestParam String day) {
		
		DayDTO firstDayDTO = this.dayService.getFirstDay();
		DayDTO lastDayDTO = this.dayService.getLastDay();
		map.addAttribute("firstDayDTO", firstDayDTO);
		map.addAttribute("lastDayDTO", lastDayDTO);
		String dayNow = LocalDate.now().toString();
		map.addAttribute("dayNow", day);
		
		List<TicketsTourDTO> listTicketsTourDTOs = this.ticketsTourService.findListTicketsTourDTOsByDay(day);
		map.addAttribute("listTicketsTourDTOs",listTicketsTourDTOs);
		return "pages/ticketstour/index";
	}
	
	@GetMapping("/{day}/{id}")
	public String tripDetail(ModelMap map,@PathVariable int id) {
		
		
		TicketsTourDTO ticketsTourDTO = this.ticketsTourService.findTicketsTourDTOById(id);
		map.addAttribute("ticketsTourDTO", ticketsTourDTO);
		
		return "pages/ticketstour/detail";
	}
}
