import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Adminregistration extends HttpServlet {

   
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String a=req.getParameter("a");
        String b=req.getParameter("b");
        String c=req.getParameter("c");
        String d=req.getParameter("d");
        String e=req.getParameter("e");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lms","root","29H072003*"))
            {
                String s="insert into adminregistration values(?,?,?,?,?);";
                PreparedStatement stmt=con.prepareStatement(s);
                stmt.setString(1,b);
                stmt.setString(2,c);
                stmt.setString(3,d);
                stmt.setString(4,a);
                stmt.setString(5,e);
                int i=stmt.executeUpdate();
                out.println("Registered Successfully,Welcome to the new Admin");     
            }    
            }
            catch (SQLException ex) { 
            }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Adminregistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
