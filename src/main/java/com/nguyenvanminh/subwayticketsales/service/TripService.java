package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.DayDTO;
import com.nguyenvanminh.subwayticketsales.modal.TripDTO;

public interface TripService {

	public TripDTO getTripDTOLatest();
	
	public List<TripDTO> findTripDTOByDayDTO(DayDTO dayDTO);
	
	public TripDTO findTripDTOById(int id);
}
