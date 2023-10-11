<%--
  Created by IntelliJ IDEA.
  User: Something
  Date: 05-Oct-23
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>User</title>
</head>
<body>
    <h1>User</h1>
    <p>
        <a href="/user?action=create">Create new user</a>
    </p>
    <table border="1" class="table table-dark table-striped">
        <tr>
            <td>ID</td>
            <td>Username</td>
            <td>Full Name</td>
            <td>Date Of Birth</td>
            <td>National ID</td>
            <td>Gender</td>
            <td>Address</td>
            <td>Phone Number</td>
            <td>Email</td>
            <td>Edit</td>
            <td>Delete</td>

        </tr>
        <c:forEach items='${requestScope["user"]}' var="user">
            <tr>
                <td>${user.getId()}</td>
                <td><a href="/user?action=view&id=${user.getId()}">${user.getUsername()}</a></td>
                <td>${user.getFullName()}</td>
                <td>${user.getDateOfBirth()}</td>
                <td>${user.getNationalId()}</td>
                <td>${user.isGender()}</td>
                <td>${user.getAddress()}</td>
                <td>${user.getPhoneNumber()}</td>
                <td>${user.getEmail()}</td>


                <td><a href="/user?action=edit&id=${user.getId()}">edit</a></td>

                <td><a href="/user?action=remove&id=${user.getId()}">remove</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
