package com.kishore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dao.RatingDao;
import com.kishore.model.Rating;


@Service
public class RatingServiceImpl  implements RatingService{
	
	@Autowired
	private RatingDao ratingDao;

	@Transactional
	public void add(Rating rating) {
		ratingDao.add(rating);
		
	}

	@Transactional
	public List<Rating> listrating() {
	
		return ratingDao.listrating();
	}
 
	
}
