package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class brad07
 */
@MultipartConfig
@WebServlet("/brad07")
public class brad07 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		Part part = request.getPart("upLoad");
		 String header =part.getHeader("Content-Disposition");
		 out.println(header+"<br>");
		
//		 String filename = part.getSubmittedFileName();
//			String type = part.getContentType();
//			String name = part.getName();
//			long len = part.getSize();
//			out.println(type + ":" + name + ":" + filename + ":" + len);
//			
			
			
			String filename = part.getSubmittedFileName().replaceAll("\\\\", "/");
			//String filename2 = filename.replaceAll("\", "/");
			String type = part.getContentType();
			String name = part.getName();
			long len = part.getSize();
			String myfilename = getFilename(header);
			out.println(type + ":" + myfilename + ":" + len);
			
			
			
			byte[] buf = new byte[(int)len];
			BufferedInputStream bin = new BufferedInputStream(part.getInputStream());
			bin.read(buf);
			bin.close();
			
			ServletContext context = getServletContext();
			String uploadPath = context.getInitParameter("upload-path");
			out.println(uploadPath);
			
			FileOutputStream fout = new FileOutputStream(new File(uploadPath, myfilename));
			fout.write(buf);
			fout.flush();
			fout.close();
	}
	private String getFilename(String body){
		int start = body.indexOf("filename=\"");
		String temp = body.substring(start+10);
		String filename = temp.substring(0, temp.indexOf("\""));
		int s = filename.lastIndexOf("\\");
		filename = filename.substring(s+1);
		
		return filename;
	}
	
}
