import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import javax.swing.*;
public class register extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
			String s1=request.getParameter("un");
			String s2=request.getParameter("up");
			PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false","root","root");
			Statement st=con.createStatement();
		    st.executeUpdate("insert into login values('"+s1+"','"+s2+"')");
//            st.executeUpdate("insert into regis1(roll,phy,che,maths,hindi) values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
 		response.sendRedirect("login.html");
		out.println("data inserted.....");
		 con.close();
		 }
         catch(Exception e)
		 {
			out.println(e);
		}		
		
	} 
}

