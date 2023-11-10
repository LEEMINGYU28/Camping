package com.java4.camping.room.service;

import com.java4.camping.room.dao.RoomDAO;
import com.java4.camping.room.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomDAO roomDAO;

    public void addRoom(Room room) {
        roomDAO.addRoom(room);
    }

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    public Room getRoomById(int id) {
        return roomDAO.get(id);
    }

}
