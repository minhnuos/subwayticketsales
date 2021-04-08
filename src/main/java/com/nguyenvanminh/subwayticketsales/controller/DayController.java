package com.nguyenvanminh.subwayticketsales.controller;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.service.DayService;



@Controller
@RequestMapping("/day")
public class DayController {

	@Autowired
	DayService dayService;
	
	@PostMapping("/active")
	public String activeDay(@RequestParam String quantity, @RequestParam String day, @RequestParam String price) throws ParseException {
		DayDTO dayDTO = new DayDTO();
		dayDTO.setDay(day);
		this.dayService.addDayDTO(dayDTO,Integer.parseInt(quantity),Integer.parseInt(price));
		return "redirect:/";
	}
}
