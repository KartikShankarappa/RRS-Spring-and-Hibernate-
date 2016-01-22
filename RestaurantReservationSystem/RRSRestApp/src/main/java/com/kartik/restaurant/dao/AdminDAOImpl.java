package com.kartik.restaurant.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kartik.restaurant.model.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	public static Map<String, String> sessionData = new HashMap<String, String>();
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Admin authenticateUser(Admin loginDetails) {
		
		Session session = sessionFactory.getCurrentSession();
		String token = null;
		
		Query query = session.createQuery("from Admin where emailId = :param1 and password = :param2");
		query.setString("param1", loginDetails.getEmailId());
		query.setString("param2", loginDetails.getPassword());
		
		List<Admin> admins = (List<Admin>) query.list();
		
		if(admins.size() != 0) {
			token = UUID.randomUUID().toString();
			loginDetails.setPassword(null);
			loginDetails.setToken(token);
			sessionData.put(loginDetails.getEmailId(), loginDetails.getToken());
		} else {
			loginDetails.setToken(null);
		}
		
		System.out.println("The session data is: \n" + sessionData);
		
		return loginDetails;
	}

	@Override
	public Admin logout(Admin loginDetails) {
		// TODO Auto-generated method stub
		sessionData.remove(loginDetails.getEmailId());
		loginDetails.setEmailId(null);
		loginDetails.setToken(null);
		System.out.println("The session data now is:\n" + sessionData);
		return loginDetails;
	}
	
	
	public static boolean isSessionValid(String emailId, String token) {
		
		String tempToken = AdminDAOImpl.sessionData.get(emailId);
		
		if(!tempToken.equals(null) && tempToken.equals(token)) {
			return true;
		} else {
			return false;
		}
	}

	
}
