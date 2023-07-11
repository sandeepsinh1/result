import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import javax.swing.*;
public class login extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
			String s1=request.getParameter("up");
			String s2=request.getParameter("un");
		PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false","root","root");
			Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from login where name='"+s1+"' and pass='"+s2+"'");
			
		if(rs.next())
		{
		//out.println("you log......in");
		response.sendRedirect("register.html");
		}
		else
		{
			
			//out.println("invalid user name or pass");
			response.sendRedirect("menu.html");
		}
		 con.close();
		 }
         catch(Exception e)
		 {
			out.println(e);
		}		
		//out.println("<h1>" "</h1>");
		
	} 
}

