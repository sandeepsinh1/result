import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import javax.swing.*;
public class register1 extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
			String s1=request.getParameter("ur");
			String s2=request.getParameter("up");
			String s3=request.getParameter("uc");
			String s4=request.getParameter("um");
			String s5=request.getParameter("uh");
			PrintWriter out=response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false","root","root");
			Statement st=con.createStatement();
		    st.executeUpdate("insert into result values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
			//st.executeUpdate("update regis1 set phy='rrr' where roll='gcfcb'");

			out.println("data updated.....");
		 con.close();
		 }
         catch(Exception e)
		 {
			out.println(e);
		}		
		
	} 
}

