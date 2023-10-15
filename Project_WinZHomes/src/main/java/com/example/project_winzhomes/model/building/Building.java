package com.example.project_winzhomes.model.building;

public class Building {
    private int id;
    private String buildingName;
    private int buildingTypeId;
    private int numberOfResident;

    public Building(int id, String buildingName, int buildingTypeId, int numberOfResident) {
        this.id = id;
        this.buildingName = buildingName;
        this.buildingTypeId = buildingTypeId;
        this.numberOfResident = numberOfResident;
    }

    public Building() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getBuildingTypeId() {
        return buildingTypeId;
    }

    public void setBuildingTypeId(int buildingTypeId) {
        this.buildingTypeId = buildingTypeId;
    }

    public int getNumberOfResidents() {
        return numberOfResident;
    }

    public void setNumberOfResident(int numberOfResident) {
        this.numberOfResident = numberOfResident;
    }
}
