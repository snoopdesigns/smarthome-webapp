package org.snoopdesigns.smarthome.web;

import org.snoopdesigns.smarthome.DBUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(
        name = "IncomingDataServlet",
        urlPatterns = {"/api"}
)
public class IncomingDataServlet extends HttpServlet {

    private static final String VOLTAGE_PARAM = "voltage";
    private static final String IMAGE_PARAM = "image";

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("** New incoming data request **");
        DBUtils dbUtils = (DBUtils)request.getSession().getServletContext().getAttribute(
                DBUtils.class.getName()
        );
        if("voltage".equals(request.getParameter("action"))) {
            dbUtils.addNewVoltageData(
                    request.getParameter("voltage1"),
                    request.getParameter("voltage2"));
        } else if("image".equals(request.getParameter("action"))) {
            //do nothing
            System.out.println("Image data received");
        }
    }
}
