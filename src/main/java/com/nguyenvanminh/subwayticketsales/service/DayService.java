package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.DayDTO;

public interface DayService {

	
	public List<DayDTO> listDayDTOs();
	
	public void addDayDTO(DayDTO dayDTO,int quantity, int price);
	
	public DayDTO getDayDTOFirstDayActive();
	
	public DayDTO getFirstDay();
	
	public DayDTO getLastDay();
	
	public DayDTO findDayDTOByDay(String day);
}
