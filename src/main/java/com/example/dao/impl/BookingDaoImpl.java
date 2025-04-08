package com.example.dao.impl;

import com.example.config.DataBaseConfig;
import com.example.dao.BookingDao;
import com.example.entity.Booking;
import com.example.query.BookingSqlQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingDaoImpl implements BookingDao {
    @Override
    public void save(Booking booking) {
        try(Connection connection= DataBaseConfig.getConnection()){
            PreparedStatement ps=connection.prepareStatement(BookingSqlQuery.INSERT_BOOKING);
            ps.setInt(1,booking.getRoomId());
            ps.setString(2,booking.getCustomerName());
            ps.setString(3,booking.getCustomerEmail());
            ps.setDate(4, Date.valueOf(booking.getStartDate()));
            ps.setDate(5,Date.valueOf(booking.getEndDate()));
            ps.setString(6,booking.getStatus());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Booking> findAll() {
        return List.of();
    }

    @Override
    public void update(Booking booking) {

    }

    @Override
    public Booking findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void updateNameById(int id, String name) {

    }
}
