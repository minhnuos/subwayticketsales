package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.ResponseBooking;

public interface BookingService {

	public List<ResponseBooking> listResponseBookings();
	
	public void updateBooking(int id);
}
