package com.itsc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String query = "insert into usersdata (username,email,address) values (?,?,?)";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String password = "Password1234!@#$";
    	
    	//get PrintWriter
        PrintWriter pw = res.getWriter();
        //set content type
        res.setContentType("text/html");
        //GET THE book info
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        //LOAD jdbc driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
        //generate the connection
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", password); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, address);
            int count = ps.executeUpdate();
            if (count == 1) {
                pw.println("<h2>Record Is Registered Sucessfully</h2>");
            } else {
                pw.println("<h2>Record not Registered Sucessfully");
            }
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h2>");
        }
        pw.println("<a href='home.html'>Home</a>");
        pw.println("<br>");
        pw.println("<a href='userList'>User List</a>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}