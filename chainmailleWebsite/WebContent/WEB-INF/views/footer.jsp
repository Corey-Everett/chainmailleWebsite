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
 <!--  Style the Jumbotron -->
 <style>
        .jumbotron {
            padding-top: 0;
            margin-top: 0;
            margin-bottom: 0;
            padding-bottom: 0;
        }
        .h2{
        font-size: 20px;
        }
    </style>
</head>


<body>

<br>
<div class = "jumbotron">

<br>

<h2>Sign up for our mailing list to get exclusive offers and deals!</h2>


<form action="submitEmail">

<h2>Email: <input type="text" name="email" value=""> <input type="submit" value="Submit"> ${emailDeniedErrorMessage }</h2>
<br>
<br>
</form>

</div>

</body>
</html>