package com.example.controller;

import com.example.dto.HotelDto;
import com.example.service.HotelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class HotelController extends HttpServlet {
    private final HotelService hotelService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.registerModule(new JavaTimeModule());
    }


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getParameter("id")!=null){
            int id=Integer.parseInt(req.getParameter("id"));
            HotelDto hotelDto=hotelService.findById(id);
            String jsonResponse= objectMapper.writeValueAsString(hotelDto);
            resp.setContentType("application/json");
            resp.getWriter().write(jsonResponse);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            return;
        }
        List<HotelDto> hotelDto=hotelService.findAll();
        String jsonResponse=objectMapper.writeValueAsString(hotelDto);
        resp.setContentType("application/json");
        resp.getWriter().write(jsonResponse);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br=req.getReader();
        HotelDto hotel=objectMapper.readValue(br,HotelDto.class);
        hotelService.saveHotel(hotel);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write("{\"message\":\"Student saved successfully\"}");
    }

    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getParameter("id")!=null ){
            BufferedReader reader=req.getReader();
            HotelDto hotelDto=objectMapper.readValue(reader,HotelDto.class);
            hotelService.update(hotelDto);
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("{\"message\": \"Student updated successfully\"}");
        }
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        hotelService.delete(id);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("{\"message\": \"Student deleted successfully\"}");
    }
}
