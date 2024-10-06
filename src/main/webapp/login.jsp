<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Logga in</title>
</head>
<body>
<h2>Logga in</h2>
<h1><%= "Electro Will!" %>
</h1>
<form action="${pageContext.request.contextPath}/check-items?action=login" method="POST">

    <label for="username">Email: </label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Lösenord:</label>
    <input type="password" id="password" name="password" required><br><br>

    <input type="submit" value="Logga in">
</form>
<br/>
<%
    // Visa ett felmeddelande om autentiseringen misslyckades
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<p style="color: red;"><%= errorMessage %>
</p>
<%
    }
%>

</body>
</html>
