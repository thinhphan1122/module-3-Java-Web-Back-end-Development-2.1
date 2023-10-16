package com.example.project_winzhomes.controller;

import com.example.project_winzhomes.model.User;
import com.example.project_winzhomes.model.building.Room;
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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name = "RoomServlet", urlPatterns = "/room")
public class RoomServlet extends HttpServlet {
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
            case "addNewResident":
                addResident(request, response);
                break;
            case "update":
                updateRoomInfo(request, response);
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
            case "displayAddResidentList":
                displayAddResidentList(request, response);
                break;
            case "addResident":
                addResident(request, response);
                break;
            case "update":
                displayRoomUserList(request, response);
                break;
            case "remove":
                removeUser(request, response);
                break;
            default:
                listRooms(request, response);
                break;
        }
    }

    private void displayAddResidentList(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("room", roomService.findById(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/room/addNewResident.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void displayRoomUserList(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("room", roomService.findById(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/room/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateRoomInfo(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("user", userService.findAll());

        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("room", roomService.findAll());
        Room room = roomService.findById(id);
        String roomName = request.getParameter("room_name");
        int roomTypeId = Integer.parseInt(request.getParameter("room_type_id"));
        int buildingId = Integer.parseInt(request.getParameter("building_id"));

        room.setId(id);
        room.setRoomName(roomName);
        room.setRoomTypeId(roomTypeId);
        room.setBuildingId(buildingId);

        int numberOfResident = 0;
        for (User user : userService.findAll()) {
            if (user.getRoomId() == room.getId()) {
                numberOfResident += 1;
            }
            room.setNumberOfResident(numberOfResident);
        }

        boolean check = roomService.update(room);
        String message = "Update successfully!";
        if (!check) {
            message = "Update failed!";
        }
        request.setAttribute("message", message);
        request.setAttribute("check", check);

        try {
            response.sendRedirect(request.getContextPath() + "/room");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean addResident(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", userService.findById(id));
        User user = userService.findById(id);

        int newUserRoomId = Integer.parseInt(request.getParameter("room_id"));

//        String roomName = request.getParameter("room_name"); //cần sửa room_name = null
        for (Room room : roomService.findAll()) {
            if(newUserRoomId == room.getId()){
                user.setRoomId(newUserRoomId);
                break;
            }
        }

        boolean check = userService.edit(user);
        String message = "Update successfully!";
        if (!check) {
            message = "Update failed!";
        }
        request.setAttribute("message", message);
        request.setAttribute("check", check);

        try {
            response.sendRedirect("/room");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        roomService.removeResident(id);
        request.setAttribute("user", userService.findAll());
        try {
            response.sendRedirect("/room");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listRooms(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/room/list.jsp");
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
