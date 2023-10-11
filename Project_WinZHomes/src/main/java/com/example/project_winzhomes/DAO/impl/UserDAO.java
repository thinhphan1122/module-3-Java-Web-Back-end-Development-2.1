package com.example.project_winzhomes.DAO.impl;

import com.example.project_winzhomes.DAO.IUserDAO;
import com.example.project_winzhomes.model.User;
import com.example.project_winzhomes.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private static final String UPDATE_USERS_SQL = "update users set username = ?, `password` = ?, full_name = ?, date_of_birth = ?, national_id = ?, gender = ?, address = ?, phone_number = ?, email = ?, is_deleted = ? where id = ? ";
    private static final String SELECT_ALL = "select * from users where is_deleted = 0";
    private static final String DELETE = "update users set is_deleted = 1 where id = ?";
    private static final String SELECT_BY_ID = "select * from users where id = ?";
    private static final String INSERT = "INSERT INTO users(username, `password`, full_name, date_of_birth, national_id, gender, address, phone_number, email, is_deleted) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String nationalId = resultSet.getString("national_id");
                boolean gender = resultSet.getBoolean("gender");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                User user = new User(id, username, password, fullName, dateOfBirth, nationalId, gender, address, phoneNumber, email);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean add(User user) {
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getDateOfBirth());
            preparedStatement.setString(5, user.getNationalId());
            preparedStatement.setBoolean(6, user.isGender());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getPhoneNumber());
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setBoolean(10, false);
            int num = preparedStatement.executeUpdate();
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(User user) {
        Connection connection = JDBCConnection.getConnection();
        boolean userUpdated;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getDateOfBirth());
            preparedStatement.setString(5, user.getNationalId());
            preparedStatement.setBoolean(6, user.isGender());
            preparedStatement.setString(7, user.getAddress());
            preparedStatement.setString(8, user.getPhoneNumber());
            preparedStatement.setString(9, user.getEmail());
            preparedStatement.setBoolean(10, false);
            preparedStatement.setInt(11, user.getId());
            userUpdated = preparedStatement.executeUpdate() > 0;
            return userUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(int id) {
        User user = null;
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String nationalId = resultSet.getString("national_id");
                boolean gender = resultSet.getBoolean("gender");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                user = new User(username, password, fullName, dateOfBirth, nationalId, gender, address, phoneNumber, email);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean remove(int id) {
        Connection connection = JDBCConnection.getConnection();
        boolean userDeleted;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            userDeleted = preparedStatement.executeUpdate() > 0;
            return userDeleted;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
