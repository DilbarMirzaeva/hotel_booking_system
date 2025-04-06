package com.example.query;

public class RoomSqlQuery {
    public static final String ROOM_INSERT="INSERT INTO rooms(hotel_id,room_number,price,status) VALUES(?,?,?,?)";
    public static final String ROOM_SELECT_ALL="SELECT * FROM rooms";
    public static final String ROOM_UPDATE="UPDATE rooms SET hotel_id=?,room_number=?,price=?,status=? WHERE id=?";
    public static final String ROOM_DELETE="DELETE FROM rooms WHERE id=?";
    public static final String ROOM_FIND_BY_ID="SELECT * FROM rooms WHERE id=?";
    public static final String ROOM_UPDATE_BY_ID="UPDATE rooms SET room_number=? WHERE id=?";

}
