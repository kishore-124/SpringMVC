package com.kishore.dao;

import java.util.List;
import java.util.Set;

import com.kishore.model.*;


public interface RatingDao {

	void add(Rating rating);
	
	
	 List<Rating> listrating();
}
