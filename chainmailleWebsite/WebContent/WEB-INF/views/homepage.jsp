<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Corey's Chainmaille Creations</title>
</head>
<body>
<jsp:include page = "header.jsp" />

<h1> Homepage</h1>
<div class = "container">
<img src= "resources/pictures/homepageBracelet.jpg" alt = "A nice bracelet not made by me" width = 100% height = 30%>
 </div>


<% if (session.getAttribute("userLogin") != null && session.getAttribute("userLogin") != "") { %>
		    	
		    <h1>Hello, ${userFirstName}!</h1>
		    	
			<% } %>


<h2>Hello, and welcome to Corey's Chainmaille Creations! This website is currently under construction.</h2>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page = "footer.jsp" />
</body>
</html>