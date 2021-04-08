package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.StopPointDAO;
import com.nguyenvanminh.subwayticketsales.entity.StopPoint;
import com.nguyenvanminh.subwayticketsales.modal.StopPointDTO;
import com.nguyenvanminh.subwayticketsales.service.StopPointService;

@Service
@Transactional
public class StopPointServiceImpl implements StopPointService{

	@Autowired
	StopPointDAO stopPointDAO;
	
	@Override
	public List<StopPointDTO> listStopPointDTO() {
		List<StopPoint> stopPoints = this.stopPointDAO.listStopPoint();
		List<StopPointDTO> stopPointDTOs = new ArrayList<StopPointDTO>();
		for (StopPoint stopPoint : stopPoints) {
			StopPointDTO stopPointDTO = new StopPointDTO();
			stopPointDTO.setId(stopPoint.getId());
			stopPointDTO.setAddress(stopPoint.getAddress());
			stopPointDTO.setName(stopPoint.getName());
			stopPointDTOs.add(stopPointDTO);
			
		}
		return stopPointDTOs;
	}

	@Override
	public void addStopPointDTO(StopPointDTO stopPointDTO) {
		// TODO Auto-generated method stub
		StopPoint stopPoint = new StopPoint();
		stopPoint.setName(stopPointDTO.getName());
		stopPoint.setAddress(stopPointDTO.getAddress());
		this.stopPointDAO.addStopPoint(stopPoint);
	}

	@Override
	public StopPointDTO findStopPointDTOById(int id) {
		StopPoint stopPoint = this.stopPointDAO.findStopPointById(id);
		StopPointDTO stopPointDTO = new StopPointDTO();
		stopPointDTO.setId(stopPoint.getId());
		stopPointDTO.setName(stopPoint.getName());
		stopPointDTO.setAddress(stopPoint.getAddress());
		return stopPointDTO;
	}

	@Override
	public void updateStopPointDTO(StopPointDTO stopPointDTO) {
		StopPoint stopPoint = this.stopPointDAO.findStopPointById(stopPointDTO.getId());
		if(stopPoint != null) {
			stopPoint.setName(stopPointDTO.getName());
			stopPoint.setAddress(stopPointDTO.getAddress());
		}
		
	}

}
