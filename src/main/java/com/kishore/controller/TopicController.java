package com.kishore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kishore.model.*;
import com.kishore.service.TopicService;
import com.kishore.service.UserService;

@Controller
public class TopicController {
	
	
	
	@Autowired
	private UserService  userService;
	
	  @RequestMapping(value="/login", method=RequestMethod.GET)    
	    public String login() {    
	            
	        return "login";    
	    } 
	  
	  @RequestMapping(value="/register", method=RequestMethod.GET)    
	    public String Registeration(Model m) {    
	        m.addAttribute("user",new User());    
	        return "register";    
	    } 
	
	  @RequestMapping(value = "/resave", method = RequestMethod.POST)
	    public String registration(  @RequestParam(name="username") String username,@RequestParam(name="password") String password,@RequestParam(name="email") String email ) {
		   if(username.equals(""))  
	        {  
			   
	            return "register";  
	        }  
User user = new User();
user.setUsername(username);
user.setEmail(email);
user.setPassword(password);

	        userService.save(user);

	        userService.emailsender(username, email);

	        return "redirect:/viewtopic";
	    }
	  
	  
	  @RequestMapping(value="/logout", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/";  
	     } 
	
	@Autowired
	private TopicService topicService;
	
    @RequestMapping("/tform")    
    public String showform(Model m){    
        m.addAttribute("topic", new Topic()); 
        return "tform";   
    }
    
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@Valid @ModelAttribute("topic") Topic topic, BindingResult br){ 
    	  if(br.hasErrors())  
          {  
              return "tform";  
          }  
    	topicService.add(topic); 
    
        return "redirect:/";   
    } 
    
    @RequestMapping("/")    
    public String viewemp(Model m,HttpSession session){  
    	  session.setAttribute("pageno", 1);
        List<Topic> list=topicService.list(1);    
        m.addAttribute("list",list);  
        return "viewtopic";    
    }
    
    @RequestMapping(value="/showtopic/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Topic topic=topicService.get(id);  
        m.addAttribute("topic",topic); 
        m.addAttribute("post",new Post());  
        return "tshow";    
    }
    
    @RequestMapping(value="/edittopic/{id}")    
    public String edittopic(@PathVariable int id, Model m){    
        Topic topic=topicService.get(id);    
        m.addAttribute("topic",topic);  
        return "tedit";    
    } 
    
    
    @RequestMapping(value="/update",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("topic") Topic topic,@RequestParam(name="id") int id){    
    	topicService.update(id,topic);    
        return "redirect:/";    
    } 
    
    @RequestMapping(value="/delettopic/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
    	topicService.delete(id);    
        return "redirect:/";    
    }
    
    
    
    @RequestMapping("getpreviousrequest")    
    public String getpreviousrequest(Model m,HttpSession session){  
	  int pageno= (Integer)session.getAttribute("pageno");
	  pageno--;
	  session.setAttribute("pageno", pageno);
        List<Topic> list= topicService.list(pageno);    
        if(list.size()==0)
        {
        	 session.setAttribute("pageno", 1);
        	 list= topicService.list(1);
        }
        m.addAttribute("list",list);  
        return "viewtopic";    
    } 
  
  
  @RequestMapping("getnextrequest")    
    public String getnextrequest(Model m,HttpSession session){  
	  int pageno=  (Integer) session.getAttribute("pageno");
	  pageno++;
	  session.setAttribute("pageno", pageno);
        List<Topic> list= topicService.list(pageno);    
        if(list.size()==0)
        {
        	 session.setAttribute("pageno", 1);
        	 list= topicService.list(1);
        }
        m.addAttribute("list",list);  
        return "viewtopic";    
    } 

}
