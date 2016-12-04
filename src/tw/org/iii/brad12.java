package tw.org.iii;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class brad12
 */
@MultipartConfig
@WebServlet("/brad12")
public class brad12 extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if (x == null) x = "0";
		if (y == null) y = "0";
		
//		1. model
		
		
		brad13 brad = new brad13();
		String res = brad.cal(x, y);
		System.out.println(x + "+" + y + "=" + res);
//		HashMap<String,String> res = brad.cal("", "");
		
//		2.
		request.setAttribute("x", x);
		request.setAttribute("y", y);
		request.setAttribute("res", res);
		request.getRequestDispatcher("brad14").forward(request, response);
	
	}

	

}
