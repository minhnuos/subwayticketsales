package com.nguyenvanminh.subwayticketsales.dao;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.entity.Trip;

public interface TripDAO {

	public Trip getTripLatest();
	
	public void addTrip(Trip trip);
	
	public Trip findTripById(int id);
	
	public void updateTrip(Trip trip);
}
