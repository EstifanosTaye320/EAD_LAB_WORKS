package com.labexam.controller;

import com.labexam.model.User;
import com.labexam.repository.UserRepository;
import com.labexam.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/registerUser")
public class RegistrationServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Autowired private UserRepository userRepository;

  @Autowired private PasswordUtil passwordUtil;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if(username == null || username.isEmpty() || password == null || password.isEmpty()){
        out.println("Please enter username and password");
        req.getRequestDispatcher("register.html").include(req,resp);
        return;
    }

    try {
      if (userRepository.findByUsername(username) != null) {
        out.println("Username already exists!");
        req.getRequestDispatcher("register.html").include(req, resp);
      } else {
        String hashedPassword = passwordUtil.hashPassword(password);
        User newUser = new User(username, hashedPassword);
        userRepository.save(newUser);
        out.println("Registration successful, please log in!");
        req.getRequestDispatcher("login.html").include(req,resp);
      }

    } catch (SQLException e) {
      out.println("An error occurred: " + e.getMessage());
    }
  }
}