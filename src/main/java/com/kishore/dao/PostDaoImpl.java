package com.kishore.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.model.Post;
import com.kishore.model.Topic;



@Repository
public class PostDaoImpl implements PostDao{

	 @Autowired
	   private SessionFactory sessionFactory;
	public void add(Post post) {
	
		
		sessionFactory.getCurrentSession().save(post);
	}
	public List<Post> listpost(int pageno) {
	
		  @SuppressWarnings("unchecked")
	      TypedQuery<Post> query=sessionFactory.getCurrentSession().createQuery("from Post");
		  int page = (pageno-1)*5;
			query.setFirstResult(page);
			query.setMaxResults(5);

	return query.getResultList();
	}
	public Post get(int id) {
	
		 return sessionFactory.getCurrentSession().get(Post.class, id);
	}
	public void delete(int id) {
	
		 Session session = sessionFactory.getCurrentSession();
	     Post book = session.byId(Post.class).load(id);
	      session.delete(book);
		
		
	}
	public void update(int id, Post post) {
	
		  Session session = sessionFactory.getCurrentSession();
	      Post book2 = session.byId(Post.class).load(id);
	      book2.setName(post.getName());
	      book2.setDescription(post.getDescription());
	   
	      session.flush();
		
	}

}
