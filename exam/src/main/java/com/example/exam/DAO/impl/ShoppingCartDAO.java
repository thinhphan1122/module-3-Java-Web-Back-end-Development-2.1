package com.example.exam.DAO.impl;

import com.example.exam.DAO.IShoppingCartDAO;
import com.example.exam.model.Product;
import com.example.exam.model.ShoppingCart;
import com.example.exam.utils.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO implements IShoppingCartDAO {
    private static final String SELECT_ALL = "select * from shopping_cart where is_deleted = 0";
    private static final String SELECT_BY_ID = "select * from shopping_cart where id = ?";
    private static final String UPDATE = "update shopping_cart set product_id = ?, quantity = ? where id =?";
    private static final String INSERT = "INSERT INTO shopping_cart(product_id, quantity) VALUES(?, ?)";

    @Override
    public List<ShoppingCart> findAll() {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                ShoppingCart shoppingCart = new ShoppingCart(id, productId, quantity);
                shoppingCarts.add(shoppingCart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCarts;
    }

    @Override
    public boolean addProductToCart(ShoppingCart shoppingCart) {
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1, shoppingCart.getProductId());
            preparedStatement.setInt(2, shoppingCart.getQuantity());
            int num = preparedStatement.executeUpdate();
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ShoppingCart findById(int id) {
        ShoppingCart shoppingCart = null;
        Connection connection = JDBCConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                int quantity = resultSet.getInt("quantity");
                shoppingCart = new ShoppingCart(id, productId, quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoppingCart;
    }

    @Override
    public boolean update(ShoppingCart shoppingCart) {
        Connection connection = JDBCConnection.getConnection();
        boolean rowUpdated;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, shoppingCart.getProductId());
            preparedStatement.setInt(2, shoppingCart.getQuantity());
            rowUpdated = preparedStatement.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
