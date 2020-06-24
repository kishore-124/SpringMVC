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
  
        <h1> Edit Comment</h1>  
       <form:form method="post" action="/SpringMVC/cupdate"  modelAttribute="comment"> 
       <input type="hidden"  name="id" value="${comment.id}" >    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="cname"  /></td>  
         </tr>    
  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="update" /></td>    
         </tr>    
        </table>    
       </form:form>  
</body>
</body>
</html>