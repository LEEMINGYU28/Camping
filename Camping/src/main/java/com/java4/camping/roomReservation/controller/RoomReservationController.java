package com.java4.camping.roomReservation.controller;

import com.java4.camping.roomReservation.domain.RoomReservation;
import com.java4.camping.roomReservation.service.RoomReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class RoomReservationController {

    @Autowired
    private RoomReservationService reservationService;

    @RequestMapping("/list")
    public String showReservationList(Model model) {
        List<RoomReservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservation/list";
    }

}
