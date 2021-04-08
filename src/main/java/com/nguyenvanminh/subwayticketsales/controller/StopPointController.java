package com.nguyenvanminh.subwayticketsales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyenvanminh.subwayticketsales.modal.StopPointDTO;
import com.nguyenvanminh.subwayticketsales.service.StopPointService;

@Controller
@RequestMapping("/stoppoint")
public class StopPointController {

	@Autowired
	StopPointService stopPointService;
	
	@GetMapping
	public String index(ModelMap map) {
		List<StopPointDTO> stopPointDTOs = stopPointService.listStopPointDTO();
		map.addAttribute("stopPointDTOs", stopPointDTOs);
		return "pages/stoppoint/index";
	}
	
	@GetMapping("/add")
	public String add() {
		
		return "pages/stoppoint/add";
	}
	
	
	@PostMapping("/add")
	public String add(@ModelAttribute StopPointDTO stopPointDTO) {
		this.stopPointService.addStopPointDTO(stopPointDTO);
		return "redirect:/stoppoint";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,ModelMap map) {
		StopPointDTO stopPointDTO = this.stopPointService.findStopPointDTOById(id);
		map.addAttribute("stopPointDTO", stopPointDTO);
		return "pages/stoppoint/edit";
	}
	
	@PostMapping("/update/{id}")
	public String update(@ModelAttribute StopPointDTO stopPointDTO,@PathVariable int id) {
		stopPointDTO.setId(id);
		this.stopPointService.updateStopPointDTO(stopPointDTO);
		return "redirect:/stoppoint";
	}
	
}
