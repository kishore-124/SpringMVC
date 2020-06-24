package com.kishore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.kishore.model.*;
import com.kishore.service.*;


@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PostService postService;

	 @RequestMapping(value="/csave",method = RequestMethod.POST)    
	    public String save(@RequestParam(name="post_id") int post_id,@ModelAttribute("comment") Comment comment){ 

	Post post = postService.get(post_id);

	    comment.setPost(post);
	    commentService.add(comment);
	    	
	        return "redirect:/viewcomment";   
	    } 
	
	   @RequestMapping(value="/deletecomment/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
		   commentService.delete(id);    
	        return "redirect:/viewcomment";    
	    } 
	   
	   @RequestMapping(value="/editcomment/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        Comment comment=commentService.get(id);  
	        m.addAttribute("comment",comment); 
	       
	        return "cedit";    
	    }
	   @RequestMapping(value="/cupdate",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("comment") Comment comment,@RequestParam(name="id")int id){    
		   commentService.update(id, comment); 
	        return "redirect:/viewcomment";    
	    } 
	   @RequestMapping("/viewcomment")    
	    public String viewemp(Model m,HttpSession session){
		   session.setAttribute("pageno", 1);
	    	  List<Comment> list=commentService.list(1);
	    	  for(Comment comment:commentService.list(1))
		        {
		        Post post=	comment.getPost();
		        m.addAttribute("post",post);
		        }
	    	  m.addAttribute("list",list);
	        
	        return "viewcomment";    
	    }
	   
	   
	   @RequestMapping("getpreviousrequestcomment")    
	    public String getpreviousrequest(Model m,HttpSession session){  
		  int pageno= (Integer)session.getAttribute("pageno");
		  pageno--;
		  session.setAttribute("pageno", pageno);
	        List<Comment> list=  commentService.list(pageno); 
	        for(Comment comment:commentService.list(pageno))
	        {
	        Post post=	comment.getPost();
	        m.addAttribute("post",post);
	        }
	        if(list.size()==0)
	        {
	        	 session.setAttribute("pageno", 1);
	        	 list= commentService.list(1);
	        }
	        m.addAttribute("list",list);  
	        return "viewcomment";    
	    } 
	  
	  
	  @RequestMapping("getnextrequestcomment")    
	    public String getnextrequest(Model m,HttpSession session){  
		  int pageno=  (Integer) session.getAttribute("pageno");
		  pageno++;
		  session.setAttribute("pageno", pageno);
	        List<Comment> list= commentService.list(pageno); 
	        for(Comment comment:commentService.list(pageno))
	        {
	        	 Post post=	comment.getPost();
	 	        m.addAttribute("post",post);
	        }
	        if(list.size()==0)
	        {
	        	 session.setAttribute("pageno", 1);
	        	 list= commentService.list(1);
	        }
	        m.addAttribute("list",list);  
	        return "viewcomment";    
	    } 
}
