package com.example.project_winzhomes.DAO;

import com.example.project_winzhomes.model.building.Room;

import java.util.List;

public interface IRoomDAO {
    List<Room> findAll();

    Room findById(int id);

    boolean update(Room room);

    boolean addResident(int id);
    boolean removeResident(int id);
}
