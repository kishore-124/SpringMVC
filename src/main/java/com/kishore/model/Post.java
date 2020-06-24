package com.kishore.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Post {
	
	@Id
	private int id;
	
	
	private String name;
	
	private String description;
	 
	private String filename;
	
	@OneToMany(mappedBy="post",fetch = FetchType.EAGER, cascade = {  CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Comment>  comment= new ArrayList<Comment>();
	
	@ManyToMany(mappedBy="post", cascade = {  CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Tag>  tag= new ArrayList<Tag>();
	


	public Set<Rating> getRating() {
		return rating;
	}

	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}

	@OneToMany(mappedBy="post",fetch = FetchType.EAGER,cascade = {  CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Rating>  rating= new HashSet<Rating>();
	
	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}



	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@ManyToOne
	private Topic  topic;
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public List<Tag> getTag() {
		return tag;
	}

	public void setTag(List<Tag> tag) {
		this.tag = tag;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	 

}
