package com.example.exam.DAO.impl;

import com.example.exam.DAO.IProductDAO;
import com.example.exam.model.Product;
import com.example.exam.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private static final String SELECT_ALL = "select * from product where is_deleted = 0";
    private static final String INSERT = "INSERT INTO product(name, price, description, image_url) VALUES(?, ?, ?, ?)";
    private static final String REMOVE = "update product set is_deleted = 1 where id = ?";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = Float.parseFloat(resultSet.getString("price"));
                String description = resultSet.getString("description");
                String imageUrl = resultSet.getString("image_url");
                Product product = new Product(id, name, price, description, imageUrl);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean add(Product product) {
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getImageUrl());
            int num = preparedStatement.executeUpdate();
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        Connection connection = JDBCConnection.getConnection();
        boolean productDeleted = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE);
            preparedStatement.setInt(1, id);
            productDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDeleted;
    }
}
