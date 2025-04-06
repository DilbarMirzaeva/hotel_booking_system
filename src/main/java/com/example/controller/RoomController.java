package com.example.controller;

import com.example.dto.RoomDto;
import com.example.service.RoomService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class RoomController extends HttpServlet {

    private final RoomService roomService;
    private final ObjectMapper objectMapper=new ObjectMapper();

    {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getParameter("id") != null) {
            int id= Integer.parseInt(req.getParameter("id"));
            RoomDto room=roomService.findById(id);
            String json=objectMapper.writeValueAsString(room);
            resp.setContentType("application/json");
            resp.getWriter().write(json);
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        List<RoomDto> roomDtos=roomService.findAll();
        String json=objectMapper.writeValueAsString(roomDtos);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bufferedReader=req.getReader();
        RoomDto roomDto=objectMapper.readValue(bufferedReader, RoomDto.class);
        roomService.save(roomDto);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.setContentType("application/json");
        resp.getWriter().write("{\"message\":\"Room saved successfully\"}");
    }

    public void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bufferedReader=req.getReader();
        RoomDto roomDto=objectMapper.readValue(bufferedReader, RoomDto.class);
        roomService.update(roomDto);
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("{\"message\": \"Room updated successfully\"}");
    }

    public void doDelete(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        int id=Integer.parseInt(req.getParameter("id"));
        roomService.delete(id);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("{\"message\": \"Room deleted successfully\"}");
    }
}
