package com.nguyenvanminh.subwayticketsales.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenvanminh.subwayticketsales.dao.UserDAO;
import com.nguyenvanminh.subwayticketsales.entity.Users;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Users getUserByUsername(String username) {
		// TODO Auto-generated method stub
		String jql = "SELECT u FROM Users u WHERE u.username = '" + username + "'";
		Users user = this.entityManager.createQuery(jql, Users.class).getSingleResult();
		return user;
	}

}
