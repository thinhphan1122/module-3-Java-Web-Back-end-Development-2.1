package com.example.project_winzhomes.DAO.impl;

import com.example.project_winzhomes.DAO.IBuildingTypeDAO;
import com.example.project_winzhomes.model.building.BuildingType;
import com.example.project_winzhomes.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingTypeDAO implements IBuildingTypeDAO {
    private final String SELECT = "SELECT * FROM building_types;";
    @Override
    public List<BuildingType> findALL() {
        List<BuildingType> buildingTypes = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String buildingTypeName = resultSet.getString("building_type_name");
                buildingTypes.add(new BuildingType(id, buildingTypeName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return buildingTypes;
    }
}
