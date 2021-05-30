package com.nguyenvanminh.subwayticketsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanminh.subwayticketsales.modal.ResponseBooking;
import com.nguyenvanminh.subwayticketsales.modal.ResponseDetailTickets;
import com.nguyenvanminh.subwayticketsales.service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping
	public String index(ModelMap map) {
		List<ResponseBooking> listResponseBookings = this.bookingService.listResponseBookings();
		map.addAttribute("listResponseBookings", listResponseBookings);
		return "pages/booking/index";
	}
	@GetMapping("/active/{id}")
	public String activeBooking(@PathVariable int id) {
		this.bookingService.updateBooking(id);
		return "redirect:/booking";
	}
	
	@GetMapping("/unactive/{id}")
	public String unActiveBooking(@PathVariable int id) {
		this.bookingService.unActiveBooking(id);
		return "redirect:/booking";
	}
	
	@GetMapping("/detail/{id}")
	public String bookingDetail(@PathVariable int id, ModelMap map) {
		List<ResponseDetailTickets> detailTickets = this.bookingService.listDetailTickets(id);
		map.addAttribute("detailTickets", detailTickets);
		return "pages/booking/detail";
	}
}
