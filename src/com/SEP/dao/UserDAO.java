package com.SEP.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.SEP.domain.User;
import com.SEP.utils.JdbcUtils;

public class UserDAO {

	public User find(String username,String password){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getUserDataSource());
			String sql = "select * from user where username=? and password=?";
			Object[] params={username,password};
			
			return (User)runner.query(sql, new BeanHandler(User.class), params);
			

		}catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
}
