package com.nguyenvanminh.subwayticketsales.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenvanminh.subwayticketsales.dao.BookingDAO;
import com.nguyenvanminh.subwayticketsales.entity.Booking;
import com.nguyenvanminh.subwayticketsales.modal.ResponseBooking;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private BookingDAO bookingDAO;
	
	@GetMapping("/booking")
	public ResponseEntity<List<ResponseBooking>> responseBooking() {
		List<Booking> listBookings = this.bookingDAO.listBookings();
		List<ResponseBooking> responseBookings = new ArrayList<ResponseBooking>();
		for (Booking booking : listBookings) {
			if(!booking.isStatus()) {
				ResponseBooking responseBooking = new ResponseBooking(
						booking.getCustomer().getName(),
						booking.getTime());
				responseBookings.add(responseBooking);
			}
		}
		return new ResponseEntity<List<ResponseBooking>> (responseBookings, HttpStatus.OK);
	}
}
