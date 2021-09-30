<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>
<%@ page import="java.util.List, entities.Order, entities.User"  %>


<% List<Order> orderList = (List<Order>)session.getAttribute("activeOrders");%>
<% List<User> userList = (List<User>)session.getAttribute("users");%>

Welcome to the admin dashboard, Corey! If you're not Corey, please present this screen to ceverett9287@gmail.com in exchange for a free bracelet and please don't touch anything!
<br>
<!-- Each admin control will provide a useful piece of information -->
Admin controls:
<br>

Active Orders
<table class="table" style = "color:black">
  <thead>
    <tr>
      <th scope="col">Item ID</th>
      <th scope="col">Order ID</th>
      <th scope="col">User ID</th>
      
    </tr>
  </thead>
  <tbody>
  <% for (Order order: orderList) { %>
    <tr>
      <th scope="row"><%out.print(order.getUserId());%></th>
      <td><%out.print(order.getId());  %></td>
      <td><%out.print(order.getItemId());  %></td>
     
    </tr>
  <% } %>
  </tbody>

</table>
<br>
Look at all users
<table class="table" style = "color:black">
  <thead>
    <tr>
      <th scope="col">User ID</th>
      <th scope="col">Username</th>
      <th scope="col">Admin Role</th>
      
    </tr>
  </thead>
  <tbody>
  <% for (User user: userList) { %>
    <tr>
      <th scope="row"><%out.print(user.getUserID());%></th>
      <td><%out.print(user.getUserName());  %></td>
      <td><%out.print(user.getAdminRole());  %></td>
     
    </tr>
  <% } %>
  </tbody>

</table>
<a href = "homepage">Back to Homepage</a>

</body>
</html>