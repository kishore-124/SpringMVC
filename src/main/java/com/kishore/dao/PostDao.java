package com.kishore.dao;

import java.util.List;

import com.kishore.model.Post;
import com.kishore.model.Topic;



public interface PostDao {

	void add(Post post);
	
	  List<Post> listpost(int pageno);
		
		 Post get(int id);
		 
		 void update(int id, Post post);
		 
		 void delete(int id);
}
