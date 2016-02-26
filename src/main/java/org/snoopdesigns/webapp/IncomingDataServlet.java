package org.snoopdesigns.webapp;

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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("POST called!");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GET called!");
        DBUtils dbUtils = (DBUtils)request.getSession().getServletContext().getAttribute(
                DBUtils.class.getName()
        );
        if(request.getParameter("data") != null) {
            dbUtils.addNewData(request.getParameter("data").toString());
        }
    }
}
