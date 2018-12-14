<%@ page import="java.util.List" %>
<%@ page import="com.wzn.pojo.Product" %><%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/12
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: black solid 1px;
            border-collapse: collapse;
        }
        table thead tr th,table tbody tr td{
            border: solid 1px black;
            padding: 5px 10px;
        }
        table tr:nth-child(even){
            background-color: aquamarine;
        }
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="pro">
            <tr>
                <td>${pro.productId}</td>
                <td>${pro.productName}</td>
                <td>${pro.productPrice}</td>
                <td>${pro.des}</td>
                <td><a href="delete?productId=${pro.productId}">删除&nbsp|&nbsp</a><a href="update?productId=${pro.productId}">修改</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add">添加</a>
</body>
</html>
