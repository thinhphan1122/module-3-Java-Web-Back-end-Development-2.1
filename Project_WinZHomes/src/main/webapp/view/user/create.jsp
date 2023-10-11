<%@ page import="com.example.project_winzhomes.model.User" %><%--
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
    <title>Create</title>
</head>
<body>
<div style="text-align: center">
    <h1>Create</h1>
    <form method="post">
        <div class="input-container ic1">
            <label class="placeholder">Username</label>
            <div class="cut"></div>
            <input name="username" class="input" type="text" placeholder="" value=""/>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Password</label>
            <div class="cut"></div>
            <input name="password" class="input" type="text" placeholder=" "/>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Full name</label>
            <div class="cut cut-short"></div>
            <input name="full_name" class="input" type="text" placeholder=" "/>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Date of birth</label>
            <div class="cut cut-short"></div>
            <input name="date_of_birth" class="input" type="date" placeholder=" "/>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">National ID</label>
            <div class="cut cut-short"></div>
            <input name="national_id" class="input" type="text" placeholder=" "/>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Gender</label>
            <div class="cut cut-short"></div>
            <select id="floatingSelect" name="gender">
                <option selected> Select gender</option>
                <option value="true">Male</option>
                <option value="false">Female</option>
            </select>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Address</label>
            <div class="cut cut-short"></div>
            <input name="address" class="input" type="text" placeholder=" "/>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Phone Number</label>
            <div class="cut cut-short"></div>
            <input name="phone_number" class="input" type="text" placeholder=" "/>
        </div>

        <div class="input-container ic2">
            <label class="placeholder">Email</label>
            <div class="cut cut-short"></div>
            <input name="email" class="input" type="text" placeholder=" "/>
        </div>
        <br>
        <button onclick="location.href = '/user';" class="btn btn-lg btn-success" type="submit" value="create">Create</button>
    </form>
</div>
</body>
</html>
