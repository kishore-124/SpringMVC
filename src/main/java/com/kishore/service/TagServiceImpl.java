package com.kishore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dao.TagDao;
import com.kishore.model.Tag;


@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagDao tagDao;

	@Transactional
	public void add(Tag tag) {
		tagDao.add(tag);
		
	}

}
