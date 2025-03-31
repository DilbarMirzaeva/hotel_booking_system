package com.example.dao.impl;

import com.example.config.DataBaseConfig;
import com.example.dao.HotelDao;
import com.example.entity.Hotel;
import com.example.logs.LoggerHelper;
import com.example.query.HotelSqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDaoImpl implements HotelDao {

    @Override
    public void saveHotel(Hotel hotel) {
        try(Connection connection= DataBaseConfig.getConnection()){
            PreparedStatement ps=connection.prepareStatement(HotelSqlQuery.INSERT_HOTEL);
            ps.setString(1,hotel.getName());
            ps.setString(2,hotel.getLocation());
            ps.executeUpdate();
            LoggerHelper.info("Hotel created successfully");
        } catch (Exception e) {
            LoggerHelper.error("Error saving hotel: "+e.getMessage());
        }
    }

    @Override
    public List<Hotel> findAll() {
        List<Hotel> hotels=new ArrayList<>();
        try(Connection con=DataBaseConfig.getConnection()) {
            PreparedStatement ps=con.prepareStatement(HotelSqlQuery.SELECT_ALL_HOTELS);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Hotel hotel=new Hotel();
                findMethod(rs, hotel);
                hotels.add(hotel);
            }
            LoggerHelper.info("All hotels fetched successfully");
        } catch (Exception e) {
            LoggerHelper.error("Error while finding all the hotels: "+e.getMessage());
        }
        return hotels;
    }

    @Override
    public void update(Hotel hotel) {
        try(Connection con=DataBaseConfig.getConnection()){
            PreparedStatement ps=con.prepareStatement(HotelSqlQuery.UPDATE_HOTELS);
            ps.setString(1,hotel.getName());
            ps.setString(2, hotel.getLocation());
            ps.setInt(3,hotel.getId());
            ps.executeUpdate();
            LoggerHelper.info("Hotel updated successfully");
        } catch (Exception e) {
            LoggerHelper.error("Error updating student: "+ e.getMessage());
        }
    }

    @Override
    public Hotel findById(int id) {
        Hotel hotel=new Hotel();
        try(Connection con=DataBaseConfig.getConnection()) {
            PreparedStatement ps=con.prepareStatement(HotelSqlQuery.FIND_HOTEL);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                findMethod(rs, hotel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return hotel;
    }

    @Override
    public void delete(int id) {
        try(Connection con=DataBaseConfig.getConnection()){
            PreparedStatement ps=con.prepareStatement(HotelSqlQuery.DELETE_HOTEL);
            ps.setInt(1,id);
            ps.executeUpdate();
            LoggerHelper.info("Hotel deleted successfully");
        } catch (SQLException e) {
            LoggerHelper.error("error:"+e.getMessage());
        }
    }

    @Override
    public void updateNameById(int id, String name) {
        try(Connection con=DataBaseConfig.getConnection()){
            PreparedStatement ps=con.prepareStatement(HotelSqlQuery.UPDATE_HOTEL_BY_ID);
            ps.setString(1,name);
            ps.setInt(2,id);
            ps.executeUpdate();
            LoggerHelper.info("Name updated successfully");
        } catch (Exception e) {
            LoggerHelper.error("Error patching student: " + e.getMessage());
        }
    }

    private void findMethod(ResultSet rs, Hotel hotel) throws SQLException {
        hotel.setId(rs.getInt("id"));
        hotel.setName(rs.getString("name"));
        hotel.setLocation(rs.getString("location"));
        java.sql.Timestamp sql=rs.getTimestamp("created_at");
        if(sql!=null){
            hotel.setCreateDate(sql.toLocalDateTime());
        }else {
            hotel.setCreateDate(null);
        }
    }
}
