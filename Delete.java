import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import javax.swing.*;
public class Delete extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
			String s1=request.getParameter("un");
				PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false","root","root");
			Statement st=con.createStatement();
		    st.executeUpdate("delete from result where roll='"+s1+"'");
			out.println("data deleted.....");
		 con.close();
		 }
         catch(Exception e)
		 {
			out.println(e);
		}		
		
	} 
}

