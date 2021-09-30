<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corey's Chainmaille Creations</title>

</head>
<body>

<form action="userRegistration">

  User name: <input type="text" name="username" value=""> <br>
  First name: <input type="text" name="firstname" value=""> 
  Last name: <input type="text" name="lastname" value=""> <br>
  Address <br>
  Address Line 1: <input type="text" name="street" value=""> <br>
  Address Line 2:<input type="text" name="streetDetail" value=""> <br>
  City: <input type="text" name="city" value="">  State: <input type="text" name="state" value=""> ZIP:<input type="text" name="postalcode" value=""> <br>
  
  Password: <input type="password" name="password" value=""> <br>
  Email:  <input type="text" name="email" value=""> <br><br>
  
  <input type="submit" value="Register">
  <br>
  ${registrationErrorMessage }
  <br>
  <a href = "homepage">Back to Homepage</a>
</form> 
</body>
</html>