package com.example.project_winzhomes.service.impl;

import com.example.project_winzhomes.DAO.IBuildingDAO;
import com.example.project_winzhomes.DAO.impl.BuildingDAO;
import com.example.project_winzhomes.model.building.Building;
import com.example.project_winzhomes.service.IBuildingService;

import java.util.List;

public class BuildingService implements IBuildingService {
    IBuildingDAO buildingDAO = new BuildingDAO();

    @Override
    public List<Building> findALL() {
        return buildingDAO.findALL();
    }
}
