package com.kishore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.model.Topic;


@Repository
public class TopicDaoImpl implements TopicDao{
	

	 @Autowired
	   private SessionFactory sessionFactory;

	public void add(Topic topic) {
		sessionFactory.getCurrentSession().save(topic);
		
	}

	public List<Topic> list(int pageno) {
	
		   @SuppressWarnings("unchecked")
		      TypedQuery<Topic> query=sessionFactory.getCurrentSession().createQuery("from Topic");
		  
		   int page = (pageno-1)*5;
			query.setFirstResult(page);
			query.setMaxResults(5);
		return query.getResultList();
	}

	public Topic get(int id) {
		

		 return sessionFactory.getCurrentSession().get(Topic.class, id);
	}

	public void update(int id, Topic topic) {

		   Session session = sessionFactory.getCurrentSession();
		      Topic book2 = session.byId(Topic.class).load(id);
		      book2.setTitle(topic.getTitle());
		   
		      session.flush();
		
	}

	public void delete(int id) {

		 Session session = sessionFactory.getCurrentSession();
	     Topic book = session.byId(Topic.class).load(id);
	      session.delete(book);
		
	}

}
