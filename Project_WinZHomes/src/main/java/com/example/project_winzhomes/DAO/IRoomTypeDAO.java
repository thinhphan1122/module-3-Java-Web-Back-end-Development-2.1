package com.example.project_winzhomes.DAO;

import com.example.project_winzhomes.model.building.RoomType;

import java.util.List;

public interface IRoomTypeDAO {
    List<RoomType> findAll();
}
