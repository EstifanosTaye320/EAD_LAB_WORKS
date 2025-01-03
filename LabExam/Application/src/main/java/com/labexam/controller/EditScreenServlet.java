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
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;

@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    @Autowired
	private DBConnectionManager manager;
    private String tableName = "tasks";
	private final String query = "SELECT description,status,due_date FROM " + tableName + " where id=?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try (Connection con = manager.openConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			pw.println("<form action='editurl?id=" + id + "' method='post'>");
			pw.println("<table align='center'>");
			pw.println("<tr>");
			pw.println("<td>Discription</td>");
			pw.println("<td><input type='text' name='description' value='" + rs.getString(1) + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Status</td>");
			pw.println("<td>"
					+ "		<select id=\"status\" name=\"status\" required>\r\n"
					+ "			<option value=\"Pending\" "+(rs.getString(2).equals("Pending")?"selected":"")+">Pending</option>\r\n"
					+ "			<option value=\"Completed\" "+(rs.getString(2).equals("Completed")?"selected":"")+">Completed</option>\r\n"
					+ "		</select>"
					+ "</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td>Due Date</td>");
			pw.println("<td><input type='date' name='date' value='" + rs.getString(3) + "'></td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td><input type='submit' value='Edit'></td>");
			pw.println("<td><input type='reset' value='cancel'></td>");
			pw.println("</tr>");
			pw.println("</table>");
			pw.println("</form>");
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
