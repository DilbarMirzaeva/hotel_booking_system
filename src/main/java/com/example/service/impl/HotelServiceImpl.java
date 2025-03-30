package com.example.service.impl;

import com.example.dao.HotelDao;
import com.example.dto.HotelDto;
import com.example.entity.Hotel;
import com.example.service.HotelService;

import java.util.List;
import java.util.stream.Collectors;

public class HotelServiceImpl implements HotelService {

    private final HotelDao hotelDao;

    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public void saveHotel(HotelDto hoteldto) {
        Hotel hotel=new Hotel();
        hotel.setName(hoteldto.getName());
        hotel.setLocation(hoteldto.getLocation());
        hotelDao.saveHotel(hotel);
    }

    @Override
    public List<HotelDto> findAll() {
        List<Hotel> hotels=hotelDao.findAll();
        return hotels.stream()
                .map(hotel->new HotelDto(
                        hotel.getId(),
                        hotel.getName(),
                        hotel.getLocation(),
                        hotel.getCreateDate()
                )).collect(Collectors.toList());
    }

    @Override
    public void update(HotelDto hoteldto) {
        Hotel hotel=new Hotel();
        hotel.setId(hoteldto.getId());
        hotel.setName(hoteldto.getName());
        hotel.setLocation(hoteldto.getLocation());
        hotelDao.update(hotel);
    }

    @Override
    public HotelDto findById(int id) {
        Hotel hotel=hotelDao.findById(id);
        return new HotelDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getLocation(),
                hotel.getCreateDate());
    }

    @Override
    public void delete(int id) {

        hotelDao.delete(id);
    }

    @Override
    public void updateNameById(int id, String name) {
        hotelDao.updateNameById(id,name);
    }
}
