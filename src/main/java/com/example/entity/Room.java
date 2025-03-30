package com.example.entity;

import java.time.LocalDateTime;

public class Room {
    private Integer id;
    private Integer hotelId;
    private String roomNumber;
    private Double price;
    private String status;
    private LocalDateTime createDate;

    public Room(Integer id, Integer hotelId, String roomNumber, Double price, String status, LocalDateTime createDate) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomNumber = roomNumber;
        this.price = price;
        this.status = status;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
