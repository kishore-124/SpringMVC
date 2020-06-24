package com.kishore.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Topic {
	
	@Id
	private int id;
	

	@OneToMany(mappedBy="topic",fetch = FetchType.EAGER, cascade = {  CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Post>  post= new ArrayList<Post>();
	
	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Size(min=1,message="required")  
	private String title;

}
