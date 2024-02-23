package com.example.exam.service.impl;

import com.example.exam.DAO.IProductDAO;
import com.example.exam.DAO.IShoppingCartDAO;
import com.example.exam.DAO.impl.ProductDAO;
import com.example.exam.DAO.impl.ShoppingCartDAO;
import com.example.exam.model.Product;
import com.example.exam.model.ShoppingCart;
import com.example.exam.service.IShoppingCartService;

import java.util.List;

public class ShoppingCartService implements IShoppingCartService {
    IShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartDAO.findAll();
    }

    @Override
    public ShoppingCart findById(int id) {
        return shoppingCartDAO.findById(id);
    }

    @Override
    public boolean update(ShoppingCart shoppingCart) {
        return shoppingCartDAO.update(shoppingCart);
    }

    @Override
    public boolean addProductToCart(ShoppingCart shoppingCart) {
        return shoppingCartDAO.addProductToCart(shoppingCart);
    }
}
