package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/brad10")
public class brad10 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 針對中文檔名處理, 必須在任何  request之前做的設定
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("brad11?name=brad&price=123");
		// include , forward
		
		out.println("<h1>Brad Big Company</h1>");
		out.print("<hr>");
		dispatcher.include(request, response);
		out.println("<hr>");
		out.println("Copyleft");
		
		
	}
}
