package com.jantoleu.rooms_manager.repository;

import com.jantoleu.rooms_manager.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
    List<Room> findAll();
}
