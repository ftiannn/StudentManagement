<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.sms.pojo.Student" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Student student = (Student) request.getAttribute("removesuccessful");
%>
<body>
<h1>
Successfully remove: <%=student.getId()%><br></h1>
</body>
</html>