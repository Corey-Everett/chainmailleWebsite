<%@ page language = "java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login</title>
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

<style>
.h1 {
color: black;

}
</style>

</head>


<body>

	<div class="container-fluid" style = "text-align:center;color:black">

		<img src="resources/pictures/websiteLogo.png"
			alt="Corey's Chainmaille Creations Logo" width=80% height= 300>

		<h1>Login Page</h1>

		<form action="userLogin">
			User name: <input type="text" name="username" value=""> <br>
			Password:	<input type="password" name="password" value=""> <br>
			<br> <input type="submit" value="Login">
		</form>
		<br> ${mavDeniedErrorMessage} <br>
		
			<a href="homepage">Back to Homepage</a>
</div>




</body>
</html>