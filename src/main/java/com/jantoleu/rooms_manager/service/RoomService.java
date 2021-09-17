package com.jantoleu.rooms_manager.service;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomService {
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        room.setLightIsOn(false);
        return roomRepository.save(room);
    }
}
