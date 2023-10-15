package com.example.project_winzhomes.DAO.impl;

import com.example.project_winzhomes.DAO.IBuildingDAO;
import com.example.project_winzhomes.model.Role;
import com.example.project_winzhomes.model.building.Building;
import com.example.project_winzhomes.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingDAO implements IBuildingDAO {
    private final String SELECT = "SELECT * FROM buildings;";
    @Override
    public List<Building> findALL() {
        List<Building> buildings = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String buildingName = resultSet.getString("building_name");
                int buildingTypeId = resultSet.getInt("building_type_id");
                int numberOfResident = resultSet.getInt("number_of_resident");
                buildings.add(new Building(id, buildingName, buildingTypeId, numberOfResident));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return buildings;
    }
}
