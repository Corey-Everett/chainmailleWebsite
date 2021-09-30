<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Corey's Chainmaille Creations</title>
<!-- Latest compiled and minified CSS  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript  -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous">
	</script>
	
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet”
	type=”text/css” />
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>

<link rel="stylesheet" type="text/css" href="resources/stylesheet.css">

	<!--  Styling the header -->
    <style>
        .jumbotron {
            padding-top: 0;
            margin-top: 0;
            margin-bottom: 0;
            padding-bottom: 0;
        }
    </style>
    
</head>

<body>
	<!-- Display the options based on whether the user is logged in and whether they're logged in as the admin -->
	<div class="jumbotron">
		<img src= "resources/pictures/websiteLogo.png" alt = "Corey's Chainmaille Creations Logo" width = 30% height = 40%>
		
		
			<a href="homepage"> Homepage</a> |
		    <a href="aboutus">About </a> |
		 
		 
		    <% if (session.getAttribute("userLogin") != null && session.getAttribute("userLogin") != "") { %>
		    	
		    
		    
		    <a href="userLogout"> Logout </a> |
		    <a href = "cart"> Cart</a>	
		    	
			<% } else { %>
		    	
			<a href="login"> Login</a> |
			
			(<a href="registration">Register</a>)

				 <%      } %>
	 
		    <% if (session.getAttribute("userLogin") != null && session.getAttribute("userLogin").equals("ceverett")) { %>
		    	
		    <a href="admindashboard">                      Admin Dashboard </a>
		    
		    <% }  %>	
			
			
	
	</div>
	<!-- Display the sale tabs --> 
	<nav class="navbar navbar-light bg-light" role = "navigation" style = "background-color:grey;text-align:center">
	  <a class="navbar-brand"></a>
    <a class="navbar-brand"  ></a>
      <a class="navbar-brand"></a>
      	  <a class="navbar-brand"></a>
    <a class="navbar-brand"  ></a>
      <a class="navbar-brand"></a>
      	  <a class="navbar-brand"></a>
    <a class="navbar-brand"  ></a>
      <a class="navbar-brand"></a>
      	  <a class="navbar-brand"></a>
    <a class="navbar-brand"  ></a>
      <a class="navbar-brand"></a>
      	  <a class="navbar-brand"></a>
    <a class="navbar-brand"  ></a>
      <a class="navbar-brand"></a>
      	  <a class="navbar-brand"></a>
    <a class="navbar-brand"  ></a>
      <a class="navbar-brand"></a>
            	  <a class="navbar-brand"></a>
    <a class="navbar-brand"  ></a>

  <a class="navbar-brand" href="bracelets">Bracelets</a>
    <a class="navbar-brand" href="necklaces" >Necklaces</a>
      <a class="navbar-brand" href="special">Special</a>

</nav>
	

	${userLogin != "ceverett" ? "" : "Admin Logged in!"} <br>
</body>
</html>