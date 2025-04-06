package com.example.dao;

import com.example.entity.Booking;
import com.example.entity.Hotel;

import java.util.List;

public interface BookingDao {
    void save(Booking booking);
    List<Booking> findAll();
    void update(Booking booking);
    Booking findById(int id);
    void delete(int id);
    void updateNameById(int id,String name);
}
