package com.java4.camping.room.controller;

import com.java4.camping.room.domain.Room;
import com.java4.camping.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listRooms(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "room/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewRoom(@PathVariable("id") int id, Model model) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "room/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("room", new Room());
        return "room/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addRoom(@ModelAttribute Room room) {
        roomService.addRoom(room);
        return "redirect:/rooms/list";
    }
}



