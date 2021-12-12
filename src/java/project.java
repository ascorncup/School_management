
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class project extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       
           
//          
              
              
        //retriving
//            Statement sc=c.createStatement();
//            ResultSet rs=sc.executeQuery("select * from company3");
//            while(rs.next())
//            {
//                out.println("Name="+rs.getString(1)+"Age="+rs.getString(2)+"Password="+rs.getString(3)+"<br>");
//            }
//            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet project</title>");    
            out.println("<script>");
            out.println("alert('Inserted successfully')");
            out.println("</script>");
            out.println("</head>");
            out.println("<body>");
            String name=request.getParameter("name");
           String id=request.getParameter("id");
           String subject1=request.getParameter("s1");
           String subject2=request.getParameter("s2");
           String subject3=request.getParameter("s3");
           String subject4=request.getParameter("s4");
           
           out.println("Student Name:"+name+"<br>");
           out.println("Student ID:"+id+"<br><br>");
           out.println("Subject 1:"+subject1+"<br>");
           out.println("Subject 2:"+subject2+"<br>");
           out.println("Subject 3:"+subject3+"<br>");
           out.println("Subject 4:"+subject4+"<br>");
           
           
           //connecting
           Class.forName("com.mysql.jdbc.Driver");
           Connection c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
           out.println("connected");
           out.println();
           
           
           //inserting
            PreparedStatement ps=c.prepareStatement("insert into project values(?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,id);
            ps.setString(3,subject1);
            ps.setString(4,subject2);
            ps.setString(5,subject3);
            ps.setString(6,subject4);
            ps.executeUpdate();
            out.println("inserted");
            out.println();
            response.sendRedirect("teacher_dashboard.html");
           
          
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
