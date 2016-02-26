package org.snoopdesigns.smarthome.web;

import org.snoopdesigns.smarthome.data.DBUtils;

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

    private static final String TIMESTAMP_PARAM = "time";
    private static final String VOLTAGE1_PARAM = "v1";
    private static final String VOLTAGE2_PARAM = "v2";
    private static final String TEMPERATURE_PARAM = "t";
    private static final String HUMIDITY_PARAM = "h";

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
            dbUtils.addNewData(
                    request.getParameter(TIMESTAMP_PARAM),
                    request.getParameter(VOLTAGE1_PARAM),
                    request.getParameter(VOLTAGE2_PARAM),
                    request.getParameter(TEMPERATURE_PARAM),
                    request.getParameter(HUMIDITY_PARAM));
        } else if("image".equals(request.getParameter("action"))) {
            //do nothing
            System.out.println("Image data received");
        }
    }
}
