<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.sms.dao.*, com.sms.pojo.*, com.sms.entity.*, java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="NewFile.css">

<body>
	<%

List<StudentEntity> sList = (List<StudentEntity>) request.getAttribute("studentlist");


out.print("<table><tr>");
out.print("<th>#</th>");	
out.println("<th>ID</th>");
out.println("<th>NAME</th>");
out.println("<th>EMAIL</th>");
out.println("<th>CONTACT</th>");
out.println("<th>GENDER</th>");
out.println("<th>ADDRESS</th>");
out.println("<th>COUNTRY</th></tr>");

for (int i = 0; i < sList.size(); i++) {
    out.println("<tr>");
    out.println("<th>" + (i+1) + "</th>");
    out.println("<td>" + sList.get(i).getId() + "</td>");
    out.println("<td>" + sList.get(i).getName() + "</td>");
    out.println("<td>" + sList.get(i).getEmail() + "</td>");
    out.println("<td>" + sList.get(i).getContact() + "</td>");
    out.println("<td>" + sList.get(i).getGender() + "</td>");
    out.println("<td>" + sList.get(i).getAddress() + "</td>");
    out.println("<td>" + sList.get(i).getCountry() + "</td>");
    out.println("</tr>");
}

out.print("</table>");

%>

</body>
</html>