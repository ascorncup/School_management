
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class updateServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            String sid=request.getParameter("id");
            String sub1=request.getParameter("sub1");
            String sub5=request.getParameter("sub5");
            String sub3=request.getParameter("sub3");
            String sub4=request.getParameter("sub4");
            
             //connecting
           Class.forName("com.mysql.jdbc.Driver");
           Connection c=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
           
        
           try{
                //updating
           PreparedStatement p1=c.prepareStatement("Update project set Subject_1=? where ID=?");
           p1.setString(1,sub1);
            p1.setString(2,sid);          
            p1.executeUpdate();
           }
           catch(Exception e)
           {
               
           }
            
           try{
                //updating
           PreparedStatement p2=c.prepareStatement("Update project set Subject_2=? where ID=?");
           p2.setString(1,sub5);
            p2.setString(2,sid);          
            p2.executeUpdate();
           }
           catch(Exception e)
           {
               
           }
          
            
           try
           {
              PreparedStatement p3=c.prepareStatement("Update project set Subject_3=? where ID=?");
           p3.setString(1,sub3);
            p3.setString(2,sid);
            p3.executeUpdate();  
           }
            catch(Exception e)
            {
                
            }
             
           try
           {
                PreparedStatement p4=c.prepareStatement("Update project set Subject_4=? where ID=?");
           p4.setString(1,sub4); 
            p4.setString(2,sid);
            p4.executeUpdate(); 
           }
           catch(Exception e)
           {
               
           }
           response.sendRedirect("teacher_dashboard.html");
            out.println();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
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
            Logger.getLogger(updateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
