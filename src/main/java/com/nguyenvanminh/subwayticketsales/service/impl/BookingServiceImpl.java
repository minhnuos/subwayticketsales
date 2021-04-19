package com.nguyenvanminh.subwayticketsales.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nguyenvanminh.subwayticketsales.dao.BookingDAO;
import com.nguyenvanminh.subwayticketsales.dao.DayDAO;
import com.nguyenvanminh.subwayticketsales.entity.Booking;
import com.nguyenvanminh.subwayticketsales.entity.Day;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTour;
import com.nguyenvanminh.subwayticketsales.entity.Trip;
import com.nguyenvanminh.subwayticketsales.modal.ResponseBooking;
import com.nguyenvanminh.subwayticketsales.modal.RevenueMonth;
import com.nguyenvanminh.subwayticketsales.service.BookingService;

@Repository
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	DayDAO dayDAO;
	
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

	@Override
	public RevenueMonth getRevenueMonth(int month, int year) {
		RevenueMonth revenue = new RevenueMonth();
		List<Booking> bookings = this.bookingDAO.listBookings();
		List<Day> days = this.dayDAO.listDays();
		int total = 0;
		for (Booking booking : bookings) {
			if(Integer.parseInt(booking.getTime().substring(0, 4)) == year && 
					Integer.parseInt(booking.getTime().substring(5, 7)) == month
				
			) {
				total += booking.getTotal();
			}
		}
		
		int quantityTotal = 0;
		int quantityRemain = 0;
		
		for (Day day : days) {
			if(Integer.parseInt(day.getDay().substring(0, 4)) == year && 
					Integer.parseInt(day.getDay().substring(5, 7)) == month
				
			) {
				for (Trip trip : day.getListTrips()) {
					quantityTotal += trip.getQuantity();
					quantityRemain += trip.getRemain();
				}
				
				for (TicketsTour ticketsTour : day.getListTicketsTours()) {
					quantityTotal += ticketsTour.getQuantity();
					quantityRemain += ticketsTour.getRemain();
				}
			}
		}
		if(quantityTotal != 0) {
			double percent = (quantityTotal - quantityRemain)*100/quantityTotal;
			revenue.setQuantitySold(quantityTotal - quantityRemain);
			revenue.setPercent(percent);
		} else {
			revenue.setQuantitySold(0);
			revenue.setPercent(0);
		}
		revenue.setTotal(total);
		return revenue;
	}

	
}
