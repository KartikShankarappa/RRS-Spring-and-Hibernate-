package com.kartik.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kartik.restaurant.dao.AdminDAO;
import com.kartik.restaurant.model.Admin;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	

	@Autowired
	private AdminDAO adminDAO;
	
	@Override
	public Admin authenticateUser(Admin loginDetails) {
		return adminDAO.authenticateUser(loginDetails);
	}

	@Override
	public Admin logout(Admin loginDetails) {
		return adminDAO.logout(loginDetails);
	}

}
