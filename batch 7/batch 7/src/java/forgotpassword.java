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
public class forgotpassword extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String id=req.getParameter("aid");
        String pass=req.getParameter("apassword");
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
            // out.println("Driver is loaded");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lms","root","29H072003*");
            // out.println("Connection successful");
             int l=0;
            PreparedStatement stmt=con.prepareStatement("select aid from adminregistration where aid='"+id+"';");
           ResultSet rs=stmt.executeQuery();
           String dbid=null;
            if(rs.next()){
                 dbid = rs.getString(1);
            }
          // out.print("<br>"+dbmail+"<br>");
           if(id.equals(dbid))
           {
             
                  // out.print("<br> updating...<br>");
              PreparedStatement ps=con.prepareStatement("UPDATE adminregistration" +
             " SET apassword='"+ pass+"'WHERE aid='"+id+"';");
               ps.execute();
               l=1;
               
           }
           if(l==1)
           {
               RequestDispatcher rd=req.getRequestDispatcher("adminlogin.html");
               rd.forward(req, res);
           }
               else{
                 out.println("<h1>"+"sorry try again"+"</h1>");
                RequestDispatcher rd=req.getRequestDispatcher("forgotpassword.html");
               rd.include(req, res);
               }
     
         }
         catch(IOException | ClassNotFoundException | SQLException | ServletException e)
         {
             out.println(e);
         }
       
    }
}    

   
