package com.example.service.impl;

import com.example.dao.RoomDao;
import com.example.dto.RoomDto;
import com.example.entity.Room;
import com.example.service.RoomService;

import java.util.List;
import java.util.stream.Collectors;

public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao ;

    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }


    @Override
    public void save(RoomDto roomDto) {
        Room room=new Room();
        room.setHotelId(roomDto.getHotelId());
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setPrice(roomDto.getPrice());
        room.setStatus(roomDto.getStatus());
        roomDao.save(room);
    }

    @Override
    public List<RoomDto> findAll() {
        List<Room> rooms=roomDao.findAll();
        return rooms.stream()
                .map(room -> new RoomDto(
                        room.getId(),
                        room.getHotelId(),
                        room.getRoomNumber(),
                        room.getPrice(),
                        room.getStatus(),
                        room.getCreateDate()
                )).collect(Collectors.toList());
    }

    @Override
    public void update(RoomDto roomDto) {
        Room room=new Room();
        room.setHotelId(roomDto.getHotelId());
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setPrice(roomDto.getPrice());
        room.setStatus(roomDto.getStatus());
        room.setId(roomDto.getId());
        roomDao.update(room);
    }

    @Override
    public RoomDto findById(int id) {
        Room room=roomDao.findById(id);
        return new RoomDto(room.getId()
                ,room.getHotelId()
                ,room.getRoomNumber()
                ,room.getPrice()
                ,room.getStatus()
                ,room.getCreateDate());
    }

    @Override
    public void delete(int id) {
        roomDao.delete(id);
    }

    @Override
    public void updateRoomNumById(int id, String name) {
        roomDao.updateRoomNumById(id, name);
    }
}
