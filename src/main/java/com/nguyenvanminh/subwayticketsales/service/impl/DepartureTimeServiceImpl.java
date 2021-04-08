package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.DepartureTimeDAO;
import com.nguyenvanminh.subwayticketsales.entity.DepartureTime;
import com.nguyenvanminh.subwayticketsales.modal.DepartureTimeDTO;
import com.nguyenvanminh.subwayticketsales.service.DepartureTimeService;

@Service
@Transactional
public class DepartureTimeServiceImpl implements DepartureTimeService{

	
	@Autowired
	DepartureTimeDAO departureTimeDAO;
	@Override
	public List<DepartureTimeDTO> listDepartureTimeDTOs() {
		// TODO Auto-generated method stub
		List<DepartureTime> listDepartureTimes = this.departureTimeDAO.listDepartureTimes();
		List<DepartureTimeDTO> listDepartureTimeDTOs = new ArrayList<DepartureTimeDTO>();
		for (DepartureTime departureTime : listDepartureTimes) {
			DepartureTimeDTO departureTimeDTO = new DepartureTimeDTO();
			departureTimeDTO.setId(departureTime.getId());
			departureTimeDTO.setTime(departureTime.getTime());
			listDepartureTimeDTOs.add(departureTimeDTO);
		}
		return listDepartureTimeDTOs;
	}
	@Override
	public List<DepartureTimeDTO> listDepartureTimeDTONotDB() {
		List<DepartureTime> listDepartureTimes = this.departureTimeDAO.listDepartureTimes();
		List<DepartureTimeDTO> listDepartureTimeDTOs = new ArrayList<DepartureTimeDTO>();
		for (int i = 1; i <= 24; i++) {
			boolean status = false;
			for (DepartureTime departureTime : listDepartureTimes) {
				if(i == departureTime.getTime()) {
					status = true;
					break;
				}
 			}
			
			if(!status) {
				DepartureTimeDTO departureTimeDTO = new DepartureTimeDTO();
				departureTimeDTO.setTime(i);
				listDepartureTimeDTOs.add(departureTimeDTO);
			}
		}
		return listDepartureTimeDTOs;
	}
	@Override
	public void addDepartureTimeDTO(DepartureTimeDTO departureTimeDTO) {
		// TODO Auto-generated method stub
	
		DepartureTime departureTime = new DepartureTime();
		departureTime.setTime(departureTimeDTO.getTime());
		this.departureTimeDAO.addDepartureTime(departureTime);
	}
	
	

}
