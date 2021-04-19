package com.nguyenvanminh.subwayticketsales.service;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.modal.ResponseBooking;
import com.nguyenvanminh.subwayticketsales.modal.RevenueMonth;

public interface BookingService {

	public List<ResponseBooking> listResponseBookings();
	
	public void updateBooking(int id);
	
	public RevenueMonth getRevenueMonth(int month, int year);
}
