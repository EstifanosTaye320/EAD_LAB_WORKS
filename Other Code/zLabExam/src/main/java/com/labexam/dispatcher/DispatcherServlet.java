package com.labexam.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labexam.entitiyone.DisplayAll;
import com.labexam.entitiyone.RestisterTaskServlet;

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

		if (requestPath.startsWith("/register")) {
			new RestisterTaskServlet().doPost(request, response);
		} else if (requestPath.startsWith("/taskList")) {
			new DisplayAll().doGet(request, response);
		}else if (requestPath.startsWith("/")) {
			request.getRequestDispatcher("/index.html");
		} else {
			response.getWriter().println("Invalid URL");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
}