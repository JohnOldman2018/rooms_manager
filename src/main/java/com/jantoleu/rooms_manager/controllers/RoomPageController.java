package com.jantoleu.rooms_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoomPageController {

    @GetMapping("room.html")
    public String getRoomPage(@RequestParam(name = "roomId") Integer roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "room";
    }
}
