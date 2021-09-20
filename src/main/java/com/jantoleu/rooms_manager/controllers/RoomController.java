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
    public List<Room> getRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return rooms;
    }

    @GetMapping("/api/room/{roomId}")
    public void getRoom(@PathVariable(value="roomId") Integer roomId) {
        roomService.getRoom(roomId);
    }

    @PostMapping("/api/room/{roomId}/status/{roomStatus}")
    public void setRoomStatus (@PathVariable(value="roomId") Integer roomId, @PathVariable(value="roomStatus") Boolean roomStatus) {
        roomService.setRoomStatus(roomId, roomStatus);
    }


}
