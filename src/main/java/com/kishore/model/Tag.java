package com.kishore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Tag {
	
	@Id
	private int id;
	
	public int getId() {
		return id;
	}
	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	@ManyToMany(fetch = FetchType.EAGER, cascade = {   CascadeType.REMOVE })
	private List<Post>  post= new ArrayList<Post>();
	public void setId(int id) {
		this.id = id;
	}


	private String tname;

	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}

}
