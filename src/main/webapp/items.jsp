web<%--
  Created by IntelliJ IDEA.
  User: Carlo
  Date: 2024-10-02
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="se.kth.distribuerad.labb1.BO.Product" %>
<%@ page import="java.util.Collection" %>
<%@ page import="se.kth.distribuerad.labb1.UI.ProductDTO" %>
<%@ page import="se.kth.distribuerad.labb1.BO.Services.ProductService" %>
<%@ page import="se.kth.distribuerad.labb1.UI.Controller" %>

<%
    Collection<ProductDTO> products = Controller.getProducts();
%>
<html>
<head>
    <title>Mat produkter</title>
    <style>
        table {
            width: 60%;
            border-collapse: collapse;
            margin: 25px;
            font-size: 18px;
            text-align: left;
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h2>Mat affären</h2>

<table>
    <thead>
    <tr>
        <th>Namn</th>
        <th>Pris</th>
        <th>Lager</th>
        <th>Lägg till i varukorg</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (products != null && !products.isEmpty()) {
            for (ProductDTO productDTO : products) {
    %>
    <tr>
        <td><%= productDTO.getProductName()%>
        </td>
        <td><%= productDTO.getInStock()%>
        </td>
        <td><%= productDTO.getPrice()%>
        </td>
        <td>
            <form action="<%=request.getContextPath()%>/check-items" method="post">
                <input type="hidden" name="productID" value="<%= productDTO.getProductID()%>"/>
                <input type="hidden" name="action" value="cartAdd"/>
                <button type="submit">Lägg till</button>
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td>No items found.</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<button onclick="window.location.href='<%= request.getContextPath() %>/index.jsp'">Hem</button>
<button onclick="window.location.href='<%= request.getContextPath() %>/cart.jsp'">Visa varukorg</button>



</body>
</html>
