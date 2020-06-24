package com.kishore.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.kishore.model.*;

import com.kishore.service.*;


@Controller
public class PostController {
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;

    @RequestMapping("/pform")    
    public String showform(Model m){    
        m.addAttribute("post", new Post());  
        return "pform";   
    }
    
    
    @RequestMapping(value="/psave",method = RequestMethod.POST)    
    public String save(@RequestParam(name="topic_id") int topic_id,@RequestParam(name="tname") String tname,@ModelAttribute("post") Post post,@RequestParam CommonsMultipartFile file){ 
Tag tag= new Tag();
tag.setTname(tname);

Topic topic = topicService.get(topic_id);
	
ObjectMetadata data = new ObjectMetadata();
data.setContentType(file.getContentType());
data.setContentLength(file.getSize());
BasicAWSCredentials creds = new BasicAWSCredentials("AKIAIYVD5JCLPMAUMGTA", "+GowN0b00xHza1pcO68jUDcivjiEX82RlvfFAA4F");
AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
PutObjectResult objectResult;
try {
	objectResult = s3client.putObject("kishore130",file.getOriginalFilename(), file.getInputStream(), data);
	   System.out.println(objectResult.getContentMd5()); 
	
} catch (AmazonServiceException e) {
	
	e.printStackTrace();
} catch (SdkClientException e) {

	e.printStackTrace();
} catch (IOException e) {
	
	e.printStackTrace();
}
   post.setFilename(file.getOriginalFilename());
    post.setTopic(topic);
    postService.add(post);
    	tagService.add(tag);
    	
        return "redirect:/viewpost";   
    } 

    
    @RequestMapping("/viewpost")    
    public String viewemp(Model m,HttpSession session){
    	  session.setAttribute("pageno", 1);
        List<Post> list= postService.listpost(1); 
        for(Post post:postService.listpost(1))
        {
        Topic topic=	post.getTopic();
        m.addAttribute("topic",topic);
        }
        m.addAttribute("list",list);  
        return "viewpost";    
    } 
    
    @RequestMapping(value = "getStudentPhoto/{id}")
	public void getStudentPhoto(HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		response.setContentType("image/jpeg");

		Post ph = postService.get(id);
		System.out.println(ph);

	    BasicAWSCredentials creds = new BasicAWSCredentials("AKIAIYVD5JCLPMAUMGTA", "+GowN0b00xHza1pcO68jUDcivjiEX82RlvfFAA4F");
	    AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
	  S3Object object = s3.getObject(new GetObjectRequest("kishore130",ph.getFilename()));
	InputStream ob= object.getObjectContent();
	System.out.println(ob);
		IOUtils.copy(ob, response.getOutputStream());
		
	}
    
    @RequestMapping(value="/showpost/{id}")    
    public String show(@PathVariable int id, Model m){ 
        Post post=postService.get(id);  
        m.addAttribute("post",post);
        for(Post po:postService.listpost(1))
        {
        	Set<Rating> rating=po.getRating();
        	int sum=0;
        	int average=0;
        	for(Rating num:rating)
        	{
        		sum+=num.getStar();
        		average=sum/5;
        		   m.addAttribute("average",average); 
        	}
       
        }
       
        m.addAttribute("comment",new Comment()); 
        m.addAttribute("rating",new Rating());
        return "pshow";    
    }
    
    
    @RequestMapping(value="/editpost/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Post post=postService.get(id);  
        m.addAttribute("post",post); 
       
        return "pedit";    
    }
    
    @RequestMapping(value="/pupdate",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("post") Post post,@RequestParam(name="id") int id,@RequestParam CommonsMultipartFile file){    
    	 post.setFilename(file.getOriginalFilename());
    	
    	 ObjectMetadata data = new ObjectMetadata();
    	 data.setContentType(file.getContentType());
    	 data.setContentLength(file.getSize());
    	 BasicAWSCredentials creds = new BasicAWSCredentials("AKIAJKJOJFY7RBSIHETQ", "+GowN0b00xHza1pcO68jUDcivjiEX82RlvfFAA4F");
    	 AmazonS3 s3client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();
    	 PutObjectResult objectResult;
    	 try {
    	 	objectResult = s3client.putObject("kishore130",file.getOriginalFilename(), file.getInputStream(), data);
    	 	   System.out.println(objectResult.getContentMd5()); 
    	 	
    	 } catch (AmazonServiceException e) {
    	 	
    	 	e.printStackTrace();
    	 } catch (SdkClientException e) {

    	 	e.printStackTrace();
    	 } catch (IOException e) {
    	 	
    	 	e.printStackTrace();
    	 }
    	postService.update(id,post);    
        return "redirect:/viewpost";    
    } 
    
    @RequestMapping(value="/deletepost/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
    	postService.delete(id);    
        return "redirect:/viewpost";    
    }
    
    
    
    
    @RequestMapping("getpreviousrequestpost")    
    public String getpreviousrequest(Model m,HttpSession session){  
	  int pageno= (Integer)session.getAttribute("pageno");
	  pageno--;
	  session.setAttribute("pageno", pageno);
        List<Post> list=  postService.listpost(pageno); 
        for(Post post:postService.listpost(pageno))
        {
        Topic topic=	post.getTopic();
        m.addAttribute("topic",topic);
        }
      
        if(list.size()==0)
        {
        	 session.setAttribute("pageno", 1);
        	 list= postService.listpost(1);
        }
        m.addAttribute("list",list);  
        return "viewpost";    
    } 
  
  
  @RequestMapping("getnextrequestpost")    
    public String getnextrequest(Model m,HttpSession session){  
	  int pageno=  (Integer) session.getAttribute("pageno");
	  pageno++;
	  session.setAttribute("pageno", pageno);
        List<Post> list= postService.listpost(pageno); 
        for(Post post:postService.listpost(pageno))
        {
        Topic topic=	post.getTopic();
        m.addAttribute("topic",topic);
        }
      
        if(list.size()==0)
        {
        	 session.setAttribute("pageno", 1);
        	 list= postService.listpost(1);
        }
        m.addAttribute("list",list);  
        return "viewpost";    
    } 
  
  
}
