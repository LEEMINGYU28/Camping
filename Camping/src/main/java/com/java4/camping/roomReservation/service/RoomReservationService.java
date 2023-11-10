package com.java4.camping.roomReservation.service;

import com.java4.camping.room.dao.RoomDAO;
import com.java4.camping.room.domain.Room;
import com.java4.camping.roomReservation.dao.RoomReservationDAO;
import com.java4.camping.roomReservation.domain.RoomReservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RoomReservationService {

    @Autowired
    private RoomReservationDAO reservationDAO;
    @Autowired
    private RoomDAO roomDAO;

    public void addReservation(RoomReservation reservation) {
        reservationDAO.addReservation(reservation);
    }

    public List<RoomReservation> getAllReservations() {
        return reservationDAO.getAllReservations();
    }
    

    public RoomReservation getById(int id) {
        return reservationDAO.getById(id);
    }
    public List<Room> getAvailableRooms(Date checkInDate, Date checkOutDate) {
        return roomDAO.getAvailableRooms(checkInDate, checkOutDate);
    }

    public void cancelReservation(int reservationId) {
        reservationDAO.cancelReservation(reservationId);
    }
}
