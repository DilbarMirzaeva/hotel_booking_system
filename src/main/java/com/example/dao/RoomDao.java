package com.example.dao;

import com.example.entity.Hotel;
import com.example.entity.Room;

import java.util.List;

public interface RoomDao {
    void save(Room room);
    List<Room> findAll();
    void update(Room room);
    Room findById(int id);
    void delete(int id);
    void updateRoomNumById(int id,String name);
}
