package com.jantoleu.rooms_manager.controllers;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    private String LOCALHOST_IPV4 = "127.0.0.1";
    private String LOCALHOST_IPV6 = "0:0:0:0:0:0:0:1";

    private String getClientIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }

        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }

        if(StringUtils.isEmpty(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(LOCALHOST_IPV4.equals(ipAddress) || LOCALHOST_IPV6.equals(ipAddress)) {
                try {
                    InetAddress inetAddress = InetAddress.getLocalHost();
                    ipAddress = inetAddress.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }

        if(!StringUtils.isEmpty(ipAddress)
                && ipAddress.length() > 15
                && ipAddress.indexOf(",") > 0) {
            ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
        }

        return ipAddress;
    }

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
    public Room getRoom(@PathVariable(value="roomId") Integer roomId, HttpServletRequest request) {
        Room room = roomService.getRoom(roomId, getClientIp(request));
        if (room == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return room;
    }

    @PostMapping("/api/room/{roomId}/status/{roomStatus}")
    public void setRoomStatus (@PathVariable(value="roomId") Integer roomId, @PathVariable(value="roomStatus") Boolean roomStatus) {
        roomService.setRoomStatus(roomId, roomStatus);
    }


}
