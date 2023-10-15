<%@ page import="com.example.project_winzhomes.service.impl.UserService" %>
<%@ page import="com.example.project_winzhomes.service.impl.BuildingService" %>
<%@ page import="com.example.project_winzhomes.service.impl.RoomService" %><%--
  Created by IntelliJ IDEA.
  User: Something
  Date: 15-Oct-23
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <title>Resident</title>
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
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/room">Room List</a></li>
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

<table border="1" class="table mb-0 table-dark table-striped table-responsive">
    <thead class="small text-uppercase text-muted">
    <tr>
        <td>ID</td>
        <td>Avatar</td>
        <td>Username</td>
        <td>Full Name</td>
        <td>Date Of Birth</td>
        <td>National ID</td>
        <td>Gender</td>
        <td>Address</td>
        <td>Phone Number</td>
        <td>Email</td>
        <td>Role</td>
        <td>Room</td>
        <td>Room Type</td>
        <td>Building</td>
        <td>Building Type</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${requestScope["users"]}' var="user">
        <c:if test="${user.getRoomId() != room.getId()}">
            <tr class="align-middle">
                <td id="user_id">${user.getId()}</td>

                <td>
                    <div class="d-flex align-items-center">
                        <img src="https://bootdey.com/img/Content/avatar/avatar2.png"
                             class="avatar sm rounded-pill me-3 flex-shrink-0" alt="User">
                    </div>
                </td>

                <td>${user.getUsername()}</td>

                <td><span class="d-inline-block align-middle">${user.getFullName()}</span></td>

                <td>${user.getDateOfBirth()}</td>
                <td>${user.getNationalId()}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.isGender() == true}">Male</c:when>
                        <c:when test="${user.isGender() == false}">Female</c:when>
                    </c:choose>
                </td>
                <td>${user.getAddress()}</td>
                <td>${user.getPhoneNumber()}</td>
                <td>${user.getEmail()}</td>

                <c:forEach var="role" items="${roles}">
                    <c:if test="${role.getId() == user.getRoleId()}">
                        <td>${role.getRoleName()}</td>
                    </c:if>
                </c:forEach>

                <c:forEach var="room" items="${rooms}">
                    <c:if test="${room.getId() == user.getRoomId()}">
                        <td>${room.getRoomName()}</td>
                    </c:if>
                </c:forEach>

                <c:forEach var="room" items="${rooms}">
                    <c:forEach var="roomType" items="${roomTypes}">
                        <c:if test="${(room.getId() == user.getRoomId()) and (room.getRoomTypeId() == roomType.getId())}">
                            <td>${roomType.getRoomTypeName()}</td>
                        </c:if>
                    </c:forEach>
                </c:forEach>

                <c:forEach var="room" items="${rooms}">
                    <c:forEach var="building" items="${buildings}">
                        <c:if test="${(room.getId() == user.getRoomId()) and (room.getBuildingId() == building.getId())}">
                            <td>${building.getBuildingName()}</td>
                        </c:if>
                    </c:forEach>
                </c:forEach>

                <c:forEach var="room" items="${rooms}">
                    <c:forEach var="building" items="${buildings}">
                        <c:forEach var="buildingType" items="${buildingTypes}">
                            <c:if test="${(room.getId() == user.getRoomId()) and (room.getBuildingId() == building.getId()) and (building.getBuildingTypeId() == buildingType.getId())}">
                                <td>${buildingType.getBuildingTypeName()}</td>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>

                <c:forEach var="building" items="${buildings}">
                    <c:if test="${(room.getId() == user.getRoomId()) and (room.getBuildingId() == building.getId())}">
                        <td>${building.getBuildingName()}</td>
                    </c:if>
                </c:forEach>

                <td style="align-content: center">
                    <a href="${pageContext.request.contextPath}/user?action=edit&id=${user.getId()}"
                       class="btn btn-secondary">
                        <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                        Edit
                    </a>
                </td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
