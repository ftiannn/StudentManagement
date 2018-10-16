<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="NewFile.css">

</head>
<body>
  <form action="/RemoveServlet" method="GET">
  <br>
  Please provide the student's contact number you wish to remove:<br>
  <br>
  <label>Student's ID: </label><input type="text" name = "id"><br>
  <br>
    <input type="submit" value = "Remove" name = "remove" />
  </form>
  </body>
  </html>
  