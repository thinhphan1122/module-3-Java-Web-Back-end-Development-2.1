package com.example.project_winzhomes.service.impl;

import com.example.project_winzhomes.DAO.IRoomDAO;
import com.example.project_winzhomes.DAO.impl.RoomDAO;
import com.example.project_winzhomes.model.building.Room;
import com.example.project_winzhomes.service.IRoomService;

import java.util.List;

public class RoomService implements IRoomService {
    IRoomDAO roomDAO = new RoomDAO();

    @Override
    public List<Room> findAll() {
        return roomDAO.findAll();
    }

    @Override
    public Room findById(int id) {
        return roomDAO.findById(id);
    }

    @Override
    public boolean update(Room room) {
        return roomDAO.update(room);
    }

    @Override
    public boolean addResident(int user) {
        return roomDAO.addResident(user);
    }


    @Override
    public boolean removeResident(int id) {
        return roomDAO.removeResident(id);
    }
}
