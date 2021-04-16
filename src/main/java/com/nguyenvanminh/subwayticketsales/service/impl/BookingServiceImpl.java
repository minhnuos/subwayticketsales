package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nguyenvanminh.subwayticketsales.dao.BookingDAO;
import com.nguyenvanminh.subwayticketsales.entity.Booking;
import com.nguyenvanminh.subwayticketsales.modal.ResponseBooking;
import com.nguyenvanminh.subwayticketsales.service.BookingService;

@Repository
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDAO bookingDAO;
	
	@Override
	public List<ResponseBooking> listResponseBookings() {
		// TODO Auto-generated method stub
		List<Booking> listBookings = this.bookingDAO.listBookings();
		List<ResponseBooking> responseBookings = new ArrayList<ResponseBooking>();
		for (Booking booking : listBookings) {
			ResponseBooking responseBooking = new ResponseBooking();
			responseBooking.setId(booking.getId());
			responseBooking.setName(booking.getCustomer().getName());
			responseBooking.setPhone(booking.getCustomer().getPhone());
			responseBooking.setAddress(booking.getCustomer().getAddress());
			responseBooking.setTotal(booking.getTotal());
			responseBooking.setQuantity(booking.getBookingTickets().size() + booking.getBookingTicketsTours().size());
			responseBooking.setTime(booking.getTime());
			responseBooking.setStatus(booking.isStatus());
			if(!booking.isStatus()) {
				responseBookings.add(responseBooking);
			}
		}
		for (Booking booking : listBookings) {
			ResponseBooking responseBooking = new ResponseBooking();
			responseBooking.setId(booking.getId());
			responseBooking.setName(booking.getCustomer().getName());
			responseBooking.setPhone(booking.getCustomer().getPhone());
			responseBooking.setAddress(booking.getCustomer().getAddress());
			responseBooking.setTotal(booking.getTotal());
			responseBooking.setQuantity(booking.getBookingTickets().size() + booking.getBookingTicketsTours().size());
			responseBooking.setTime(booking.getTime());
			responseBooking.setStatus(booking.isStatus());
			if(booking.isStatus()) {
				responseBookings.add(responseBooking);
			}
		}
		return responseBookings;
	}

	@Override
	public void updateBooking(int id) {
		Booking booking = this.bookingDAO.findBookingById(id);
		if(booking != null) {
			booking.setStatus(true);
			this.bookingDAO.updateBooking(booking);
		}
		
	}

}
