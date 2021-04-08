package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.DepartureTimeDTO;

public interface DepartureTimeService {

	public List<DepartureTimeDTO> listDepartureTimeDTOs();
	
	public List<DepartureTimeDTO> listDepartureTimeDTONotDB();
	
	public void addDepartureTimeDTO(DepartureTimeDTO departureTimeDTO);
}
