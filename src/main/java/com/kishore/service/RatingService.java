package com.kishore.service;

import java.util.List;

import com.kishore.model.Rating;

public interface RatingService {
	
	void add(Rating rating);

	 List<Rating> listrating();
}
