<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="NewFile.css">
<body>
<div id="wrapper">
	<%= "<s1>Welcome, " + session.getAttribute("user") + "</s1>" %>
	<br>
	<header>Student Management<br>
	
	</header>
  
  	<div id="leftcolumn"><nav>
  	<iframe src = "link.html" name="link" style="border:none; height:100%; width:100%;"></iframe>
  	</nav></div>
  	
  	<div id="rightcolumn">
  	<iframe src="" name="rightcol" style="border:none; height:100%; width: 100%;">
  	</iframe>

	</div>
    </div>

</body>
</html>