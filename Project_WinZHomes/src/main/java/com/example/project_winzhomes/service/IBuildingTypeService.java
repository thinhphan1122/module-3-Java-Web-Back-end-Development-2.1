package com.example.project_winzhomes.service;

import com.example.project_winzhomes.model.building.BuildingType;

import java.util.ArrayList;
import java.util.List;

public interface IBuildingTypeService {
    List<BuildingType> buildingTypes = new ArrayList<>();

    List<BuildingType> findALL();
}
