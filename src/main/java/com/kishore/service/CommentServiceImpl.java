package com.kishore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dao.CommentDao;
import com.kishore.model.Comment;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;

	@Transactional
	public void add(Comment comment) {
		
		 commentDao.add(comment);
	}

	@Transactional
	public List<Comment> list(int pageno) {
		
		return  commentDao.list(pageno);
	}

	@Transactional
	public Comment get(int id) {
		
		return  commentDao.get(id);
	}

	@Transactional
	public void delete(int id) {
		
		commentDao.delete(id);
	}

	@Transactional
	public void update(int id, Comment comment) {
	
		commentDao.update(id, comment);
	}

}
