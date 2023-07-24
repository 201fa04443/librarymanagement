import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Adminlogin extends HttpServlet {
   
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String admin=req.getParameter("aid");
        String pass=req.getParameter("apassword");
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lms","root","29H072003*");
            PreparedStatement stmt=con.prepareStatement("select apassword from adminregistration where aid='"+admin+"';");
           ResultSet rs=stmt.executeQuery();
           String dbpass=null;
          if( rs.next()){
           dbpass = rs.getString(1);
          }
           int l=1;
           if(pass.equals(dbpass))
           {
               l=0;
           }
           if(l==0)
           {
               RequestDispatcher rd=req.getRequestDispatcher("Adminnav.html");
               rd.forward(req, res);
           }
           else
           {
               out.println("<h1>"+"sorry.... invalid username or password"+"</h1>");
               RequestDispatcher rd=req.getRequestDispatcher("adminlogin.html");
               rd.include(req, res);
           }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            out.println(e);
        }
       
             
    }

   
}
