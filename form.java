

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;


/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String URL="JDBC:mysql://localhost:3306/mydb",Username="root",Password="mysql";
    /**
     * Default constructor. 
     */
    public form() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();	
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String email= request.getParameter("email");
		String pincode= request.getParameter("pincode");
		String input = request.getParameter("action");
		out.close();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection(URL,Username,Password);
			out.println("Connection Sucessful");
			Statement st = (Statement) conn.createStatement();
			if(input.equals("Insert"))
			{
			int i = ((java.sql.Statement) st).executeUpdate("insert into student values('"+username+"','"+password+"','"+email+"','"+pincode+"')");
			if(i>0)
			{
				out.println("inserted Sucessfully");
				
			}
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught: "+e);
		}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
