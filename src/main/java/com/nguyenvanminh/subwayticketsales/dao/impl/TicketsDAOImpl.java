package com.nguyenvanminh.subwayticketsales.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.TicketsDAO;
import com.nguyenvanminh.subwayticketsales.entity.Tickets;

@Repository 
@Transactional
public class TicketsDAOImpl implements TicketsDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void addTickets(Tickets tickets) {
		// TODO Auto-generated method stub
		this.entityManager.persist(tickets);
	}

	@Override
	public void update(Tickets tickets) {
		// TODO Auto-generated method stub
		this.entityManager.merge(tickets);
	}

	@Override
	public Tickets findTicketsById(int id) {
		
		return this.entityManager.find(Tickets.class, id);
	}
	
	
}
