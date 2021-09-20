package com.jantoleu.rooms_manager;

import com.jantoleu.rooms_manager.model.Room;
import com.jantoleu.rooms_manager.repository.RoomRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoomControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void createRoomTest() throws Exception {
        mvc.perform(post("/api/room").content("{\"name\": \"Room Name\", \"countryCode\": \"KZ\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Room Name")))
                .andExpect(jsonPath("$.countryCode", is("KZ")))
                .andExpect(jsonPath("$.id", is(1)))
        ;
        assertTrue(roomRepository.findById(1).isPresent());

}

    @Test
    public void setRoomStatusTest() throws Exception {
        Room room = new Room();
        room.setName("Room Name");
        room.setLightIsOn(false);
        room.setCountryCode("KZ");
        roomRepository.save(room);


        mvc.perform(post("/api/room/" + room.getId() + "/status/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        roomRepository.findById(room.getId()).ifPresent((r) -> {assertTrue(r.getLightIsOn());});

    }

    @Test
    public void getRoomTest() throws Exception {
        Room room = new Room();
        room.setName("Room Name");
        room.setLightIsOn(false);
        room.setCountryCode("AF");
        roomRepository.save(room);


        mvc.perform(get("/api/room/" + room.getId() )
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Room Name")))
                .andExpect(jsonPath("$.countryCode", is("AF")))
                .andExpect(jsonPath("$.id", is(1)))
        ;

    }
}
