<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String username = (String)session.getAttribute("username");
String password = (String)session.getAttribute("password");
if (username == null) {
%>
<h1>Session expired, Please login again!</h1>
<%
} 
else {
	out.print("<h2>Username : " + username + "</h2>");
	out.print("<br/>");
	out.print("<h2>Password : " + password + "</h2>");
}
%>

<br/>
<br/>
Menu
<br/>
<a href="register.html">Register a new user</a>
<br/>
<a href="login.html">Login</a>
<br/>
<a href="index.html">Go home</a>
<br/>
<a href="LogoutServlet">Logout and Go home</a>
</body>
</html>