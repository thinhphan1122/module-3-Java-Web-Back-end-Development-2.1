package com.example.project_winzhomes.service;

import com.example.project_winzhomes.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean add(User user);
    User findById(int id);
    boolean  edit(User user);
    boolean remove(int id);
}
