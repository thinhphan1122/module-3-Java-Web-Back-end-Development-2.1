package com.example.project_winzhomes.controller;

import com.example.project_winzhomes.model.User;
import com.example.project_winzhomes.service.IBuildingService;
import com.example.project_winzhomes.service.IBuildingTypeService;
import com.example.project_winzhomes.service.IRoleService;
import com.example.project_winzhomes.service.IRoomService;
import com.example.project_winzhomes.service.IRoomTypeService;
import com.example.project_winzhomes.service.IUserService;
import com.example.project_winzhomes.service.impl.BuildingService;
import com.example.project_winzhomes.service.impl.BuildingTypeService;
import com.example.project_winzhomes.service.impl.RoleService;
import com.example.project_winzhomes.service.impl.RoomService;
import com.example.project_winzhomes.service.impl.RoomTypeService;
import com.example.project_winzhomes.service.impl.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private final IUserService userService = new UserService();
    private final IRoleService roleService = new RoleService();
    private final IRoomService roomService = new RoomService();
    private final IRoomTypeService roomTypeService = new RoomTypeService();
    private final IBuildingService buildingService = new BuildingService();
    private final IBuildingTypeService buildingTypeService = new BuildingTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewUser(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "register":
                displayAddForm(request, response);
                break;
            case "edit":
                displayEditForm(request, response);
                break;
            case "remove":
                remove(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }
    }

    private void displayAddForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("user", userService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addNewUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");

        String password = request.getParameter("password");
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        String fullName = request.getParameter("full_name");
        String dateOfBirth = request.getParameter("date_of_birth");
        String nationalId = request.getParameter("national_id");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        int roleId = Integer.parseInt(request.getParameter("role_id"));
        int roomId = Integer.parseInt(request.getParameter("room_id"));

        User user = new User(username, hashPassword, fullName, dateOfBirth, nationalId, gender, address, phoneNumber, email, roleId, roomId);
        boolean check = userService.add(user);
        String message = "Add new user successfully!";

        if (!check) {
            message = "Add new user failed!";
        }

        request.setAttribute("message", message);
        try {
            response.sendRedirect(request.getContextPath() + "/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userService.findById(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userService.findById(id));

        String password = request.getParameter("password");
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        String fullName = request.getParameter("full_name");
        String dateOfBirth = request.getParameter("date_of_birth");
        String nationalId = request.getParameter("national_id");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        int roleId = Integer.parseInt(request.getParameter("role_id"));
        int roomId = Integer.parseInt(request.getParameter("room_id"));

        User user = userService.findById(id);
        user.setId(id);
        user.setPassword(hashPassword);
        user.setFullName(fullName);
        user.setDateOfBirth(dateOfBirth);
        user.setNationalId(nationalId);
        user.setGender(gender);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setRoleId(roleId);
        user.setRoomId(roomId);

        boolean check = userService.edit(user);
        String message = "Update successfully!";
        if (!check) {
            message = "Update failed!";
        }
        request.setAttribute("message", message);
        request.setAttribute("check", check);

        try {
            response.sendRedirect(request.getContextPath() + "/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.remove(id);
        request.setAttribute("user", userService.findAll());
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        request.setAttribute("users", userService.findAll());
        request.setAttribute("roles", roleService.findAll());
        request.setAttribute("rooms", roomService.findAll());
        request.setAttribute("roomTypes", roomTypeService.findAll());
        request.setAttribute("buildings", buildingService.findALL());
        request.setAttribute("buildingTypes", buildingTypeService.findALL());

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}