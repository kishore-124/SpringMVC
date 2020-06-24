package com.kishore.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.model.Comment;
import com.kishore.model.Rating;


@Repository
public class RatingDaoImpl  implements RatingDao {
	
	 @Autowired
	   private SessionFactory sessionFactory;

	public void add(Rating rating) {
		
		sessionFactory.getCurrentSession().save(rating);
	}

	public List<Rating> listrating() {
		   @SuppressWarnings("unchecked")
		      TypedQuery<Rating> query=sessionFactory.getCurrentSession().createQuery("from Rating");
		  
		return query.getResultList();
	}

}
