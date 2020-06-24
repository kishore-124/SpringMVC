package com.kishore.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	

	@Id
	 @Size(min=1,message="required") 
	private String username;
	
	  @Size(min=1,message="required") 
	private String email;
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	  @Size(min=1,message="required") 
	private String password;
	
	
}
