package com.kishore.model;

import javax.persistence.*;

@Entity
public class Comment {
	
	@Id
	private int id;
	
	@ManyToOne
	private Post post;
	
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	private String cname;

}
