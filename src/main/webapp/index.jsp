<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1><%= "Mat affären!" %></h1>
<form action="${pageContext.request.contextPath}/check-items?action=login" method="POST">

</form>
<br/>

<a href="items.jsp">Show all items in database</a>
<a href="cart.jsp">Show cart</a>
</body>
</html>