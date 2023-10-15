package com.example.project_winzhomes.service.impl;

import com.example.project_winzhomes.DAO.IRoleDAO;
import com.example.project_winzhomes.DAO.impl.RoleDAO;
import com.example.project_winzhomes.model.Role;
import com.example.project_winzhomes.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    IRoleDAO roleDAO = new RoleDAO();

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

}
