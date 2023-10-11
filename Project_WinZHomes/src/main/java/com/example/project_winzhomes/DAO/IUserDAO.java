package com.example.project_winzhomes.DAO;

import com.example.project_winzhomes.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> findAll();
    boolean add(User user);
    User findById(int id);
    boolean edit(User user);
    boolean remove(int id);
}
