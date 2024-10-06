<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="se.kth.distribuerad.labb1.BO.Product" %>
<%@ page import="se.kth.distribuerad.labb1.UI.Controller" %>
<%@ page import="se.kth.distribuerad.labb1.BO.Services.ProductService" %>
<%@ page import="se.kth.distribuerad.labb1.UI.ProductDTO" %>

<%
    session = request.getSession();
    ProductService productService = Controller.getProductService();
    HashMap<Integer, Integer> cart = (HashMap<Integer, Integer>) session.getAttribute("cart");

    double totalPrice = 0.0;
%>

<html>
<head>
    <title>Varukorg</title>
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
        .total {
            font-weight: bold;
            font-size: 20px;
        }
        button {
            padding: 5px 10px;
            background-color: #f44336;
            color: white;
            border: none;
            cursor: pointer;
        }
    </style>
</head>
<body>

<h2>Din varukorg</h2>

<%
    if (cart != null && !cart.isEmpty()) {
%>
<table>
    <thead>
    <tr>
        <th>Produkt namn</th>
        <th>Antal</th>
        <th>Pris</th>
        <th>Totalt pris för produkt</th>
        <th>Ta bort från varukorgen</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Integer productID : cart.keySet()) {
            ProductDTO product = productService.getProductDTO(productID); // Get product details
            int quantity = cart.get(productID);
            double productTotal = product.getPrice() * quantity;
            totalPrice += productTotal;
    %>
    <tr>
        <td><%= product.getProductName() %></td>
        <td><%= quantity %></td>
        <td><%= product.getPrice() %></td>
        <td><%= productTotal %></td>
        <td>
            <!-- Remove item form -->
            <form action="<%= request.getContextPath() %>/check-items" method="post">
                <input type="hidden" name="productID" value="<%= productID %>"/>
                <input type="hidden" name="action" value="cartRemove"/>
                <button type="submit">Ta bort</button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<p class="total">Totalt Pris: <%= totalPrice %></p>

<!-- Clear Cart Form -->
<form action="<%= request.getContextPath() %>/check-items" method="post">
    <input type="hidden" name="action" value="cartClear"/>
    <button type="submit">Rensa varukorg</button>
</form>
<%
} else {
%>
<p>Din varukorg är tom.</p>
<%
    }
%>

<button onclick="window.location.href='<%= request.getContextPath() %>/index.jsp'">Hem</button>


</body>
</html>