package com.nguyenvanminh.subwayticketsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanminh.subwayticketsales.modal.DepartureTimeDTO;
import com.nguyenvanminh.subwayticketsales.service.DepartureTimeService;

@Controller
@RequestMapping("/departuretime")
public class DepartureTimeController {

	@Autowired
	DepartureTimeService departureTimeService;
	
	@GetMapping
	public String index(ModelMap map) {
		List<DepartureTimeDTO> listDepartureTimeDTOs = this.departureTimeService.listDepartureTimeDTOs();
		List<DepartureTimeDTO> listDepartureTimeDTONotDBs = this.departureTimeService.listDepartureTimeDTONotDB();
		map.addAttribute("listDepartureTimeDTOs", listDepartureTimeDTOs);
		map.addAttribute("listDepartureTimeDTONotDBs", listDepartureTimeDTONotDBs);
		return "pages/departuretime/index";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute DepartureTimeDTO departureTimeDTO) {
		this.departureTimeService.addDepartureTimeDTO(departureTimeDTO);
		return "redirect:/departuretime";
	}
	
}
