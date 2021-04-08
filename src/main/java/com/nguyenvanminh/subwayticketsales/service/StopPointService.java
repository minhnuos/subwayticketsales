package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.StopPointDTO;

public interface StopPointService {

	public List<StopPointDTO> listStopPointDTO();
	
	public void addStopPointDTO(StopPointDTO stopPointDTO); 
	
	public StopPointDTO findStopPointDTOById(int id);
	
	public void updateStopPointDTO(StopPointDTO stopPointDTO);
}
