package com.example.query;

public class HotelSqlQuery {
    public static final String INSERT_HOTEL="INSERT INTO hotels(name,location) VALUES(?,?)";
    public static final String  SELECT_ALL_HOTELS="SELECT * FROM hotels";
    public static final String UPDATE_HOTELS="UPDATE hotels SET name=?,location=? WHERE id=?";
    public static final String DELETE_HOTEL="DELETE FROM hotels WHERE id=?";
    public static final String FIND_HOTEL="SELECT * FROM hotels WHERE id=?";
    public static final String UPDATE_HOTEL_BY_ID="UPDATE hotels SET name=? WHERE id=?";
}
