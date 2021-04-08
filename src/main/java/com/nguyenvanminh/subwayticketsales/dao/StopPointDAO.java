package com.nguyenvanminh.subwayticketsales.dao;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.entity.StopPoint;

public interface StopPointDAO {

	
	public List<StopPoint> listStopPoint();
	
	public void addStopPoint(StopPoint stopPoint);
	
	public StopPoint findStopPointById(int id);
	
	
	public void updateStopPoint(StopPoint stopPoint);
	
}
