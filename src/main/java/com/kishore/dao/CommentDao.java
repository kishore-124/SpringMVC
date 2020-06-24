package com.kishore.dao;

import java.util.List;

import com.kishore.model.*;


public interface CommentDao {

	void add(Comment comment);
	
	 List<Comment> list(int pageno);
		
	 Comment get(int id);
	 
	 void update(int id, Comment comment);
	 
	 void delete(int id);
	 
	 
}
