package com.nguyenvanminh.subwayticketsales.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.StopPointDAO;
import com.nguyenvanminh.subwayticketsales.entity.StopPoint;

@Repository
@Transactional
public class StopPointDAOImpl implements StopPointDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<StopPoint> listStopPoint() {
		String jql = "SELECT s FROM StopPoint s";
		List<StopPoint> stopPoints = this.entityManager.createQuery(jql, StopPoint.class).getResultList();
		return stopPoints;
	}

	@Override
	public void addStopPoint(StopPoint stopPoint) {
		this.entityManager.persist(stopPoint);
		
	}

	@Override
	public StopPoint findStopPointById(int id) {
		StopPoint stopPoint = entityManager.find(StopPoint.class, id);
		return stopPoint;
	}

	@Override
	public void updateStopPoint(StopPoint stopPoint) {
		// TODO Auto-generated method stub
		this.entityManager.merge(stopPoint);
	}

}
