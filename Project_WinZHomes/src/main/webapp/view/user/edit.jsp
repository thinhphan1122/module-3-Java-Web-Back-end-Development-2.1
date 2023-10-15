<%@ page import="com.example.project_winzhomes.model.User" %>
<%@ page import="com.example.project_winzhomes.service.impl.BuildingService" %>
<%@ page import="com.example.project_winzhomes.service.impl.RoomService" %><%--
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
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <style>
        .site-footer {
            background-color: #26272b;
            padding: 45px 0 20px;
            font-size: 15px;
            line-height: 24px;
            color: #737373;
        }

        .site-footer hr {
            border-top-color: #bbb;
            opacity: 0.5
        }

        .site-footer hr.small {
            margin: 20px 0
        }

        .site-footer h6 {
            color: #fff;
            font-size: 16px;
            text-transform: uppercase;
            margin-top: 5px;
            letter-spacing: 2px
        }

        .site-footer a {
            color: #737373;
        }

        .site-footer a:hover {
            color: #3366cc;
            text-decoration: none;
        }

        .footer-links {
            padding-left: 0;
            list-style: none
        }

        .footer-links li {
            display: block
        }

        .footer-links a {
            color: #737373
        }

        .footer-links a:active, .footer-links a:focus, .footer-links a:hover {
            color: #3366cc;
            text-decoration: none;
        }

        .footer-links.inline li {
            display: inline-block
        }

        .site-footer .social-icons {
            text-align: right
        }

        .site-footer .social-icons a {
            width: 40px;
            height: 40px;
            line-height: 40px;
            margin-left: 6px;
            margin-right: 0;
            border-radius: 100%;
            background-color: #33353d
        }

        .copyright-text {
            margin: 0
        }

        @media (max-width: 991px) {
            .site-footer [class^=col-] {
                margin-bottom: 30px
            }
        }

        @media (max-width: 767px) {
            .site-footer {
                padding-bottom: 0
            }

            .site-footer .copyright-text, .site-footer .social-icons {
                text-align: center
            }
        }

        .social-icons {
            padding-left: 0;
            margin-bottom: 0;
            list-style: none
        }

        .social-icons li {
            display: inline-block;
            margin-bottom: 4px
        }

        .social-icons li.title {
            margin-right: 15px;
            text-transform: uppercase;
            color: #96a2b2;
            font-weight: 700;
            font-size: 13px
        }

        .social-icons a {
            background-color: #eceeef;
            color: #818a91;
            font-size: 16px;
            display: inline-block;
            line-height: 44px;
            width: 44px;
            height: 44px;
            text-align: center;
            margin-right: 8px;
            border-radius: 100%;
            -webkit-transition: all .2s linear;
            -o-transition: all .2s linear;
            transition: all .2s linear
        }

        .social-icons a:active, .social-icons a:focus, .social-icons a:hover {
            color: #fff;
            background-color: #29aafe
        }

        .social-icons.size-sm a {
            line-height: 34px;
            height: 34px;
            width: 34px;
            font-size: 14px
        }

        .social-icons a.facebook:hover {
            background-color: #3b5998
        }

        .social-icons a.twitter:hover {
            background-color: #00aced
        }

        .social-icons a.linkedin:hover {
            background-color: #007bb6
        }

        .social-icons a.dribbble:hover {
            background-color: #ea4c89
        }

        @media (max-width: 767px) {
            .social-icons li.title {
                display: block;
                margin-right: 0;
                font-weight: 600
            }
        }
    </style>
    <title>Create</title>
