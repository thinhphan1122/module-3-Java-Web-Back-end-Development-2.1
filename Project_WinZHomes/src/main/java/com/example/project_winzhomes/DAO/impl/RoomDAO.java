package com.example.project_winzhomes.DAO.impl;

import com.example.project_winzhomes.DAO.IRoomDAO;
import com.example.project_winzhomes.model.User;
import com.example.project_winzhomes.model.building.Room;
import com.example.project_winzhomes.service.impl.UserService;
import com.example.project_winzhomes.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO implements IRoomDAO {
    private final String SELECT = "SELECT * FROM rooms;";
    private static final String SELECT_BY_ID = "select * from rooms where id = ?";
    private static final String UPDATE_ROOMS_SQL = "update rooms set room_name = ?, room_type_id = ?, building_id = ?, number_of_resident = ? where id =?";
    private static final String REMOVE_RESIDENT = "update users set room_id = 1 where id = ?";
    private static final String ADD_RESIDENT = "update users set room_id = ? where id = ?"; //cần sửa

    @Override
    public List<Room> findAll() {
        List<Room> rooms = new ArrayList<>();
        UserService userService = new UserService();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String roomName = resultSet.getString("room_name");
                int buildingId = resultSet.getInt("building_id");
                int roomTypeId = resultSet.getInt("room_type_id");
                int numberOfResident = resultSet.getInt("number_of_resident");
                Room room = new Room(id, roomName, buildingId, roomTypeId, numberOfResident);
                rooms.add(room);

                if (room.getNumberOfResident() == 0) {
                    for (User user : userService.findAll()) {
                        if (room.getId() == user.getRoomId()) {
                            numberOfResident += 1;
                        }
                        room.setNumberOfResident(numberOfResident);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    @Override
    public Room findById(int id) {
        Room room = null;
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String roomName = resultSet.getString("room_name");
                int buildingId = resultSet.getInt("building_id");
                int roomTypeId = resultSet.getInt("room_type_id");
                int numberOfResident = resultSet.getInt("number_of_resident");
                room = new Room(id, roomName, buildingId, roomTypeId, numberOfResident);
            }
            return room;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;
    }

    public boolean update(Room room) {
        Connection connection = JDBCConnection.getConnection();
        boolean rowUpdated;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROOMS_SQL);
            preparedStatement.setString(1, room.getRoomName());
            preparedStatement.setInt(2, room.getRoomTypeId());
            preparedStatement.setInt(3, room.getBuildingId());
            preparedStatement.setInt(4, room.getNumberOfResident());
            rowUpdated = preparedStatement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Cần sừa
    @Override
    public boolean addResident(int id) {
        Connection connection = JDBCConnection.getConnection();
        boolean residentAdded = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_RESIDENT);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id);
            residentAdded = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return residentAdded;
    }


    @Override
    public boolean removeResident(int id) {
        Connection connection = JDBCConnection.getConnection();
        boolean residentRemove = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_RESIDENT);
            preparedStatement.setInt(1, id);
            residentRemove = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return residentRemove;
    }
}
