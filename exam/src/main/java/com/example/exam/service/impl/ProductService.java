package com.example.exam.service.impl;

import com.example.exam.DAO.IProductDAO;
import com.example.exam.DAO.impl.ProductDAO;
import com.example.exam.model.Product;
import com.example.exam.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductDAO productDAO = new ProductDAO();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productDAO.add(product);
    }

    @Override
    public boolean remove(int id) {
        return productDAO.remove(id);
    }
}