</head>
<body>
<%
    BuildingService buildingService = new BuildingService();
    RoomService roomService = new RoomService();
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
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/user">User List</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log Out</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div style="margin: auto;  width: 50%; padding: 10px;">
    <h1>Edit</h1>
    <hr>
    <form method="post">
        <div class="form-group">
            <label for="exampleInputUsername1">Username</label>
            <input type="text" name="username" class="form-control" id="exampleInputUsername1" aria-describedby=""
                   placeholder="Username" value="" disabled>
            <br>
        </div>

        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="text" name="password" class="form-control" id="exampleInputPassword1"
                   aria-describedby="passwordHelp" placeholder="${user.getPassword()}" value=""/>
            <small id="passwordHelp" class="form-text text-muted">Never share password with anyone else.</small>
        </div>
        <br>

        <div class="form-group">
            <label for="exampleInputFullName1">Full Name</label>
            <input type="text" name="full_name" class="form-control" id="exampleInputFullName1" aria-describedby=""
                   placeholder="Full Name"/>
            <br>
        </div>

        <div class="form-group">
            <label for="exampleInputDateOfBirth1">Date Of Birth</label>
            <input type="date" name="date_of_birth" class="form-control" id="exampleInputDateOfBirth1"
                   aria-describedby="" placeholder="Date Of Birth"/>
            <br>
        </div>

        <div class="form-group">
            <label for="exampleInputNationalId1">National ID</label>
            <input type="text" name="national_id" class="form-control" id="exampleInputNationalId1" aria-describedby=""
                   placeholder="National ID"/>
            <br>
        </div>

        <div class="form-group">
            <label>Gender</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="1">
            <label class="form-check-label" for="inlineRadio1">Male</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="2">
            <label class="form-check-label" for="inlineRadio2">Female</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="3" disabled>
            <label class="form-check-label" for="inlineRadio3">None specific (disabled)</label>
        </div>
        <br>
        <br>

        <div class="form-group">
            <label for="exampleInputAddress1">Address</label>
            <input type="text" name="address" class="form-control" id="exampleInputAddress1" aria-describedby=""
                   placeholder="Address"/>
            <br>
        </div>

        <div class="form-group">
            <label for="exampleInputPhoneNumber1">Phone Number</label>
            <input type="text" name="phone_number" class="form-control" id="exampleInputPhoneNumber1"
                   aria-describedby="" placeholder="Phone Number"/>
            <br>
        </div>

        <div class="form-group">
            <label for="exampleInputEmail1">Email</label>
            <input type="text" name="email" class="form-control" id="exampleInputEmail1" aria-describedby=""
                   placeholder="Email"/>
            <br>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Role</label>
            <select name="role_id" class="form-select" aria-label="Default select example">
                <option selected>Open this select menu</option>
                <option value="2"></option>
                <option value="1">Admin</option>
                <option value="2">Customer</option>
            </select>
        </div>
        <br>

        <div class="input-container ic2">
            <label class="placeholder">Room - Building</label>
            <select name="room_id" class="form-select" aria-label="Default select example">
                <c:forEach items="${rooms}" var="room">
                    <c:forEach items="${buildings}" var="building">
                        <c:if test="${room.buildingId == building.id}">
                            <option value="${room.getId()}">
                                    ${room.getRoomName()} - ${building.buildingName}
                            </option>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </select>
        </div>

        <br>

        <div style="position: absolute;right: 380px;width: 300px;padding: 10px;">
            <button onclick="location.href = '/user';" class="btn btn-success btn-lg" type="button" value="cancel">
                Cancel
            </button>
            <button onclick="location.href = '/user';" class="btn btn-success btn-lg" type="submit" value="create">
                Done
            </button>
        </div>
        <br><br>
        <br><br>
    </form>
</div>
<!-- Site footer -->
<footer class="site-footer">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <h6>About</h6>
                <p class="text-justify">Scanfcode.com <i>CODE WANTS TO BE SIMPLE </i> is an initiative to help the
                    upcoming programmers with the code. Scanfcode focuses on providing the most efficient code or
                    snippets as the code wants to be simple. We will help programmers build up concepts in different
                    programming languages that include C, C++, Java, HTML, CSS, Bootstrap, JavaScript, PHP, Android, SQL
                    and Algorithm.</p>
            </div>

            <div class="col-xs-6 col-md-3">
                <h6>Categories</h6>
                <ul class="footer-links">
                    <li><a href="http://scanfcode.com/category/c-language/">C</a></li>
                    <li><a href="http://scanfcode.com/category/front-end-development/">UI Design</a></li>
                    <li><a href="http://scanfcode.com/category/back-end-development/">PHP</a></li>
                    <li><a href="http://scanfcode.com/category/java-programming-language/">Java</a></li>
                    <li><a href="http://scanfcode.com/category/android/">Android</a></li>
                    <li><a href="http://scanfcode.com/category/templates/">Templates</a></li>
                </ul>
            </div>

            <div class="col-xs-6 col-md-3">
                <h6>Quick Links</h6>
                <ul class="footer-links">
                    <li><a href="http://scanfcode.com/about/">About Us</a></li>
                    <li><a href="http://scanfcode.com/contact/">Contact Us</a></li>
                    <li><a href="http://scanfcode.com/contribute-at-scanfcode/">Contribute</a></li>
                    <li><a href="http://scanfcode.com/privacy-policy/">Privacy Policy</a></li>
                    <li><a href="http://scanfcode.com/sitemap/">Sitemap</a></li>
                </ul>
            </div>
        </div>
        <hr>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-sm-6 col-xs-12">
                <p class="copyright-text">Copyright &copy; 2017 All Rights Reserved by
                    <a href="#">Scanfcode</a>.
                </p>
            </div>

            <div class="col-md-4 col-sm-6 col-xs-12">
                <ul class="social-icons">
                    <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                    <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                    <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
