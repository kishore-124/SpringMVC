package com.kishore.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	  @Autowired
	  private SessionFactory sessionFactory;
	
	public User findUserByUsername(String username) {
		
		 return sessionFactory.getCurrentSession().get(User.class, username);
	}

	
	public void add(User user) {
		
		sessionFactory.getCurrentSession().save(user);
	}
}
