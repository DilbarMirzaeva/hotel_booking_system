package com.example.dto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class HotelDto {
    private Integer id;
    private String name;
    private String location;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    public HotelDto(){}

    public HotelDto(Integer id, String name, String location, LocalDateTime createDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.createDate = createDate;
    }

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
        HotelDto hotelDto = (HotelDto) o;
        return Objects.equals(id, hotelDto.id) && Objects.equals(name, hotelDto.name) && Objects.equals(location, hotelDto.location) && Objects.equals(createDate, hotelDto.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, createDate);
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
