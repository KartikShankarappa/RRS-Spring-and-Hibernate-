package com.kartik.restaurant.dao;

import com.kartik.restaurant.model.Admin;

public interface AdminDAO {

	public Admin authenticateUser(Admin loginDetails);
	public Admin logout(Admin loginDetails);
}
