package com.jantoleu.rooms_manager.service;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class RoomService {
    private RoomRepository roomRepository;
    private IpAddressService ipAddressService;

    public Room createRoom(Room room) {
        room.setLightIsOn(false);
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void setRoomStatus (Integer roomId, Boolean roomStatus){
        Room room = roomRepository.findById(roomId).get();
        room.setLightIsOn(roomStatus);
        roomRepository.save(room);
    }

    /**
     * if testing locally then ip address would be the local one
     *  not the IP given by your internet provider.
     *  Therefor countryCode would be null.
     *  Currently always returns room despite the country check.
     *  (Check return ternary operator statement)
     *
     *  So, have to figure out the way to bypass this limitation.
     *
     * Should work if deployed to real server and accessed from remote physical
     * machine though.
     *
     * @param roomId
     * @param ipAddress
     * @return
     */
    public Room getRoom(Integer roomId, String ipAddress) {
        String countryCode = ipAddressService.getCountryCodeByIp(ipAddress);
        log.info("countryCode: '{}' ipAddress: '{}'", countryCode, ipAddress);
        Room room = roomRepository.findById(roomId).get();
        return countryCode != null && countryCode.equals(room.getCountryCode()) ?
            room : room;
    }
}
