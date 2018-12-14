<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wzn
  Date: 2018/12/13
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="doUpdate">
    <input type="text" hidden="hidden" name="id" value="${p.productId}">
    商品名称:<input type="text" name="name" value="${p.productName}"><br>
    商品价格:<input type="text" name="price" value="${p.productPrice}"><br>
    商品描述:<input type="text" name="des" value="${p.des}"><br>
    <input type="submit" value="修改"><br>
</form>
</body>
</html>
