package com.example.project_winzhomes.DAO.impl;

import com.example.project_winzhomes.DAO.IRoleDAO;
import com.example.project_winzhomes.model.Role;
import com.example.project_winzhomes.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {
    private final String SELECT = "SELECT * FROM roles;";
    @Override
    public List<Role> findAll() {
        List<Role> roles = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String roleName = resultSet.getString("role_name");
                roles.add(new Role(id, roleName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roles;
    }
}
