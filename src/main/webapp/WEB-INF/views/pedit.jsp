<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpringMVC</title>
</head>
<body>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <h1> Edit Post</h1>  
       <form:form method="post" action="/SpringMVC/pupdate" modelAttribute="post"  enctype="multipart/form-data"> 
       <input type="hidden"  name="id" value="${post.id}" >  
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Description :</td>    
          <td><form:input path="description" /></td>  
         </tr>   
         <tr>    
          <td>Image :</td>    
          <td><input name="file" id="fileToUpload" type="file" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="update" /></td>    
         </tr>    
        </table>    
       </form:form>  
</body>
</html>