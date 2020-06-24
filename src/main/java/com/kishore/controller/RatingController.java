package com.kishore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kishore.model.*;
import com.kishore.service.*;

@Controller
public class RatingController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private RatingService ratingService;
	
    @RequestMapping(value="/rsave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("rating") Rating rating,@RequestParam(name="post_id")int post_id){
    	
    	
    	Post post = postService.get(post_id);
    	rating.setPost(post);
    	ratingService.add(rating);  
        return "redirect:/viewpost";   
    } 

}
