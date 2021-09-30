<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Corey's Chainmaille Creations</title>
</head>
<body>
<jsp:include page = "header.jsp" />
<h1>About Us Page</h1><br>

${userLogin == "ceverett" ? "Why do you need to know about us? YOU'RE us." : "Hello, this is Corey's Chainmaille Creations! We incorporated at some point in the future."}
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page = "footer.jsp" />

</body>
</html>