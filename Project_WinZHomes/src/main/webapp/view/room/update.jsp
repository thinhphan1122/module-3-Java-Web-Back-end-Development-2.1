<%@ page import="com.example.project_winzhomes.model.User" %>
<%@ page import="com.example.project_winzhomes.service.impl.RoomService" %>
<%@ page import="com.example.project_winzhomes.service.impl.BuildingService" %>
<%@ page import="com.example.project_winzhomes.service.impl.UserService" %>
<%@ page import="com.example.project_winzhomes.service.impl.RoleService" %>
<%@ page import="com.example.project_winzhomes.service.impl.BuildingTypeService" %><%--
  Created by IntelliJ IDEA.
  User: Something
  Date: 05-Oct-23
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>Update</title>
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
    BuildingService buildingService = new BuildingService();
    BuildingTypeService buildingTypeService = new BuildingTypeService();
    RoomService roomService = new RoomService();
    UserService userService = new UserService();
    RoleService roleService = new RoleService();
    request.setAttribute("buildings", buildingService.findALL());
    request.setAttribute("buildingTypes", buildingTypeService.findALL());
    request.setAttribute("rooms", roomService.findAll());
    request.setAttribute("users", userService.findAll());
    request.setAttribute("roles", roleService.findAll());
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

<div>
    <h1>Update</h1>
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
            <c:if test="${room.getId() == user.getRoomId()}">
                <tr class="align-middle">
                    <td id="user_id">${user.getId()}</td>

                    <td>
                        <div class="d-flex align-items-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar2.png"
                                 class="avatar sm rounded-pill me-3 flex-shrink-0" alt="User">
                        </div>
                    </td>

                    <td>${user.getUsername()}</td>

                    <td>
                <span class="d-inline-block align-middle">
                        ${user.getFullName()}
                </span>
                    </td>

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


                    <td style="align-content: center">
                        <c:if test="${user.getRoomId() != 1}">
                            <a href="${pageContext.request.contextPath}/room?action=remove&id=${user.getId()}"
                               class="btn btn-danger">
                                <span class="fa-solid fa-user-pen text-primary h4 m-auto"></span>
                                Remove
                            </a>
                        </c:if>

                        <!-- Button trigger modal -->
                            <%--                <c:if test="${user.getRoleId() != 1}">--%>
                            <%--                    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
                            <%--                        Remove--%>
                            <%--                    </button>--%>
                            <%--                </c:if>--%>

                        <!-- Modal -->
                            <%--                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"--%>
                            <%--                     aria-hidden="true">--%>
                            <%--                    <div class="modal-dialog">--%>
                            <%--                        <div class="modal-content">--%>
                            <%--                            <div class="modal-header">--%>
                            <%--                                <h1 class="modal-title fs-5" id="exampleModalLabel" style="color: black">Remove</h1>--%>
                            <%--                                <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
                            <%--                                        aria-label="Close"></button>--%>
                            <%--                            </div>--%>
                            <%--                            <div class="modal-body">--%>
                            <%--                                <p style="color: black">Are you sure that you want to remove this user?</p>--%>
                            <%--                            </div>--%>
                            <%--                            <div class="modal-footer">--%>
                            <%--                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>--%>
                            <%--                                <button type="submit" class="btn btn-danger">--%>
                            <%--                                    <a href="${pageContext.request.contextPath}/user?action=remove&id=${user.getId()}">--%>
                            <%--                                        Confirm--%>
                            <%--                                    </a>--%>
                            <%--                                </button>--%>
                            <%--                            </div>--%>
                            <%--                        </div>--%>
                            <%--                    </div>--%>
                            <%--                </div>--%>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
