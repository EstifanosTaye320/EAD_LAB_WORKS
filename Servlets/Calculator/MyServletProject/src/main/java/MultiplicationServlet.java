

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "multiplyservlet", urlPatterns = { "/multiplyservlet" })
public class MultiplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MultiplicationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		int result = num1 * num2;
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
		pw.println("<h2>Result of Multiplication</h2>");
		pw.println("<p>" + num1 + " * " + num2 + " = " + result + "</p>");
		pw.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
