package com.nguyenvanminh.subwayticketsales.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.RouteDAO;
import com.nguyenvanminh.subwayticketsales.entity.Route;

@Repository
@Transactional
public class RouteDAOImpl implements RouteDAO{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Route> listRoute() {
		String jql = "SELECT ro FROM Route ro";
		List<Route> routes = this.entityManager.createQuery(jql, Route.class).getResultList();
		return routes;
	}

	@Override
	public void addRoute(Route route) {
		// TODO Auto-generated method stub
		this.entityManager.persist(route);
	}

	@Override
	public Route findRouteByStart_idAndEnd_id(int Start_id, int End_id) {
		// TODO Auto-generated method stub
		List<Route> routes = this.listRoute();
		for (Route route : routes) {
			if(route.getStopPointStart().getId() == Start_id && route.getStopPointEnd().getId() == End_id) {
				return route;
			}
		}
		return null;
	}

}
