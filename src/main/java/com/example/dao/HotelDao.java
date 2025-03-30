package com.example.dao;

import com.example.entity.Hotel;

import java.util.List;

public interface HotelDao {
    void saveHotel(Hotel hotel);
    List<Hotel> findAll();
    void update(Hotel hotel);
    Hotel findById(int id);
    void delete(int id);
    void updateNameById(int id,String name);
}
