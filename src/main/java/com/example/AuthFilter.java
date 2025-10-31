package com.example;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/users.jsp")
public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // optional initialization
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String name = request.getParameter("name");
        String auth = request.getParameter("auth");

        if ((auth != null && auth.equals("true")) || (name != null && !name.isEmpty())) {
            chain.doFilter(request, response);
        } else {
            response.getWriter().println("Access Denied: Missing authorization.");
        }
    }

    public void destroy() {
    }
}
