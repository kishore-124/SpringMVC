package com.kishore.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.model.Tag;


@Repository
public class TagDaoImpl implements TagDao{
	
	 @Autowired
	   private SessionFactory sessionFactory;

	public void add(Tag tag) {
	
		sessionFactory.getCurrentSession().save(tag);
	}

}
