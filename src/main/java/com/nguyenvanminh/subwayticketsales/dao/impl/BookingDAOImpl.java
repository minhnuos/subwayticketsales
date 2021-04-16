package com.nguyenvanminh.subwayticketsales.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nguyenvanminh.subwayticketsales.dao.BookingDAO;
import com.nguyenvanminh.subwayticketsales.entity.Booking;

@Repository
@Transactional
public class BookingDAOImpl implements BookingDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Booking> listBookings() {
		String jql = "SELECT b FROM Booking b ORDER BY id DESC";
		List<Booking> bookings = this.entityManager.createQuery(jql, Booking.class).getResultList();
		return bookings;
	}

	@Override
	public Booking findBookingById(int id) {
		Booking booking = this.entityManager.find(Booking.class, id);
		return booking;
	}

	@Override
	public void updateBooking(Booking booking) {
		this.entityManager.merge(booking);
		
	}

	
	
	
}
