package com.example.console;

import com.example.controller.HotelController;
import com.example.dao.HotelDao;
import com.example.dao.impl.HotelDaoImpl;
import com.example.service.HotelService;
import com.example.service.impl.HotelServiceImpl;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class HotelBookingConsole {
    static final HotelDao hotelDao=new HotelDaoImpl();
    static final HotelService hotelService=new HotelServiceImpl(hotelDao);
    static final HotelController hotelController=new HotelController(hotelService);

    public static void run() throws Exception {
        Server server=new Server(8081);
        ServletContextHandler context=new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        context.addServlet(new ServletHolder(hotelController),"/hotels/*");
        server.setHandler(context);
        server.start();
        System.out.println("Server started at http://localhost:8081");
        server.join();
    }
}
