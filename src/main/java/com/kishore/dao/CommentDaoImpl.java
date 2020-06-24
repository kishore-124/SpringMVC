package com.kishore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.model.*;


@Repository
public class CommentDaoImpl implements CommentDao{
	
	 @Autowired
	   private SessionFactory sessionFactory;

	public void add(Comment comment) {
		sessionFactory.getCurrentSession().save(comment);
		
	}

	public List<Comment> list(int pageno) {
		

		   @SuppressWarnings("unchecked")
		      TypedQuery<Comment> query=sessionFactory.getCurrentSession().createQuery("from Comment");
		  
		   int page = (pageno-1)*5;
			query.setFirstResult(page);
			query.setMaxResults(5);
		return query.getResultList();
	}

	public Comment get(int id) {
	
		return sessionFactory.getCurrentSession().get(Comment.class, id);
	}

	public void delete(int id) {
		 Session session = sessionFactory.getCurrentSession();
	     Comment book = session.byId(Comment.class).load(id);
	      session.delete(book);
		
	}

	public void update(int id, Comment comment) {
		  Session session = sessionFactory.getCurrentSession();
	      Comment book2 = session.byId(Comment.class).load(id);
	      book2.setCname(comment.getCname());
	   
	      session.flush();
		
	}

}
