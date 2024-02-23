<%--
  Created by IntelliJ IDEA.
  User: Something
  Date: 17-Oct-23
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous">
    </script>
    <title>Product</title>
</head>
<body>
<h1>Product</h1>
<table border="1" class="table table-dark table-striped">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Image</td>
        <td>Add To Cart</td>
        <td>Remove</td>
    </tr>
    <jsp:useBean id="products" scope="request" type="java.util.List"/>
    <c:forEach items='${products}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td><img src="${product.getImageUrl()}" alt="null"  width="40"
                     height="50"></td>
            <td><a href="${pageContext.request.contextPath}/shoppingCart?action=addProductToCart+id=&id">Add</a></td>
            <td><a href="${pageContext.request.contextPath}/product?action=remove&id=${product.getId()}">Remove</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
