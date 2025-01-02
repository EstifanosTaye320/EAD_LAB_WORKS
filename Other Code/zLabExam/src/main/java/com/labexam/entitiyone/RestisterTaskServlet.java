package com.labexam.entitiyone;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.labexam.jdbc.DBConnectionManager;

public class RestisterTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private static DBConnectionManager manager;
	private static final String query = "INSERT INTO " + manager.getTableName()
			+ " (description,status,due_date) VALUES(?,?,?)";

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		String description = req.getParameter("description");
		String status = req.getParameter("status");
		String date = req.getParameter("date");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate eventDate = LocalDate.parse(date, formatter);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}

		try (Connection con = manager.openConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setString(1, description);
			ps.setString(2, status);
			ps.setString(3, eventDate.toString());
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
		pw.println("<a href='index.html'>Home</a>");
		pw.println("<br>");
		pw.println("<a href='taskList'>Task List</a>");
	}
}
