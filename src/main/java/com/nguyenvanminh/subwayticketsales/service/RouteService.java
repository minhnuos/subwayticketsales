package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.RouteDTO;

public interface RouteService {

	public List<RouteDTO> listRouteDTO();
	
	public void addRouteDTO(RouteDTO routeDTO);
}
