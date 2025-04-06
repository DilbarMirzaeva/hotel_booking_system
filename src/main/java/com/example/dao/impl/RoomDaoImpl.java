package com.example.dao.impl;

import com.example.config.DataBaseConfig;
import com.example.dao.RoomDao;
import com.example.entity.Room;
import com.example.logs.LoggerHelper;
import com.example.query.RoomSqlQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    @Override
    public void save(Room room) {
        try(Connection connection= DataBaseConfig.getConnection()){
            PreparedStatement ps= connection.prepareStatement(RoomSqlQuery.ROOM_INSERT);
            ps.setInt(1,room.getHotelId());
            ps.setString(2,room.getRoomNumber());
            ps.setDouble(3,room.getPrice());
            ps.setString(4,room.getStatus());
            ps.executeUpdate();
            LoggerHelper.info("Room created successfully");
        } catch (Exception e) {
            LoggerHelper.error("Error saving room: "+e.getMessage());
        }
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms=new ArrayList<>();
        try(Connection connection= DataBaseConfig.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(RoomSqlQuery.ROOM_SELECT_ALL);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Room room=new Room();
                roomData(rs, room);
                rooms.add(room);
            }
            LoggerHelper.info("All rooms fetched successfully");

        } catch (Exception e) {
            LoggerHelper.error("Error while finding all the rooms: "+e.getMessage());
        }
        return rooms;
    }

    private void roomData(ResultSet rs, Room room) throws SQLException {
        room.setId(rs.getInt("id"));
        room.setHotelId(rs.getInt("hotel_id"));
        room.setRoomNumber(rs.getString("room_number"));
        room.setPrice(rs.getDouble("price"));
        room.setStatus(rs.getString("status"));
        java.sql.Timestamp sql=rs.getTimestamp("created_at");
        if(sql!=null){
            room.setCreateDate(sql.toLocalDateTime());
        }else {
            room.setCreateDate(null);
        }
    }

    @Override
    public void update(Room room) {
        try(Connection connection= DataBaseConfig.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(RoomSqlQuery.ROOM_UPDATE);
            ps.setInt(1,room.getHotelId());
            ps.setString(2,room.getRoomNumber());
            ps.setDouble(3,room.getPrice());
            ps.setString(4,room.getStatus());
            ps.setInt(5,room.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            LoggerHelper.error("Error updating student: "+ e.getMessage());
        }
    }

    @Override
    public Room findById(int id) {
        Room room=new Room();
        try(Connection connection=DataBaseConfig.getConnection()) {
            PreparedStatement ps=connection.prepareStatement(RoomSqlQuery.ROOM_FIND_BY_ID);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                roomData(rs, room);
            }
            LoggerHelper.info("Room by id fetched successfully");
        } catch (SQLException e) {
            LoggerHelper.error("Error while finding room: "+e.getMessage());
        }
        return room;
    }

    @Override
    public void delete(int id) {
        try(Connection con=DataBaseConfig.getConnection()){
            PreparedStatement ps=con.prepareStatement(RoomSqlQuery.ROOM_DELETE);
            ps.setInt(1,id);
            ps.executeUpdate();
            LoggerHelper.info("Room deleted successfully");
        } catch (SQLException e) {
            LoggerHelper.error("error while deleted:"+e.getMessage());
        }
    }

    @Override
    public void updateRoomNumById(int id, String name) {
        try(Connection connection=DataBaseConfig.getConnection()){
            PreparedStatement ps= connection.prepareStatement(RoomSqlQuery.ROOM_UPDATE_BY_ID);
            ps.setString(1,name);
            ps.setInt(2,id);
            ps.executeUpdate();
            LoggerHelper.info("Room number updated successfully");
        } catch (SQLException e) {
            LoggerHelper.error("Error while updating room number: "+e.getMessage());
        }
    }
}
