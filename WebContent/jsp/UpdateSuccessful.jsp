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
	Student s = (Student) request.getAttribute("updatesuccessful");
%>
<body>
<h1>Successfully updated: <%=s.getName()%> (ID: <%=s.getId() %>)</h1>
Email: <%=s.getEmail()%><br>
Contact: <%=s.getContact()%><br>
Gender: <%=s.getGender()%><br>
Address: <%=s.getAddress()%><br>
Country:  <%=s.getCountry()%><br>
</body>
</html>