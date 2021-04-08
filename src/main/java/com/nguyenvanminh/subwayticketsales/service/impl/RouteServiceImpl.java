package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.RouteDAO;
import com.nguyenvanminh.subwayticketsales.dao.StopPointDAO;
import com.nguyenvanminh.subwayticketsales.entity.Route;
import com.nguyenvanminh.subwayticketsales.entity.StopPoint;
import com.nguyenvanminh.subwayticketsales.modal.RouteDTO;
import com.nguyenvanminh.subwayticketsales.modal.StopPointDTO;
import com.nguyenvanminh.subwayticketsales.service.RouteService;

@Service
@Transactional
public class RouteServiceImpl implements RouteService{

	@Autowired
	RouteDAO routeDAO;
	@Autowired
	StopPointDAO stopPointDAO;
	
	@Override
	public List<RouteDTO> listRouteDTO() {
		List<Route> routes = this.routeDAO.listRoute();
		List<RouteDTO> routeDTOs = new ArrayList<RouteDTO>();
		for (Route route : routes) {
			RouteDTO routeDTO = new RouteDTO();
			routeDTO.setId(route.getId());
			StopPointDTO stopPointDTOStart = new StopPointDTO();
			StopPointDTO stopPointDTOEnd = new StopPointDTO();
			
			stopPointDTOStart.setId(route.getStopPointStart().getId());
			stopPointDTOStart.setName(route.getStopPointStart().getName());
			stopPointDTOStart.setAddress(route.getStopPointStart().getAddress());
			
			stopPointDTOEnd.setId(route.getStopPointEnd().getId());
			stopPointDTOEnd.setName(route.getStopPointEnd().getName());
			stopPointDTOEnd.setAddress(route.getStopPointEnd().getAddress());
			
			routeDTO.setStopPointDTOStart(stopPointDTOStart);
			routeDTO.setStopPointDTOEnd(stopPointDTOEnd);
			
			routeDTOs.add(routeDTO);
		}
		return routeDTOs;
	}

	@Override
	public void addRouteDTO(RouteDTO routeDTO) {
		// TODO Auto-generated method stub
		if(routeDTO.getStopPointDTOStart().getId() != routeDTO.getStopPointDTOEnd().getId()) {
			Route route = this.routeDAO.findRouteByStart_idAndEnd_id(routeDTO.getStopPointDTOStart().getId(), routeDTO.getStopPointDTOEnd().getId());
			if(route == null) {
				Route routeNew = new Route();
				StopPoint stopPointStart = this.stopPointDAO.findStopPointById(routeDTO.getStopPointDTOStart().getId());
				StopPoint stopPointEnd = this.stopPointDAO.findStopPointById(routeDTO.getStopPointDTOEnd().getId());
				routeNew.setStopPointStart(stopPointStart);
				routeNew.setStopPointEnd(stopPointEnd);
				this.routeDAO.addRoute(routeNew);
			}
		}
	}

}
