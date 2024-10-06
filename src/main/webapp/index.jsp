<%@ page import="se.kth.distribuerad.labb1.UI.UserDTO" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% UserDTO loggedInUser = (UserDTO) session.getAttribute("loggedInUser"); %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>Hej <%=loggedInUser.getUsername() %>, vad vill du göra?</h1>
<form action="${pageContext.request.contextPath}/check-items?action=login" method="POST">

</form>
<br/>

<form action="<%=request.getContextPath()%>/check-items" method="post">
    <input type="hidden" name="action" value="scrollItems"/>
    <button type="submit">Bläddra bland produkter</button>
</form>
<form action="<%=request.getContextPath()%>/check-items" method="post">
    <input type="hidden" name="action" value="showCart"/>
    <button type="submit">Hantera varukorg</button>
</form>
<form action="<%=request.getContextPath()%>/check-items" method="post">
    <input type="hidden" name="action" value="logout"/>
    <button type="submit">Logga ut</button>
</form>
</body>
</html>