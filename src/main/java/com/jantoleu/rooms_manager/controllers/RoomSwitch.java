package com.jantoleu.rooms_manager.controllers;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.service.RoomService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@PostMapping("/api/room/{roomId}/{status:on/off}")
public class RoomSwitch {

    private RoomService roomService;
    List<Room> rooms = roomService.getAllRooms();

    public Boolean setRoomById (@PathParam(value="light_is_on") Boolean switchParam, Model model, List<Room> rooms) {
        model.addAttribute("nameAttribute", switchParam);
        for (Room rm: rooms) {
            Room room = rm;
            if (rm.getLightIsOn() == switchParam) {
                invertLight(switchParam);
            }
        }
        return switchParam;
    }

    public void invertLight (Boolean switchedOn) {
        if (switchedOn==true){
            switchedOn = false;
        }
        else {
            switchedOn = true;
        }
    }
}