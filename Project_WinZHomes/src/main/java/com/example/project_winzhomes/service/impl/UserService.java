package com.example.project_winzhomes.service.impl;

import com.example.project_winzhomes.model.User;
import com.example.project_winzhomes.service.IUserService;

import com.example.project_winzhomes.DAO.impl.UserDAO;
import com.example.project_winzhomes.DAO.IUserDAO;

import java.util.List;

public class UserService implements IUserService {
    IUserDAO userDAO = new UserDAO();

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean add(User user) {
        return userDAO.add(user);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public boolean edit(User user) {
        return userDAO.edit(user);
    }

    @Override
    public void remove(int id) {
        userDAO.remove(id);
    }
}
