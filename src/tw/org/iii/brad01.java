package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class brad01
 */
@WebServlet("/brad01")
public class brad01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public brad01() {
//       
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
		doJob(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doJob(request,response);
		
//		doGet(request, response);
	}

	protected void doJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doJob");
		Enumeration<String> headers =  request.getHeaderNames();
		while ( headers.hasMoreElements()){
			String header = headers.nextElement();
			System.out.println(header + " : " + request.getHeader(header));
		}
		
		try{
			PrintWriter out = response.getWriter();
			out.write("Hello, Brad01");
			out.flush();
			out.close();
		}catch(Exception ee){
			
		}
		
		
	}
	
}
