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

</head>


<body>
<jsp:include page = "header.jsp" />

<h1>Cart Page</h1>

<br>
<%@ page import="java.util.List, entities.Item"  %>


<% List<Item> itemList = (List<Item>)session.getAttribute("cart");%>
<% double totalCost = 0;%>
<!--  This section of code compiles a table of items and their total cost from an input.  -->
<table class="table" style = "color:black">
  <thead>
    <tr>
      <th scope="col">Item</th>
      <th scope="col">Cost</th>
    </tr>
  </thead>
  <tbody>
  <% for (Item item: itemList) { %>
    <tr>
      <th scope="row"><%out.print(item.getColor() + " " + item.getWeave( )+ " " + item.getMaterial() + " " + item.getDescription()); %></th>
      <td><%out.print(item.getPrice());  %></td>
      <%totalCost += item.getPrice(); %>
    </tr>
  <% } %>
  </tbody>

</table>
<br><br>

 <h1> <% out.print("Total cost: " + totalCost); %> </h1>
 
 <br><br>
<jsp:include page = "footer.jsp" />
</body>
</html>