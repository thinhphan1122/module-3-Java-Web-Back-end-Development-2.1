package com.example.exam.service;

import com.example.exam.model.Product;
import com.example.exam.model.ShoppingCart;

import java.util.List;

public interface IShoppingCartService {

    List<ShoppingCart> findAll();
    ShoppingCart findById(int id);
    boolean update(ShoppingCart shoppingCart);

    boolean addProductToCart(ShoppingCart shoppingCart);
}
