package com.example.project_winzhomes.service.impl;

import com.example.project_winzhomes.DAO.IBuildingTypeDAO;
import com.example.project_winzhomes.DAO.impl.BuildingTypeDAO;
import com.example.project_winzhomes.model.building.BuildingType;
import com.example.project_winzhomes.service.IBuildingTypeService;

import java.util.List;


public class BuildingTypeService implements IBuildingTypeService {
    IBuildingTypeDAO buildingTypeDAO = new BuildingTypeDAO();

    @Override
    public List<BuildingType> findALL() {
        return buildingTypeDAO.findALL();
    }
}
