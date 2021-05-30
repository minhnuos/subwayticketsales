package com.nguyenvanminh.subwayticketsales.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.TicketsTourDetailDAO;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTourDetail;

@Repository
@Transactional
public class TicketsTourDetailDAOImpl implements TicketsTourDetailDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addTicketsTourDetail(TicketsTourDetail ticketsTourDetail) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ticketsTourDetail);
	}

	@Override
	public void updateTicketsTourDetail(TicketsTourDetail ticketsTourDetail) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ticketsTourDetail);
	}

	@Override
	public TicketsTourDetail findTicketsTourDetailById(int id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(TicketsTourDetail.class, id);
	}
	
	
}
