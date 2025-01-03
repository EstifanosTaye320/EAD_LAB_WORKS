package com.labexam.controller;

import com.labexam.util.DBConnectionManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/editurl")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private DBConnectionManager manager;
	private static final String query = "update tasks set description=?,status=?,due_date=? where id=?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));

		String description = req.getParameter("description");
		String status = req.getParameter("status");
		String date = req.getParameter("date");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try (Connection con = manager.openConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setString(1, description);
			ps.setString(2, status);
			ps.setString(3, date);
			ps.setInt(4, id);
			int count = ps.executeUpdate();
			if (count == 1) {
				pw.println("<h2>Record is Edited Successfully</h2>");
			} else {
				pw.println("<h2>Record is not Edited Successfully</h2>");
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}