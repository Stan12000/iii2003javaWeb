package tw.org.iii;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
//        super();
        System.out.println("Hello");

    }


    
    
    
	@Override
	public void service(ServletRequest request, ServletResponse arg1) throws ServletException, IOException {
		 System.out.println("survice");
//		super.service(arg0, arg1);
//		 String key1 = request.getParameter("key1");
//		 System.out.println("key1="+key1);
//		 String key2 = request.getParameter("key2");
//		 System.out.println("key2="+key2);
		 try{
		 HttpServletRequest  req =(HttpServletRequest)request;
		 System.out.println("yes");
		 String method = req.getMethod();
		 System.out.println(method);
		 
		 
		 Enumeration<String> ps= req.getParameterNames();
		 while(ps.hasMoreElements()){
			 String item =ps.nextElement();
			 String value = req.getParameter(item);
			 System.out.println(item+"="+value);}
		 
		 }catch(ClassCastException ce){
			 System.out.println("NO");
		 }

		 
	}





	@Override
	public void init() throws ServletException {
  System.out.println("init");
//		super.init();
	}





	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				  System.out.println("Get");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  System.out.println("Post");
//		doGet(request, response);
	}

}
