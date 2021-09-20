package com.jantoleu.rooms_manager.service;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Room getRoom(Integer roomId) {
        Room room = roomRepository.findById(roomId).get();
        return room;
    }

}
