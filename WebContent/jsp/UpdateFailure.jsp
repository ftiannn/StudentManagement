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
	String msg = (String) request.getAttribute("error");
	Student student = (Student) request.getAttribute("updatefail");
%>
<body>

<h1>
Failed updating student:  <%=student.getName()%> ( <%=student.getId()%> )<br></h1>
reason: <%=msg%><br>
Please try again! 
<%-- Email: <%=student.getEmail()%><br>
Contact: <%=student.getContact()%><br>
Gender: <%=student.getGender()%><br>
Address: <%=student.getAddress()%><br>
Country:  <%=student.getCountry()%><br> --%>
</body>
</html>