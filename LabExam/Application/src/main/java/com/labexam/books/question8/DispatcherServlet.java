package com.labexam.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        String contextPath = request.getContextPath();
        String requestPath = path.substring(contextPath.length());
        
        HttpSession session = request.getSession(false);


         if (requestPath.startsWith("/login") || requestPath.startsWith("/registerUser") ) {
            if(requestPath.startsWith("/login"))
              request.getRequestDispatcher("/login").forward(request, response);
            else if (requestPath.startsWith("/registerUser"))
                request.getRequestDispatcher("/registerUser").forward(request,response);
        } else if (session != null && session.getAttribute("username") != null) {
                if (requestPath.startsWith("/register")) {
                    request.getRequestDispatcher("/register").forward(request, response);
                } else if (requestPath.startsWith("/taskList")) {
                    request.getRequestDispatcher("/taskList").forward(request, response);
                } else if (requestPath.startsWith("/") || requestPath.startsWith("/index.html")) {
                    request.getRequestDispatcher("/index.html").forward(request, response);
                }  else if (requestPath.startsWith("/search.html")) {
                    request.getRequestDispatcher("/search.html").forward(request, response);
                } else if (requestPath.startsWith("/logout")){
                  request.getRequestDispatcher("/logout").forward(request,response);
                }
                else if (requestPath.startsWith("/addTask.html")) {
                  request.getRequestDispatcher("/addTask.html").forward(request, response);
                } else if(requestPath.startsWith("/editScreen")){
                   request.getRequestDispatcher("/editScreen").forward(request, response);
                } else if(requestPath.startsWith("/editurl")){
                  request.getRequestDispatcher("/editurl").forward(request,response);
                }
                 else {
                    response.getWriter().println("Invalid URL");
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }
            } else {
              response.sendRedirect("login.html");
            }
    }
}