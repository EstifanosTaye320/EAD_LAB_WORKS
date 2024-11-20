

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CircleAreaCalculaorServlet
 */
@WebServlet(name = "CircleArea", urlPatterns = { "/CircleArea" })
public class CircleAreaCalculaorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CircleAreaCalculaorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		Double radi = Double.parseDouble(request.getParameter("rad"));
		String unit = request.getParameter("unit");
		Double area = Math.PI * Math.pow(radi, 2);
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Circle area calculator</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>Circle Area Calculator</h1>");
		pw.printf("<p>Radius: %.2f %s</p>", radi, unit);
		pw.printf("<p>Area: %.2f square %s</p>", area, unit);
		pw.println("</body>");
		pw.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
