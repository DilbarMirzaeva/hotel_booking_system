package com.example.service;

import com.example.dto.RoomDto;
import com.example.entity.Room;

import java.util.List;

public interface RoomService {
    void save(RoomDto roomDto);
    List<RoomDto> findAll();
    void update(RoomDto roomDto);
    RoomDto findById(int id);
    void delete(int id);
    void updateRoomNumById(int id,String name);
}
