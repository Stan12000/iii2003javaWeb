package tw.org.iii;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class brad15
 */
@WebServlet("/brad15")
public class brad15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		testSQL();
	}
	
	private void testSQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = 
					DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1/iii?user=root&password=root");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(
					"INSERT INTO member (account,passwd,realname) VALUES ('brad','123','Brad')");
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println("error");
		}
	}
}
