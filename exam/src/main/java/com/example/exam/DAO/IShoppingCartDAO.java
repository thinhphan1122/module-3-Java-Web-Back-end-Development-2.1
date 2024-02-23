package com.example.exam.DAO;

import com.example.exam.model.Product;
import com.example.exam.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartDAO {
    List<ShoppingCart> findAll();

    boolean addProductToCart(ShoppingCart shoppingCart);

    ShoppingCart findById(int id);

    boolean update(ShoppingCart shoppingCart);
}
