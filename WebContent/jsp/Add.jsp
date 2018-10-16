<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
<link rel="stylesheet" type="text/css" href="NewFile.css">
<body>
  <form action="/AddServlet" method="GET">
  <label>Name: </label><input type="text" name = "name"><br>
  <label>E-mail:</label><input type="email" name="email"><br>
  <label>Contact No:</label><input type="number" name="contact"><br>
  <label>Gender:</label>
  <input type="radio" name = "gender" value ="male">Male
  <input type ="radio" name="gender" value="female">Female<br>
  <label>Address:</label><textarea name = "address" rows="3" cols="30"></textarea><br>
  <label>Country:</label>
  <select name="country">
  <option value="Singapore">Singapore</option>
  <option value="America">America</option>
  <option value="China">China</option>
  <option value="Malaysia">Malaysia</option>
  <option value="Indonesia">Indonesia</option>
  <option value="India">India</option>
  </select><br>
<br>
  <br>
  
<!-- The submit and reset buttons -->
      <p>
    <input type="submit" value = "Add Student" name = "addStudent" />
    <input type ="reset"  value = "Clear" />
      </p>
      <br>
      <br>
      </form>

</body>
</html>