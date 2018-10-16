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
	Student student = (Student) request.getAttribute("addsuccessful");
%>
<body>
<h1>
Successfully Added: <%=student.getName()%><br></h1>
Email: <%=student.getEmail()%><br>
Contact: <%=student.getContact()%><br>
Gender: <%=student.getGender()%><br>
Address: <%=student.getAddress()%><br>
Country:  <%=student.getCountry()%><br>
</body>
</html>