
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OperationServlet")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public OperationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opp = request.getParameter("Operation");
		
		RequestDispatcher dispatch = null;
		
		switch(opp) {
		case "add":
			dispatch = request.getRequestDispatcher("/addservlet");
			break;
		case "subtract":
			dispatch = request.getRequestDispatcher("/subtractservlet");
			break;
		case "divide":
			dispatch = request.getRequestDispatcher("/divideservlet");
			break;
		case "multiply":
			dispatch = request.getRequestDispatcher("/multiplyservlet");
			break;
		default:
			PrintWriter pw = response.getWriter();
			pw.println("<html>");
			pw.println("<link rel=\"stylesheet\" href=\"css/bootstrap.css\">");
			pw.println("<h2>400: Bad Request</h2>");
			pw.println("<p>Error: Operation required to calculate</p>");
			pw.println("</html>");
			return;
		}
		
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
