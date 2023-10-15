package com.example.project_winzhomes.service;

import com.example.project_winzhomes.model.building.Room;

import java.util.List;

public interface IRoomService {
    List<Room> findAll();

    Room findById(int id);
    boolean update(Room room);

    boolean addResident(int id);

    boolean removeResident(int id);
}
