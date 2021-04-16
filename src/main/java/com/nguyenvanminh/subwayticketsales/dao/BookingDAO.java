package com.nguyenvanminh.subwayticketsales.dao;

import java.util.List;

import com.nguyenvanminh.subwayticketsales.entity.Booking;

public interface BookingDAO {

	public List<Booking> listBookings();
	
	public Booking findBookingById(int id);
	
	public void updateBooking(Booking booking);
}
