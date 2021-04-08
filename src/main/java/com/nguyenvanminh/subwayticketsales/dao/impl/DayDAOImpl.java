package com.nguyenvanminh.subwayticketsales.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.DayDAO;
import com.nguyenvanminh.subwayticketsales.entity.Day;

@Repository
@Transactional
public class DayDAOImpl implements DayDAO{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addDay(Day day) {
		// TODO Auto-generated method stub
		this.entityManager.persist(day);
	}

	@Override
	public List<Day> listDays() {
		// TODO Auto-generated method stub
		String jql = "SELECT d FROM Day d";
		List<Day> listDays = this.entityManager.createQuery(jql, Day.class).getResultList();
		return listDays;
	}

	@Override
	public Day findDaybyDay(String day) {
		String jql = "SELECT d FROM Day d WHERE d.day='" + day + "'";
		Day day2 = null;
		try {
			day2 =  this.entityManager.createQuery(jql, Day.class).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return day2;
	}

	
	
	
}
