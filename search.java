import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import javax.swing.*;
public class search extends HttpServlet
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
		ResultSet rs=st.executeQuery("select * from result where roll='"+s1+"'");
			
		if(rs.next())
		{
			out.println(""+rs.getString(1)+"");
			out.println(""+rs.getString(2)+"");
			
			out.println(""+rs.getString(3)+"");
			out.println(""+rs.getString(4)+"");
			out.println(""+rs.getString(5)+"");
			
	    //  response.sendRedirect("register.html");
		}
		else
		{
			out.println("NO data found ");
			
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

