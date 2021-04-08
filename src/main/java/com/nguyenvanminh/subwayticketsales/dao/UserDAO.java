package com.nguyenvanminh.subwayticketsales.dao;

import com.nguyenvanminh.subwayticketsales.entity.Users;

public interface UserDAO {

	public Users getUserByUsername(String username);
}
