package com.kishore.dao;

import com.kishore.model.User;

public interface UserDao {
	
	void add(User user);

	 User findUserByUsername(String username);

}
