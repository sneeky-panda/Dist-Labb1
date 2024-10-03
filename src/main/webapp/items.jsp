<%@ page import="se.kth.distribuerad.labb1.BO.Item" %>
<%@ page import="java.util.Collection" %>
<%--
  Created by IntelliJ IDEA.
  User: Carlo
  Date: 2024-10-02
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
    <style>
        table{
            width:60%;
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
    <h2>Item list</h2>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <%
            Collection<Item> items = Item.searchItems("group");
            if(items != null && !items.isEmpty()){
                for(Item item: items){
            %>
                <tr>
                    <td> <%= item.getID() %></td>
                    <td> <%= item.getName()%> </td>
                    <td> <%= item.getPrice()%> </td>
                </tr>
        <%
                }
            }else{
        %>
            <tr>
                <td>No items found.</td>
            </tr>
        <%
            }
            %>
        </tbody>
    </table>


</body>
</html>
