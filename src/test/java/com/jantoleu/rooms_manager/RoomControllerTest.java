package com.jantoleu.rooms_manager;

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
}