package com.todo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.dao.JDBCConnection;

@WebServlet("/taskList")
public class DisplayAll extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final JDBCConnection manager = new JDBCConnection();
	private static final String query = "SELECT ID,description,status,due_date FROM " + manager.getTableName();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }

        try (Connection con = manager.openConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            pw.println("<table border='1' align='center'>");
            pw.println("<tr>");
            pw.println("<th>Task Id</th>");
            pw.println("<th>Task Discription</th>");
            pw.println("<th>Task Status</th>");
            pw.println("<th>Task DueDate</th>");
            pw.println("<th>Delete</th>");
            pw.println("</tr>");
            while (rs.next()) {
                pw.println("<tr>");
                pw.println("<td>" + rs.getInt(1) + "</td>");
                pw.println("<td>" + rs.getString(2) + "</td>");
                pw.println("<td>" + rs.getString(3) + "</td>");
                pw.println("<td>" + rs.getDate(4) + "</td>");
             // pw.println("<td><a href='editScreen?id=" + rs.getInt(1) + "'>Edit</a></td>");
                pw.println("<td><a href='deleteurl?id=" + rs.getInt(1) + "'>Delete</a></td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
        } catch (SQLException se) {
            se.printStackTrace();
            pw.println("<h1>" + se.getMessage() + "</h2>");
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("<h1>" + e.getMessage() + "</h2>");
        }
        pw.println("<a href='index.html'>Home</a>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
