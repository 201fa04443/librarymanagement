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


public class Publisher extends HttpServlet {

   
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        String a=req.getParameter("a");
        String b=req.getParameter("b");
        String c=req.getParameter("c");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lms","root","29H072003*"))
            {
                String s="insert into publisher values(?,?,?);";
                PreparedStatement stmt=con.prepareStatement(s);
                stmt.setString(1,a);
                stmt.setString(2,b);
                stmt.setString(3,c);
                int i=stmt.executeUpdate();
                out.println("Publisher Added");
            }
               
            }
            catch (SQLException ex) {
               
            }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
