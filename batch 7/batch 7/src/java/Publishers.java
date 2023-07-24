import static java.awt.Color.black;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Publishers extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
     out.println("<title>Publishers</title>");
     out.println("<style>table{\n" +
"  border:solid 5px;\n" +" border-color:black;\n" +"}body{\n" +
"      bgcolor:powderblue;\n" +
"      background-image:url('adminregistration.jpg');\n" +"position:relative;\n"+"left:700px;\n"+"top:50px;\n"+
"      background-repeat:no-repeat;\n" +
"  background-attachment:fixed;\n" +
"  background-size:100% 100%;\n" +
"color:black;\n" +
"}"
             + "</style>");
     out.println("<head>");
    out.println("<body>");
    out.println("<table>");
    out.println("<tr colspan=\"7\">");
    out.println("<td>");
    out.println("<h1><center>Publishers</center></h1>");
    out.println("</td>");
    out.println("</tr>");
    out.println("<tr>");
    out.println("<td>");
    out.println("<p>Pid&nbsp;</p>");
     out.println("</td>");
     out.println("<td>");
out.println("<p>Paddres&nbsp;&nbsp;</p>");
out.println("</td>");
out.println("<td>");
out.println("<p>Pname&nbsp;&nbsp;</p>");
out.println("</td>");
    out.println("</tr>");
    Connection conn = null;
    Statement stmt = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost/lms","root","29H072003*");
      stmt = conn.createStatement();
     
      String query;
        query = "select * from publisher";
              ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
      String Pid = rs.getString("pid");
        String Paddress = rs.getString("paddress");
        String Pname = rs.getString("pname");
        out.println("<tr>");
            out.println("<td>") ;   
        out.print( Pid);
         out.println("</td>") ;
        out.println("<td>") ;   
        out.print(Paddress);
         out.println("</td>") ;
        out.println("<td>") ;   
        out.print(Pname);
         out.println("</td>") ;
         out.println("</tr>");
      }
      out.println("</table>");
    } catch (SQLException e) {
      out.println("An error occured while retrieving " + "all Publishers: " 
          + e.toString());
    } catch (ClassNotFoundException e) {
      throw (new ServletException(e.toString()));
    } finally {
      try {
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException ex) {
      }
    }
    out.println("</center>");
    out.println("</body>");
    out.println("</html>");
    out.close();
  }
}