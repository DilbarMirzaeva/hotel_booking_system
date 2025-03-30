package com.example.service;

import com.example.dto.HotelDto;
import com.example.entity.Hotel;

import java.util.List;

public interface HotelService {
    void saveHotel(HotelDto hoteldto);
    List<HotelDto> findAll();
    void update(HotelDto hoteldto);
    HotelDto findById(int id);
    void delete(int id);
    void updateNameById(int id,String name);
}
