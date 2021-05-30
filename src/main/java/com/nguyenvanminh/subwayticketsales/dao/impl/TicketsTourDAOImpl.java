package com.nguyenvanminh.subwayticketsales.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.TicketsTourDAO;
import com.nguyenvanminh.subwayticketsales.entity.TicketsTour;

@Repository
@Transactional
public class TicketsTourDAOImpl implements TicketsTourDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addTicketsTour(TicketsTour ticketsTour) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ticketsTour);
	}

	@Override
	public List<TicketsTour> listTicketsTours() {
		String jql = "SELECT tt FROM TicketsTour tt";
		List<TicketsTour> ticketsTours = this.entityManager.createQuery(jql,TicketsTour.class).getResultList();
		return ticketsTours;
	}

	@Override
	public TicketsTour findTicketsTourById(int id) {
		TicketsTour ticketsTour = this.entityManager.find(TicketsTour.class, id);
		return ticketsTour;
	}

	@Override
	public void updateTicketsTour(TicketsTour ticketsTour) {
		// TODO Auto-generated method stub
		this.entityManager.merge(ticketsTour);
	}
	
	
}
