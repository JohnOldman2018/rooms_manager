package com.jantoleu.rooms_manager.service;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        room.setLightIsOn(false);
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    public void setRoomStatus (Integer roomId, Boolean roomStatus){
        Room room = roomRepository.findById(roomId).get();
        room.setLightIsOn(roomStatus);
        roomRepository.save(room);
    }

    public String validateUserCountryCode(String userCountryCode, String roomCountryCode) {
        String warning = "You are not eligible to light the room!";
        if (userCountryCode.equals(roomCountryCode)) {return "You are welcome!";}
        return warning;
    }


}
