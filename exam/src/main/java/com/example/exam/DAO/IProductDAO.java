package com.example.exam.DAO;

import com.example.exam.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll();

    boolean add(Product product);

    boolean remove(int id);
}
