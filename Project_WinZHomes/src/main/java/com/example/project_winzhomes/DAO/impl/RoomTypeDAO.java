package com.example.project_winzhomes.DAO.impl;

import com.example.project_winzhomes.DAO.IRoomTypeDAO;
import com.example.project_winzhomes.model.building.Room;
import com.example.project_winzhomes.model.building.RoomType;
import com.example.project_winzhomes.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAO implements IRoomTypeDAO {
    private final String SELECT = "SELECT * FROM room_types;";

    @Override
    public List<RoomType> findAll() {
        List<RoomType> roomTypes = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String roomTypeName = resultSet.getString("room_type_name");
                roomTypes.add(new RoomType(id, roomTypeName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomTypes;
    }
}
