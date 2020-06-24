<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringMVC</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">SpringMVC</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/SpringMVC/">Home <span class="sr-only">(current)</span></a>
      </li>
   
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown link
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="/SpringMVC/viewpost">View Post</a>
          <a class="dropdown-item" href="/SpringMVC/viewcomment">View Comment</a>
        </div>
      </li>
    </ul>
   <a href="logout">logout</a> 
  </div>
</nav>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<h1>Post Show</h1>
Name: ${post.name}<br>
Description: ${post.description}<br>
Image: <img width="100" height="100" src="/SpringMVC/getStudentPhoto/${post.id }"><br><br>

  <h1>Average Rating</h1> 
 ${average}

    <h1>Add Rating</h1>  
       <form:form method="post" action="/SpringMVC/rsave"  modelAttribute="rating"> 
       <input type="hidden" name="post_id" value="${post.id}"/>    
        <table >    
         <tr>    
          1 star: <form:radiobutton path="star" value="1"/>  </tr>
      <tr>  2 star: <form:radiobutton path="star" value="2"/>  </tr>
      <tr>     3 star: <form:radiobutton path="star" value="3"/>  </tr>
    <tr>    4 star: <form:radiobutton path="star" value="4"/> </tr>
      <tr>     5 star: <form:radiobutton path="star" value="5"/>  </tr>
      
           
  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Add" /></td>    
         </tr>    
        </table>    
       </form:form>  
      
  
  
  
        <h1>New Comment</h1>  
       <form:form method="post" action="/SpringMVC/csave"  modelAttribute="comment"> 
       <input type="hidden" name="post_id" value="${post.id}"/>    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="cname"  /></td>  
         </tr>    
  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
      <a  href="/SpringMVC/viewpost"   class="btn btn-primary">Back</a>
      
  
</body>
</html>