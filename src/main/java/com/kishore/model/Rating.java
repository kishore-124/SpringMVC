package com.kishore.model;

import javax.persistence.*;

@Entity
public class Rating {
	
	@Id
	private int id;
	
	private int star;
	
	@ManyToOne
	private Post post;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
