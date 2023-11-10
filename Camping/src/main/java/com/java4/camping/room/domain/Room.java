package com.java4.camping.room.domain;

public class Room {
    private int id;
    private String roomName;
    private String roomDescription;
    private int roomPrice;
    private boolean available;

    // 다른 속성들에 대한 게터와 세터

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public Room() {
    }
    public Room(int id, String roomName, String roomDescription, int roomPrice) {
    	this.id = id;
    	this.roomName = roomName;
    	this.roomDescription = roomDescription;
    	this.roomPrice = roomPrice;
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

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
}
