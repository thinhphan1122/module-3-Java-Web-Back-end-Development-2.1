package com.example.exam.service;

import com.example.exam.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    boolean add(Product product);

    boolean remove(int id);
}
