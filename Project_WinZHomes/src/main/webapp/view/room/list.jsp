<%@ page import="com.example.project_winzhomes.service.impl.BuildingService" %>
<%@ page import="com.example.project_winzhomes.service.impl.RoomService" %>
<%@ page import="com.example.project_winzhomes.service.impl.UserService" %><%--
  Created by IntelliJ IDEA.
  User: Something
  Date: 13-Oct-23
  Time: 2:16 PM
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
            crossorigin="anonymous"></script>
    <title>Room</title>
    <style>
        body {
            margin-top: 20px;
            background: #eee;
        }

        .card {
            box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
        }

        .avatar.sm {
            width: 2.25rem;
            height: 2.25rem;
            font-size: .818125rem;
        }

        .table-nowrap .table td, .table-nowrap .table th {
            white-space: nowrap;
        }

        .table > :not(caption) > * > * {
            padding: 0.75rem 1.25rem;
            border-bottom-width: 1px;
        }

        table th {
            font-weight: 600;
            background-color: #eeecfd !important;
        }
    </style>
</head>
<body>
<%
    UserService userService = new UserService();
    BuildingService buildingService = new BuildingService();
    RoomService roomService = new RoomService();
    request.setAttribute("users", userService.findAll());
    request.setAttribute("buildings", buildingService.findALL());
    request.setAttribute("rooms", roomService.findAll());
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page"
                       href="${pageContext.request.contextPath}/user">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://www.youtube.com/watch?v=dQw4w9WgXcQ">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user">User List</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log Out</a></li>
                    </ul>
                </li>
                <%--                <li class="nav-item">--%>
                <%--                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
                <%--                </li>--%>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<h1>Room</h1>
<table border="1" class="table table-dark table-striped">
    <tr>
        <td>ID</td>
        <td>Room Name</td>
        <td>Room Type</td>
        <td>Building</td>
        <td>Building Type</td>
        <td>Number of Resident</td>
        <td>Action</td>
    </tr>
    <c:forEach items='${rooms}' var="room">
        <tr>
            <td>${room.getId()}</td>
            <td>${room.getRoomName()}</td>

            <c:forEach var="roomType" items="${roomTypes}">
                <c:if test="${room.getRoomTypeId() == roomType.getId()}">
                    <td>${roomType.getRoomTypeName()}</td>
                </c:if>
            </c:forEach>

            <c:forEach var="building" items="${buildings}">
                <c:if test="${room.getBuildingId() == building.getId()}">
                    <td>${building.getBuildingName()}</td>
                </c:if>
            </c:forEach>

            <c:forEach var="building" items="${buildings}">
                <c:forEach var="buildingType" items="${buildingTypes}">
                    <c:if test="${(room.getBuildingId() == building.getId()) and (building.getBuildingTypeId() == buildingType.getId())}">
                        <td>${buildingType.getBuildingTypeName()}</td>
                    </c:if>
                </c:forEach>
            </c:forEach>

            <td>${room.getNumberOfResident()}</td>

            <td>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1"
                            data-bs-toggle="dropdown" aria-expanded="false">
                        Action
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/room?action=update&id=${room.getId()}">Check resident list</a></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/room?action=displayAddResidentList&id=${room.getId()}">Add new resident</a></li>
                    </ul>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
