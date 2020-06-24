package com.kishore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dao.PostDao;
import com.kishore.dao.TopicDao;
import com.kishore.model.Post;


@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostDao postDao;

	@Transactional
	public void add(Post post) {
	
		postDao.add(post);
	}

	@Transactional
	public List<Post> listpost(int pageno) {
	
		return postDao.listpost(pageno);
	}

	@Transactional
	public Post get(int id) {
		
		return postDao.get(id);
	}

	@Transactional
	public void delete(int id) {
		 postDao.delete(id);
		
	}

	@Transactional
	public void update(int id, Post post) {
	
		postDao.update(id, post);
	}

}
