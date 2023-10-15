package com.example.project_winzhomes.service.impl;

import com.example.project_winzhomes.DAO.IRoomTypeDAO;
import com.example.project_winzhomes.DAO.impl.RoomTypeDAO;
import com.example.project_winzhomes.model.building.RoomType;
import com.example.project_winzhomes.service.IRoomTypeService;

import java.util.List;

public class RoomTypeService implements IRoomTypeService {
    IRoomTypeDAO roomTypeDAO = new RoomTypeDAO();

    @Override
    public List<RoomType> findAll() {
        return roomTypeDAO.findAll();
    }
}
