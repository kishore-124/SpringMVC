package com.kishore.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kishore.dao.UserDao;
import com.kishore.model.User;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class UserServiceImpl  implements UserService {
	
	

	   @Autowired
	    private UserDao userRepository;
	
	   @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	   
	   @Transactional
	   public void save(User user)
	   {
		   user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		   userRepository.add(user);
		   
	   }
	   
	   @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		   User user = userRepository.findUserByUsername(username);

	        Set < GrantedAuthority > grantedAuthorities = new HashSet <GrantedAuthority > ();
	        grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
	        grantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));

	        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
	            grantedAuthorities);
	}

	   @Transactional
	public void emailsender(String username, String email) {
	
		   Email from = new Email("16m124@kce.ac.in");
		      String subject = "Sending with SendGrid is Fun";
		      Email to = new Email(email);
		      Content content = new Content("text/plain", "welcome  "+username+"This Brand new SpringMVC App");
		      Mail mail = new Mail(from, subject, to, content);

		      SendGrid sg = new SendGrid("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");
		      Request request = new Request();
		      
		      try {
		          request.setMethod(Method.POST);
		          request.setEndpoint("mail/send");
		          request.setBody(mail.build());
		          Response response = sg.api(request);
		          System.out.println(response.getStatusCode());
		          System.out.println(response.getBody());
		          System.out.println(response.getHeaders());
		        } catch (IOException ex) {
		         System.out.println(ex);
		        }
		
	}


}
