package com.nguyenvanminh.subwayticketsales.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.DepartureTimeDAO;
import com.nguyenvanminh.subwayticketsales.entity.DepartureTime;

@Repository
@Transactional
public class DepartureTimeDAOImpl implements DepartureTimeDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<DepartureTime> listDepartureTimes() {
		// TODO Auto-generated method stub
		String jql = "SELECT d FROM DepartureTime d";
		List<DepartureTime> listDepartureTimes = this.entityManager.createQuery(jql, DepartureTime.class).getResultList();
		return listDepartureTimes;
	}

	@Override
	public void addDepartureTime(DepartureTime departureTime) {
		// TODO Auto-generated method stub
		this.entityManager.persist(departureTime);
	}

}
