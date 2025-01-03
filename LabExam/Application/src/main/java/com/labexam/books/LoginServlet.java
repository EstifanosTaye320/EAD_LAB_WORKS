package com.labexam.controller;

import com.labexam.model.User;
import com.labexam.repository.UserRepository;
import com.labexam.util.PasswordUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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

    if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
        out.println("Please enter username and password");
        req.getRequestDispatcher("login.html").include(req, resp);
        return;
    }
    try {
      User user = userRepository.findByUsername(username);
      if (user != null
          && passwordUtil.verifyPassword(password, user.getPassword())) {
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        resp.sendRedirect("index.html");
      } else {
          out.println("Invalid Credentials!");
          req.getRequestDispatcher("login.html").include(req, resp);
      }

    } catch (SQLException e) {
      out.println("An error occurred: " + e.getMessage());
    }
  }
}