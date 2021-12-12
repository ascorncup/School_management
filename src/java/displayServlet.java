

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class displayServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        
    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servelet4</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"signup_style.css\" />\n" +
"      <link\n" +
"        rel=\"stylesheet\"\n" +
"        href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"\n" +
"      />\n" +
"      <link\n" +
"        href=\"https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600\"\n" +
"        rel=\"stylesheet\"\n" +
"        type=\"text/css\"\n" +
"      />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"table\">");
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
            
            String id = request.getParameter("id");
            Statement stmt = con.createStatement();  
            PreparedStatement ps = con.prepareStatement("select * from project where ID=?");
            ps.setString(1,id);
            //PreparedStatement ps = con.prepareStatement("select * from project ");
            ResultSet rs = ps.executeQuery();  
            out.println("<table border=1 width=50% height=50% style=\"text-align:center\"> ");  
            out.println("<tr><th>StudentName</th><th>StudentID</th><th>Subject-1</th><th>Subject-2</th><th>Subject-3</th><th>Subject-4</th><tr>");
            while(rs.next()){
                String sid = rs.getString(1);
                String sn = rs.getString(2);
                String ss1 = rs.getString(3);
                String ss2 = rs.getString(4);
                String ss3 = rs.getString(5);
                String ss4 = rs.getString(6);
                out.println("<tr><th>"+sid+"</th><th>"+sn+"</th><th>"+ss1+"</th><th>"+ss2+"</th><th>"+ss3+"</th><th>"+ss4+"</th></tr>");
//               out.println("<tr><td>" + rs.getString(1) + "</td><td>" + sn + "</td><td>" + ss1 + "</td><td>" + ss2 + "</td><td>" + ss3 + "</td><td>" + ss4 + "</td></tr>");     
            }
            out.println("<div class=\"login-page\">\n" + "<div class=\"form\">");
            out.println("<form action=\"main_page.html\" method=\"post\">");
            out.println("<button type=\"submit\" value=\"submit\">LOGOUT</button>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(displayServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
