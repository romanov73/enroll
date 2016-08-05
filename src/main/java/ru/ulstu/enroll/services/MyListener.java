package ru.ulstu.enroll.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

    public MyListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        JPAController.releaseResources();       
    }   
    
}
