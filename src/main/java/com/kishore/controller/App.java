package com.kishore.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kishore.config.AppConfig;
import com.kishore.model.*;

import com.kishore.service.*;

public class App {

	public static void main(String[] args) {
	
		 AnnotationConfigApplicationContext context = 
		            new AnnotationConfigApplicationContext(AppConfig.class);
		 
		PostService postService = context.getBean(PostService.class);
		TagService tagService = context.getBean(TagService.class);
		 TopicService topicService = context.getBean(TopicService.class);
		 
		 CommentService commentService = context.getBean(CommentService.class);
		 
	
		
		 
		 
		 

	}

}
