

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "divideservlet", urlPatterns = { "/divideservlet" })
public class DivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DivisionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		
		PrintWriter pw = response.getWriter();
		if (num2 == 0) {
			pw.println("<h2>Result of Division</h2>");
			pw.println("<p>Error: Division by zero not allowed</p>");
		}
		
		double result = num1 / num2;
		pw.println("<html>");
		pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
		pw.println("<h2>Result of Division</h2>");
		pw.printf("<p> %.2f / %.2f = %.2f</p>", num1, num2, result);
		pw.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
