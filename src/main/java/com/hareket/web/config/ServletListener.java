package com.hareket.web.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Configuration
public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextEvent initialized.");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("P0655", "sokrat");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.removeAttribute("P0655");
        System.out.println("ServletContextEvent destroyed.");
    }
}