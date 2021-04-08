package com.nguyenvanminh.subwayticketsales.dao;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.entity.DepartureTime;

public interface DepartureTimeDAO {
	
	public List<DepartureTime> listDepartureTimes();
	
	public void addDepartureTime(DepartureTime departureTime);
}
