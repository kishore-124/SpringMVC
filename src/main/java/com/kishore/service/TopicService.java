package com.kishore.service;

import java.util.List;

import com.kishore.model.Topic;

public interface TopicService {

	void add(Topic topic);
	
	  List<Topic> list(int pageno);
		
		 Topic get(int id);
		 
		 void update(int id, Topic topic);
		 
		 void delete(int id);
}
