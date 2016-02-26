package org.snoopdesigns.smarthome.web;

import org.snoopdesigns.smarthome.DBUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context initialized called!");
        servletContextEvent.getServletContext().setAttribute(
                DBUtils.class.getName(),
                new DBUtils());
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context destroyed called!");
        DBUtils dbUtils = (DBUtils)servletContextEvent.getServletContext().getAttribute(
                DBUtils.class.getName()
        );
        dbUtils.destroy();
    }

}
