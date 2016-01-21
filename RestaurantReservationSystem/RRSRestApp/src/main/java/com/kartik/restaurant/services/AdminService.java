package com.kartik.restaurant.services;

import com.kartik.restaurant.model.Admin;

public interface AdminService {

	public Admin authenticateUser(Admin loginDetails);
	public Admin logout(Admin loginDetails);
}
