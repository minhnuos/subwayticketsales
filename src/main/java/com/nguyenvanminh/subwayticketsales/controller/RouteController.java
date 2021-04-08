package com.nguyenvanminh.subwayticketsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenvanminh.subwayticketsales.modal.RouteDTO;
import com.nguyenvanminh.subwayticketsales.modal.StopPointDTO;
import com.nguyenvanminh.subwayticketsales.service.RouteService;
import com.nguyenvanminh.subwayticketsales.service.StopPointService;

@Controller
@RequestMapping("/route")
public class RouteController {

	
	@Autowired
	RouteService routeService;
	@Autowired
	StopPointService stopPointService;
	
	@GetMapping
	public String index(ModelMap map) {
		List<RouteDTO> routeDTOs = this.routeService.listRouteDTO();
		map.addAttribute("routeDTOs", routeDTOs);
		return "pages/route/index";
	}
	
	
	@GetMapping("/add")
	public String add(ModelMap map) {
		List<StopPointDTO> stopPointDTOs = this.stopPointService.listStopPointDTO();
		map.addAttribute("stopPointDTOs", stopPointDTOs);
		return "pages/route/add";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam int start_id, @RequestParam int end_id) {
		System.out.println("start_id" + start_id + " " + end_id);
		if(start_id > 0 &&  end_id > 0) {
			StopPointDTO stopPointDTOStart = this.stopPointService.findStopPointDTOById(start_id);
			StopPointDTO stopPointDTOEnd = this.stopPointService.findStopPointDTOById(end_id);
			RouteDTO routeDTO = new RouteDTO();
			routeDTO.setStopPointDTOStart(stopPointDTOStart);
			routeDTO.setStopPointDTOEnd(stopPointDTOEnd);
			this.routeService.addRouteDTO(routeDTO);
			return "redirect:/route";
		}
		
		return "redirect:/route";
	}
}
