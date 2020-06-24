package com.kishore.service;

import java.util.List;

import com.kishore.model.Post;


public interface PostService {

	void add(Post post);
	
	 List<Post> listpost(int pageno);
	 
	 void update(int id, Post post);
		
	 Post get(int id);
	 
	 void delete(int id);
}

