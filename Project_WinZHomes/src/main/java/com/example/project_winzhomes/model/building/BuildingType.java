package com.example.project_winzhomes.model.building;

public class BuildingType {
    private int id;
    private String buildingTypeName;

    public BuildingType(int id, String buildingTypeName) {
        this.id = id;
        this.buildingTypeName = buildingTypeName;
    }

    public BuildingType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingTypeName() {
        return buildingTypeName;
    }

    public void setBuildingTypeName(String buildingTypeName) {
        this.buildingTypeName = buildingTypeName;
    }
}
