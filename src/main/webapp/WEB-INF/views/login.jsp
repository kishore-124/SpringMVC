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

<h1>Login</h1>

${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="login" method="POST">

<table>
<tr>
<td>UserName: </td>
<td><input type="text" name="username" value="" ></td>

</tr>

<tr>
<td>Password: </td>
<td><input type="password" name="password" ></td>

</tr>

<tr>

<td><input type="submit" value="login" ></td>

</tr>




</table>

<br>

<a href="register">Register</a>

</form>
</body>
</html>