package com.SEP.service;

import com.SEP.dao.UserDAO;
import com.SEP.domain.User;


public class Service {

	private UserDAO udao=new UserDAO();
	
	public User find(String username,String password){
		return udao.find(username, password);
	}
	
}
