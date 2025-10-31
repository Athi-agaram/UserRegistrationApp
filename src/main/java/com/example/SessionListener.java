package com.example;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("✅ New session created: " + event.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("❌ Session destroyed: " + event.getSession().getId());
    }
}
