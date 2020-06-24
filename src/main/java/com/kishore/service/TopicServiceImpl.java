package com.kishore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dao.TopicDao;
import com.kishore.model.Topic;


@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicDao topicDao;

	@Transactional
	public void add(Topic topic) {
		topicDao.add(topic);
		
	}

	@Transactional
	public List<Topic> list(int pageno) {
	
		return topicDao.list( pageno);
	}

	@Transactional
	public Topic get(int id) {
		
		return topicDao.get(id);
	}

	@Transactional
	public void update(int id, Topic topic) {
		
		topicDao.update(id, topic);
	}

	@Transactional
	public void delete(int id) {
	
		topicDao.delete(id);
	}

}
