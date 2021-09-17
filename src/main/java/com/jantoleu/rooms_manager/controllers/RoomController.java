package com.jantoleu.rooms_manager.controllers;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoomController {

    private RoomService roomService;

    @PostMapping("/api/room")
    @ResponseBody
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @GetMapping("/api/room")
    public List<String> getAllRooms() {
        return null;
    }

}
