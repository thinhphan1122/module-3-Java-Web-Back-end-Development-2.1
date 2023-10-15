package com.example.project_winzhomes.model.building;

public class Room {
    private int id;
    private String roomName;
    private int buildingId;
    private int roomTypeId;
    private int numberOfResident;

    public Room(int id, String roomName, int buildingId, int roomTypeId, int numberOfResident) {
        this.id = id;
        this.roomName = roomName;
        this.buildingId = buildingId;
        this.roomTypeId = roomTypeId;
        this.numberOfResident = numberOfResident;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public int getNumberOfResident() {
        return numberOfResident;
    }

    public void setNumberOfResident(int numberOfResident) {
        this.numberOfResident = numberOfResident;
    }
}
