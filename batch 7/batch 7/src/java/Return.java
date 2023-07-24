import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Return extends HttpServlet {

   
    @Override
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
                out.println(a);
             PreparedStatement stmt= con.prepareStatement("delete from status where bid = ?");
              stmt.setString(1, a);
             stmt.executeUpdate();
         int i = stmt.executeUpdate();
         out.println("Returned Successfully"); 
         
            }    
            }
            catch (SQLException ex) { 
            }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Return.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    private int excuteUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
