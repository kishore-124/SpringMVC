package com.kishore.service;

import java.util.List;

import com.kishore.model.Comment;

public interface CommentService {
	
	void add(Comment comment);

	 List<Comment> list(int pageno);
		
	 Comment get(int id);
	 
	 void delete(int id);
	 
	 void update(int id, Comment comment);
}
