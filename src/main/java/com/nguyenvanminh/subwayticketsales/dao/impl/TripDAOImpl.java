package com.nguyenvanminh.subwayticketsales.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.TripDAO;
import com.nguyenvanminh.subwayticketsales.entity.Trip;

@Repository
@Transactional
public class TripDAOImpl implements TripDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Trip getTripLatest() {
		// TODO Auto-generated method stub
		String jql = "SELECT t FROM Trip t ORDER BY id DESC";
		Trip trip = null;
		try {
			trip = this.entityManager.createQuery(jql, Trip.class).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		return trip;
	}

	@Override
	public void addTrip(Trip trip) {
		// TODO Auto-generated method stub
		this.entityManager.persist(trip);
	}

	@Override
	public Trip findTripById(int id) {
		Trip trip = this.entityManager.find(Trip.class, id);
		return trip;
	}

	@Override
	public void updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		this.entityManager.merge(trip);
	}

	
}
