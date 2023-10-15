package com.example.project_winzhomes.model.building;

public class RoomType {
    private int id;
    private String roomTypeName;

    public RoomType(int id, String roomTypeName) {
        this.id = id;
        this.roomTypeName = roomTypeName;
    }

    public RoomType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }
}
