<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <h2>Mat affären</h2>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/check-items?action=login" method="POST">

    <label for="username">Email:     </label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>
<%
    // Visa ett felmeddelande om autentiseringen misslyckades
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<p style="color: red;"><%= errorMessage %></p>
<%
    }
%>
</body>
</html>

