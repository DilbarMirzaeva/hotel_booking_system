package com.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Hotel {
    private Integer id;
    private String name;
    private String location;
    private LocalDateTime createDate;

    public Hotel(Integer id, String name, String location, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.createDate = createDate;
    }

    public Hotel(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) && Objects.equals(name, hotel.name) && Objects.equals(location, hotel.location) && Objects.equals(createDate, hotel.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, createDate);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
