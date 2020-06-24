package com.kishore.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.kishore.model.User;

public interface UserService extends UserDetailsService{
	

	void save(User user);
	
	public UserDetails loadUserByUsername(String username);

	public void emailsender(String username,String email);
}
