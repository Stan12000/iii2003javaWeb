package tw.org.iii;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Brad03
 */
@WebServlet("/Brad03")
public class Brad03 extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int x,y,result,op;
		String  xxxx=null;
		try{
			x =Integer.parseInt(request.getParameter("x"));
			op =Integer.parseInt(request.getParameter("op"));
			y =Integer.parseInt(request.getParameter("y"));
			
			
			
			
		}catch(Exception ce){
			x=0;
			y=0;
			op=1;
		}
		
		switch(op){ 
		default:
		case 1:result = x+y; xxxx=" "; break;
		case 2:result = x-y; xxxx=" "; break;
		case 3:result = x*y; xxxx=" "; break;
		case 4:result = x/y; 		
               xxxx = "......"+(x%y);  
		break;
		
	
		 }
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<form>");
		out.println("<input type='text' name='x' value='"+x+"' /> ");
		out.println("<select name='op'>");
		out.println("<option value='1'>+</option>");
		out.println("<option value='2'>-</option>");
		out.println("<option value='3'>X</option>");
		out.println("<option value='4'>/</option>");
		out.println("</select>");
		out.println("<input type='text' name='y' value='"+y+"'/>");
		out.println("<input type='submit' value='=' />");
		out.println("<span>"+result+xxxx+"<span>");
		out.println("</form>");
		out.flush();
		out.close();
	}


}
